package cn.wellswang.servlet;

import cn.wellswang.dao.BadInfoDAO;
import cn.wellswang.dao.impl.BadInfoDAOImpl;
import cn.wellswang.dao.impl.GoodsInfoDAOImpl;
import cn.wellswang.dao.impl.SupplierInfoDAOImpl;
import cn.wellswang.entity.Order;
import cn.wellswang.entity.Record;
import cn.wellswang.entity.Supplier;
import cn.wellswang.service.CheckOrderService;
import cn.wellswang.service.GoodsInService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 入库需求
 *  1. 订单 被检查过后 state = 2
 *  2. 入库数量 = 订单库存 - 不合格箱数
 *  3. 修改商品数量
 *  3. 状态改变 state = 3
 *  4. 保存入库记录
 */
@WebServlet("/goodsIn")
public class GoodsInServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=utf-8");

        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "*");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "*");
        response.setHeader("Access-Control-Allow-Credentials", "true");

        Integer orderId = Integer.parseInt(request.getParameter("order_id"));
        Order returnOrder = CheckOrderService.getOrderById(orderId);
        PrintWriter writer = response.getWriter();
        // 1.
        if(returnOrder.getOrderStatus() != 2) {
            // 重定向
            writer.print("<script>alert('入库失败，该订单已经被入库')</script>");
            writer.print("<script>window.location.href='./html/purchase/in.html'</script>");
            return;
        }
        GoodsInfoDAOImpl g = new GoodsInfoDAOImpl();
        SupplierInfoDAOImpl s = new SupplierInfoDAOImpl();
        BadInfoDAO b = new BadInfoDAOImpl();
        Supplier returnSupplier = s.getSupplierById(returnOrder.getSupplierId());
        CheckOrderDataServlet c = new CheckOrderDataServlet();
        String goodsSku = returnOrder.getGoodsSku();
        Integer userId = LoginServlet.staticManId;
        Integer supplierId = returnSupplier.getSupplierId();
        // 2.
        Integer goodsBoxNumber = returnOrder.getOrderBoxNumber();
        Integer badBoxNumber = b.getBadByOrder(returnOrder.getOrderId()).getBadBoxNumber();
        Integer inBoxNumberInFact = goodsBoxNumber - badBoxNumber;
        Integer badsBoxNumber = GoodsInService.getBadsBoxNumberByOrderId(orderId);
        Integer goodsNumber = goodsBoxNumber - badsBoxNumber;
        String recordTime = request.getParameter("record_time");
        // 3.
        GoodsInService.modifyGoodsBoxNumber(goodsSku, inBoxNumberInFact);
        // 4.
        GoodsInService.modifyStates(orderId, 3);
        // 5.
        Record newRecord = new Record();
        newRecord.setManId(userId);
        newRecord.setOrderId(orderId);
        newRecord.setGoodsSku(goodsSku);
        newRecord.setSupplierId(supplierId);
        newRecord.setGoodsNumber(goodsNumber);
        newRecord.setRecordType(1);
        newRecord.setRecordTime(recordTime);
        GoodsInService.saveRecord(newRecord);

        // 重定向
        writer.print("<script>alert('入库失败，该订单已经被入库')</script>");
        writer.print("<script>window.location.href='./html/purchase/inGoodsManagement.html'</script>");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
