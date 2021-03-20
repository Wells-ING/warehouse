package cn.wellswang.service;

import cn.wellswang.dao.OrderInfoDAO;
import cn.wellswang.dao.impl.OrderInfoDAOImpl;

public class DeleteOrderService {

    public static Integer getOrderStatusById(Integer orderId) {
        OrderInfoDAO o = new OrderInfoDAOImpl();
        return o.getOrderById(orderId).getOrderStatus();
    }

    public static Integer deleteOrderById(Integer orderId) {
        OrderInfoDAO o = new OrderInfoDAOImpl();
        return o.deleteOrderById(orderId);
    }
}
