package cn.wellswang.service;

import cn.wellswang.dao.SupplierInfoDAO;
import cn.wellswang.dao.impl.SupplierInfoDAOImpl;
import cn.wellswang.entity.Supplier;

import java.util.ArrayList;

public class SelectAllSupplierService {
    public static ArrayList<Supplier> getAllSuppliers() {
        SupplierInfoDAO s = new SupplierInfoDAOImpl();
        return s.getAll();
    }
}
