package cn.wellswang.service;

import cn.wellswang.dao.impl.GoodsInfoDAOImpl;
import cn.wellswang.dao.impl.OrderInfoDAOImpl;
import cn.wellswang.dao.impl.SupplierInfoDAOImpl;
import cn.wellswang.entity.Goods;
import cn.wellswang.entity.Order;
import cn.wellswang.entity.OrderPage;
import cn.wellswang.entity.Supplier;

import java.util.ArrayList;

public class SelectAllInOrderService {
    public static ArrayList<OrderPage> getAllOrderPageResultByCurrentManagerId(Integer currentManagerId) {
        OrderInfoDAOImpl o = new OrderInfoDAOImpl();
        GoodsInfoDAOImpl g = new GoodsInfoDAOImpl();
        SupplierInfoDAOImpl s = new SupplierInfoDAOImpl();
        ArrayList<OrderPage> orderPages = new ArrayList<OrderPage>();
        ArrayList<Order> orders = o.getAllByCurrentManagerId(currentManagerId);
        for(Order order : orders) {
            OrderPage currentOrderPage = new OrderPage();
            Goods goods = g.getGoodsById(order.getGoodsSku());
            Supplier supplier = s.getSupplierById(order.getSupplierId());
            currentOrderPage.setOrderId(order.getOrderId());
            currentOrderPage.setGoodsSku(order.getGoodsSku());
            currentOrderPage.setGoodsName(goods.getGoodsName());
            currentOrderPage.setGoodsNumberEachBox(goods.getGoodsNumberEachBox());
            currentOrderPage.setOrderBoxNumber(order.getOrderBoxNumber());
            currentOrderPage.setSumNumber(goods.getGoodsNumberEachBox() * order.getOrderBoxNumber());
            currentOrderPage.setGoodsEachPrice(goods.getGoodsEachPrice());
            currentOrderPage.setGoodsSumPrice(goods.getGoodsEachPrice() * goods.getGoodsNumberEachBox() * order.getOrderBoxNumber());
            currentOrderPage.setOrderFreight(order.getOrderFreight());
            currentOrderPage.setOrderDeposit(order.getOrderDeposit());
            currentOrderPage.setOrderSumPrice(order.getOrderFreight() + order.getOrderDeposit());
            currentOrderPage.setSupplierName(supplier.getSupplierName());
            currentOrderPage.setOrderTime(order.getOrderTime());
            currentOrderPage.setOrderStatus(order.getOrderStatus());
            orderPages.add(currentOrderPage);
        }
        return orderPages;
    }
}
