package cn.wellswang.service;

import cn.wellswang.dao.ManagerInfoDAO;
import cn.wellswang.dao.impl.ManagerInfoDAOImpl;

public class purchaseModifyPasswordService {

    public static boolean purchaseModifyPassword(Integer currentManager, String newPassword) {
        ManagerInfoDAO m = new ManagerInfoDAOImpl();
        return m.modifyPassword(currentManager, newPassword);
    }

    public static boolean isTruePassword(Integer currentManager, String oldPassword) {
        ManagerInfoDAO m = new ManagerInfoDAOImpl();
        return m.isTruePassword(currentManager, oldPassword);
    }
}
