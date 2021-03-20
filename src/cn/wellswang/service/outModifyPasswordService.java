package cn.wellswang.service;

import cn.wellswang.dao.ManagerInfoDAO;
import cn.wellswang.dao.impl.ManagerInfoDAOImpl;

public class outModifyPasswordService {

    public static void modifyPassword(Integer managerId, String oldPassword, String newPassword) {
        ManagerInfoDAO m = new ManagerInfoDAOImpl();
        m.modifyPassword(managerId, oldPassword, newPassword);
    }
}
