package cn.wellswang.servlet;

import cn.wellswang.entity.Goods;
import cn.wellswang.entity.Order;
import cn.wellswang.service.GoodsAddService;
import cn.wellswang.service.ModifyOrderService;
import cn.wellswang.service.OrderGoodsService;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/orderGoods")
public class OrderGoodsServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=utf-8");

        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "*");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "*");
        response.setHeader("Access-Control-Allow-Credentials", "true");

        String goodsName = request.getParameter("goodsName");
        Integer goodsNumberEachBox = Integer.parseInt(request.getParameter("goodsNumberEachBox"));
        Double goodsEachPrice = Double.parseDouble(request.getParameter("goodsEachPrice"));
        Double goodsEachWeight = Double.parseDouble(request.getParameter("goodsEachWeight"));
        String goodsBarCode = request.getParameter("goodsBarCode");
        String goodsMaterial = request.getParameter("goodsMaterial");
        Double boxLength = Double.parseDouble(request.getParameter("boxLength"));
        Double boxWidth = Double.parseDouble(request.getParameter("boxWidth"));
        Double boxHeight = Double.parseDouble(request.getParameter("boxHeight"));

        String goodsSku = request.getParameter("goodsSku");
        Integer userId = LoginServlet.staticManId;
        Double orderDeposit = Double.parseDouble(request.getParameter("orderDeposit"));
        Double orderFreight = Double.parseDouble(request.getParameter("orderFreight"));
        String orderTime = request.getParameter("orderTime");
        Integer goodsBoxNumber = Integer.parseInt(request.getParameter("goodsBoxNumber"));
        String supplierName = request.getParameter("supplierName");

        Order newOrder = new Order();
        newOrder.setGoodsSku(goodsSku);
        newOrder.setOrderBoxNumber(goodsBoxNumber);
        newOrder.setOrderDeposit(orderDeposit);
        newOrder.setOrderFreight(orderFreight);
        newOrder.setOrderTime(orderTime);
        newOrder.setManId(userId);
        newOrder.setOrderStatus(0);
        newOrder.setSupplierId(OrderGoodsService.getIdBySupplierName(supplierName));

        JSONObject orderAddMsg = new JSONObject();
        Boolean flag = OrderGoodsService.goodsIsExist(goodsSku);
        if(flag) {

        } else {
            Goods newGoods = new Goods();
            newGoods.setGoodsSku(goodsSku);
            newGoods.setGoodsName(goodsName);
            newGoods.setGoodsNumberEachBox(goodsNumberEachBox);
            newGoods.setGoodsEachPrice(goodsEachPrice);
            newGoods.setGoodsEachWeight(goodsEachWeight);
            newGoods.setBoxLength(boxLength);
            newGoods.setBoxWidth(boxWidth);
            newGoods.setBoxHeight(boxHeight);
            newGoods.setGoodsBoxNumber(0);
            newGoods.setGoodsBarCode(goodsBarCode);
            newGoods.setGoodsMaterial(goodsMaterial);

            GoodsAddService.GoodsAdd(newGoods);
        }

        Integer supplierId = ModifyOrderService.isExitOfSupplierName(supplierName);
        if(supplierId != null) {
            Integer count = OrderGoodsService.orderGoods(newOrder);
            if(count > 0) {
                orderAddMsg.put("isSuccess", true);
                orderAddMsg.put("successMsg", "订单新增成功");
            } else {
                orderAddMsg.put("isSuccess", false);
                orderAddMsg.put("errorMsg", "订单新增失败");
            }
        } else {
            orderAddMsg.put("isSuccess", false);
            orderAddMsg.put("errorMsg", "订单新增失败，不存在该供应商");
            orderAddMsg.put("isExitOfManager", false);
        }
        response.getWriter().append(orderAddMsg.toString());
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
