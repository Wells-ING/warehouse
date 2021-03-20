package cn.wellswang.service;

import cn.wellswang.dao.OrderInfoDAO;
import cn.wellswang.dao.SupplierInfoDAO;
import cn.wellswang.dao.impl.OrderInfoDAOImpl;
import cn.wellswang.dao.impl.SupplierInfoDAOImpl;

public class ModifyOrderService {
    public static Integer isExitOfSupplierName(String supplierName) {
        SupplierInfoDAO s = new SupplierInfoDAOImpl();
        return s.getIdByName(supplierName);
    }

    public static Integer modifyOrderById(Integer orderId, Double orderFreight, Double orderDeposit, String orderTime, Integer supplierId) {
        OrderInfoDAO o = new OrderInfoDAOImpl();
        return o.modifyOrderById(orderId, orderFreight, orderDeposit, orderTime, supplierId);
    }
}
