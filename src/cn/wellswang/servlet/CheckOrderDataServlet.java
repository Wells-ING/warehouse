package cn.wellswang.servlet;

import cn.wellswang.dao.impl.GoodsInfoDAOImpl;
import cn.wellswang.dao.impl.SupplierInfoDAOImpl;
import cn.wellswang.entity.Goods;
import cn.wellswang.entity.Order;
import cn.wellswang.entity.Supplier;
import cn.wellswang.service.CheckOrderService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/OrderData")
public class CheckOrderDataServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置编码
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=utf-8");
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "*");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "*");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        Integer orderId = Integer.parseInt(request.getParameter("order_id"));
        Order returnOrder = CheckOrderService.getOrderById(orderId);
        GoodsInfoDAOImpl g = new GoodsInfoDAOImpl();
        SupplierInfoDAOImpl s = new SupplierInfoDAOImpl();
        Goods returnGoods = g.getGoodsById(returnOrder.getGoodsSku());
        Supplier returnSupplier = s.getSupplierById(returnOrder.getSupplierId());
        CheckOrderDataServlet c = new CheckOrderDataServlet();
        String json="";
        if(returnOrder.getOrderId() != null) {
            json="{"
                    + "\"goods_sku\" : \"" + returnOrder.getGoodsSku() + "\", "
                    + "\"goods_name\" : \"" + returnGoods.getGoodsName() + "\", "
                    + "\"goods_numberEachBox\" : \"" + returnGoods.getGoodsNumberEachBox() + "\", "
                    + "\"goods_boxNumber\" : \"" + returnOrder.getOrderBoxNumber() + "\", "
                    + "\"goods_eachPrice\" : \"" + returnGoods.getGoodsEachPrice() + "\", "
                    + "\"order_deposit\" : \"" + returnOrder.getOrderDeposit() + "\", "
                    + "\"order_freight\" : \"" + returnOrder.getOrderFreight() + "\", "
                    + "\"supplier_name\" : \"" + returnSupplier.getSupplierName() + "\", "
                    + "\"order_time\" : \"" + returnOrder.getOrderTime() + "\""
                    + "}";
        } else {
            json = "{}";
        }
        //返回数据
        response.getWriter().append(json);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
