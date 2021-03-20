package cn.wellswang.service;

import cn.wellswang.dao.SupplierInfoDAO;
import cn.wellswang.dao.impl.SupplierInfoDAOImpl;
import cn.wellswang.entity.Supplier;

import java.util.ArrayList;

public class SelectSupplierService {
    public static ArrayList<Supplier> getSupplierByLike(String keyWords) {
        SupplierInfoDAO s = new SupplierInfoDAOImpl();
        return s.getSupplierByLike(keyWords);
    }
}
