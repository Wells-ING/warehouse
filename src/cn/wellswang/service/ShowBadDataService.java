package cn.wellswang.service;

import cn.wellswang.dao.BadInfoDAO;
import cn.wellswang.dao.GoodsInfoDAO;
import cn.wellswang.dao.ManagerInfoDAO;
import cn.wellswang.dao.OrderInfoDAO;
import cn.wellswang.dao.impl.BadInfoDAOImpl;
import cn.wellswang.dao.impl.GoodsInfoDAOImpl;
import cn.wellswang.dao.impl.ManagerInfoDAOImpl;
import cn.wellswang.dao.impl.OrderInfoDAOImpl;
import cn.wellswang.entity.Bad;
import cn.wellswang.entity.BadPage;

public class ShowBadDataService {
    public static BadPage getBadPagesByBadId(Integer badId) {
        BadPage badPage = new BadPage();

        BadInfoDAO b = new BadInfoDAOImpl();
        GoodsInfoDAO g = new GoodsInfoDAOImpl();
        OrderInfoDAO o = new OrderInfoDAOImpl();
        ManagerInfoDAO m = new ManagerInfoDAOImpl();
        Bad bad = b.getBadById(badId);
        badPage.setBadId(bad.getBadId());
        badPage.setOrderId(bad.getOrderId());
        badPage.setGoodsSku(o.getOrderById(bad.getOrderId()).getGoodsSku());
        badPage.setGoodsName(g.getGoodsName(o.getOrderById(bad.getOrderId()).getGoodsSku()));
        badPage.setManagerName(m.getCurrentuserName(bad.getManId()));
        badPage.setBadBoxNumber(bad.getBadBoxNumber());
        badPage.setBadDecoration(bad.getBadDecoration());
        return badPage;
    }
}
