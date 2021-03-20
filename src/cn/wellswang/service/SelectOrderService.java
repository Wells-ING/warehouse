package cn.wellswang.service;

import cn.wellswang.dao.impl.OrderInfoDAOImpl;
import cn.wellswang.dao.impl.SupplierInfoDAOImpl;
import cn.wellswang.entity.Goods;
import cn.wellswang.entity.Order;
import cn.wellswang.entity.OrderPage;
import cn.wellswang.entity.Supplier;

import java.util.ArrayList;

public class SelectOrderService {
    public static ArrayList<OrderPage> getOrdersByLike(String keyWords) {

        ArrayList<OrderPage> orderPages = new ArrayList<OrderPage>();

        ArrayList<Goods> goods = SelectGoodsService.getGoodsByLike(keyWords);

        OrderInfoDAOImpl o = new OrderInfoDAOImpl();
        SupplierInfoDAOImpl s = new SupplierInfoDAOImpl();

        for(Goods g : goods) {
            ArrayList<Order> orderArrayList = o.getOrdersByGoodsSku(g.getGoodsSku());
            for(Order order : orderArrayList) {
                OrderPage currentOrderPage = new OrderPage();
                Supplier supplier = s.getSupplierById(order.getSupplierId());
                currentOrderPage.setOrderId(order.getOrderId());
                currentOrderPage.setGoodsSku(order.getGoodsSku());
                currentOrderPage.setGoodsName(g.getGoodsName());
                currentOrderPage.setGoodsNumberEachBox(g.getGoodsNumberEachBox());
                currentOrderPage.setOrderBoxNumber(order.getOrderBoxNumber());
                currentOrderPage.setSumNumber(g.getGoodsNumberEachBox() * order.getOrderBoxNumber());
                currentOrderPage.setGoodsEachPrice(g.getGoodsEachPrice());
                currentOrderPage.setGoodsSumPrice(g.getGoodsEachPrice() * g.getGoodsNumberEachBox() * order.getOrderBoxNumber());
                currentOrderPage.setOrderFreight(order.getOrderFreight());
                currentOrderPage.setOrderDeposit(order.getOrderDeposit());
                currentOrderPage.setOrderSumPrice(order.getOrderFreight() + order.getOrderDeposit());
                currentOrderPage.setSupplierName(supplier.getSupplierName());
                currentOrderPage.setOrderTime(order.getOrderTime());
                currentOrderPage.setOrderStatus(order.getSupplierId());
                orderPages.add(currentOrderPage);
            }
        }
        return orderPages;
    }
}
