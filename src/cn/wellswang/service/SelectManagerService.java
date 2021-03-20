package cn.wellswang.service;

import cn.wellswang.dao.ManagerInfoDAO;
import cn.wellswang.dao.impl.ManagerInfoDAOImpl;
import cn.wellswang.entity.Manager;

import java.util.ArrayList;

public class SelectManagerService {
    public static ArrayList<Manager> getManagerByLike(String keyWords) {
        ManagerInfoDAO m = new ManagerInfoDAOImpl();
        return m.getManagerByLike(keyWords);
    }
}
