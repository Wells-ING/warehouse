package cn.wellswang.service;

import cn.wellswang.dao.ManagerInfoDAO;
import cn.wellswang.dao.impl.ManagerInfoDAOImpl;

public class DeleteManagerService {
    public static Integer deleteManagerById(Integer managerId) {
        ManagerInfoDAO m = new ManagerInfoDAOImpl();
        return m.deleteManagerById(managerId);
    }
}
