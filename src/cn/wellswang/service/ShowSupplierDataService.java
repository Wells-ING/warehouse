package cn.wellswang.service;

import cn.wellswang.dao.SupplierInfoDAO;
import cn.wellswang.dao.impl.SupplierInfoDAOImpl;
import cn.wellswang.entity.Supplier;

public class ShowSupplierDataService {
    public static Supplier getSupplierById(Integer supplierId) {
        SupplierInfoDAO s = new SupplierInfoDAOImpl();
        return s.getSupplierById(supplierId);
    }
}
