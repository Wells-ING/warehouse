package cn.wellswang.service;

import cn.wellswang.dao.ManagerInfoDAO;
import cn.wellswang.dao.impl.ManagerInfoDAOImpl;
import cn.wellswang.entity.Manager;

public class ShowManagerDataService {
    public static Manager getManagersById(Integer managerId) {
        ManagerInfoDAO m = new ManagerInfoDAOImpl();
        return m.getManagerById(managerId);
    }
}
