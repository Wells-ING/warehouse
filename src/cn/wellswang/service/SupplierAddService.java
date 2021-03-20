package cn.wellswang.service;


import cn.wellswang.dao.impl.SupplierInfoDAOImpl;
import cn.wellswang.entity.Supplier;

public class SupplierAddService {
    public static Integer supplierAdd(Supplier newSupplier) {
        SupplierInfoDAOImpl s = new SupplierInfoDAOImpl();
        return s.insertSupplierInfo(newSupplier);
    }
}
