package cn.wellswang.service;

import cn.wellswang.dao.impl.ManagerInfoDAOImpl;

public class IndexNameService {
    public static String getCurrentUserName(Integer id) {
        ManagerInfoDAOImpl m = new ManagerInfoDAOImpl();
        return m.getCurrentuserName(id);
    }
}
