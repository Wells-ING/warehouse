package cn.wellswang.service;

import cn.wellswang.dao.BadInfoDAO;
import cn.wellswang.dao.impl.BadInfoDAOImpl;

public class DeleteBadService {

    public static Integer deleteBadByBadId(Integer badId) {
        BadInfoDAO b = new BadInfoDAOImpl();
        return b.deleteBadByBadId(badId);
    }
}
