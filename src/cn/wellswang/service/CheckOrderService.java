package cn.wellswang.service;

import cn.wellswang.dao.impl.BadInfoDAOImpl;
import cn.wellswang.dao.impl.OrderInfoDAOImpl;
import cn.wellswang.entity.Bad;
import cn.wellswang.entity.Order;

public class CheckOrderService {
    public static Order getOrderById(Integer orderId) {
        OrderInfoDAOImpl o = new OrderInfoDAOImpl();
        return o.getOrderById(orderId);
    }
    public static Integer saveBads(Bad bad) {
        BadInfoDAOImpl b = new BadInfoDAOImpl();
        return b.insertBadInfo(bad);
    }

    public static void modifyOrder(Integer orderId, Integer state) {
        OrderInfoDAOImpl o = new OrderInfoDAOImpl();
        o.modifyOrderState(orderId, state);
    }
}
