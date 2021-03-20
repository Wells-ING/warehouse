package cn.wellswang.service;

import cn.wellswang.dao.impl.ManagerInfoDAOImpl;
import cn.wellswang.entity.Manager;

public class ManagerAddService {
    public static Integer managerAdd(Manager newManager) {
        ManagerInfoDAOImpl m = new ManagerInfoDAOImpl();
        return m.insertManagerInfo(newManager);
    }
}
