package cn.wellswang.service;

import cn.wellswang.dao.ManagerInfoDAO;
import cn.wellswang.dao.impl.ManagerInfoDAOImpl;
import cn.wellswang.entity.Manager;

import java.util.ArrayList;

public class SelectAllManagerService {
    public static ArrayList<Manager> getAllManagers() {
        ManagerInfoDAO m = new ManagerInfoDAOImpl();
        return m.getAll();
    }
}
