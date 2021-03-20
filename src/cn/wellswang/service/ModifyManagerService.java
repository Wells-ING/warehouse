package cn.wellswang.service;

import cn.wellswang.dao.ManagerInfoDAO;
import cn.wellswang.dao.impl.ManagerInfoDAOImpl;

public class ModifyManagerService {
    public static Integer modifyManager(Integer manId, String manName, String manPassword, Integer manType) {
        ManagerInfoDAO m = new ManagerInfoDAOImpl();
        return m.modifyManagerById(manId, manName, manPassword, manType);
    }
}
