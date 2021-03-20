package cn.wellswang.service;

import cn.wellswang.dao.SupplierInfoDAO;
import cn.wellswang.dao.impl.SupplierInfoDAOImpl;

public class DeleteSupplierService {
    public static Integer deleteSupplierById(Integer supplierId) {
        SupplierInfoDAO s = new SupplierInfoDAOImpl();
        return s.deleteSupplierById(supplierId);
    }
}
