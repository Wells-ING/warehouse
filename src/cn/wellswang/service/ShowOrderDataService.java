package cn.wellswang.service;

import cn.wellswang.dao.GoodsInfoDAO;
import cn.wellswang.dao.OrderInfoDAO;
import cn.wellswang.dao.SupplierInfoDAO;
import cn.wellswang.dao.impl.GoodsInfoDAOImpl;
import cn.wellswang.dao.impl.OrderInfoDAOImpl;
import cn.wellswang.dao.impl.SupplierInfoDAOImpl;
import cn.wellswang.entity.Goods;
import cn.wellswang.entity.Order;
import cn.wellswang.entity.OrderPage;
import cn.wellswang.entity.Supplier;

public class ShowOrderDataService {
    public static OrderPage getOrderPageByOrderId(Integer orderId) {
        OrderPage orderPage = new OrderPage();

        GoodsInfoDAO g = new GoodsInfoDAOImpl();
        SupplierInfoDAO s = new SupplierInfoDAOImpl();
        OrderInfoDAO o = new OrderInfoDAOImpl();

        Order order = o.getOrderById(orderId);
        Goods goods = g.getGoodsById(order.getGoodsSku());
        Supplier supplier = s.getSupplierById(order.getSupplierId());

        orderPage.setOrderId(order.getOrderId());
        orderPage.setGoodsSku(order.getGoodsSku());
        orderPage.setGoodsName(goods.getGoodsName());
        orderPage.setGoodsNumberEachBox(goods.getGoodsNumberEachBox());
        orderPage.setOrderBoxNumber(order.getOrderBoxNumber());
        orderPage.setSumNumber(goods.getGoodsNumberEachBox() * order.getOrderBoxNumber());
        orderPage.setGoodsEachPrice(goods.getGoodsEachPrice());
        orderPage.setGoodsSumPrice(goods.getGoodsEachPrice() * goods.getGoodsNumberEachBox() * order.getOrderBoxNumber());
        orderPage.setOrderFreight(order.getOrderFreight());
        orderPage.setOrderDeposit(order.getOrderDeposit());
        orderPage.setOrderSumPrice(order.getOrderFreight() + order.getOrderDeposit());
        orderPage.setSupplierName(supplier.getSupplierName());
        orderPage.setOrderTime(order.getOrderTime());
        orderPage.setOrderStatus(order.getOrderStatus());

        return orderPage;
    }
}
