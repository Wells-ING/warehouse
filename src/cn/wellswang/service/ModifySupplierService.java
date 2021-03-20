package cn.wellswang.service;

import cn.wellswang.dao.SupplierInfoDAO;
import cn.wellswang.dao.impl.SupplierInfoDAOImpl;

public class ModifySupplierService {
    public static Integer modifySupplier(Integer supplierId, String supplierName) {
        SupplierInfoDAO s = new SupplierInfoDAOImpl();
        return s.modifySupplierById(supplierId, supplierName);
    }
}
