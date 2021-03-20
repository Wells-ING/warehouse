package cn.wellswang.service;

import cn.wellswang.dao.impl.ManagerInfoDAOImpl;

public class LoginService {
    public static boolean login(int type, int id, String passWord) {
        boolean flag;
        ManagerInfoDAOImpl m = new ManagerInfoDAOImpl();
        flag = m.login(type, id, passWord);
        return flag;
    }
}
