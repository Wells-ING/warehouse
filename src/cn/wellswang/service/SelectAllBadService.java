package cn.wellswang.service;

import cn.wellswang.dao.impl.BadInfoDAOImpl;
import cn.wellswang.dao.impl.GoodsInfoDAOImpl;
import cn.wellswang.dao.impl.ManagerInfoDAOImpl;
import cn.wellswang.dao.impl.OrderInfoDAOImpl;
import cn.wellswang.entity.Bad;
import cn.wellswang.entity.BadPage;
import cn.wellswang.entity.Goods;
import cn.wellswang.entity.Order;

import java.util.ArrayList;


public class SelectAllBadService {
    public static ArrayList<BadPage> getAllBadPageResult() {
        BadInfoDAOImpl b = new BadInfoDAOImpl();
        GoodsInfoDAOImpl g = new GoodsInfoDAOImpl();
        OrderInfoDAOImpl o = new OrderInfoDAOImpl();
        ManagerInfoDAOImpl m = new ManagerInfoDAOImpl();
        ArrayList<BadPage> badPages = new ArrayList<BadPage>();
        ArrayList<Bad> bads = b.getAll();
        for(Bad bad : bads) {
            BadPage currentBadPage = new BadPage();
            Order currentOrder = o.getOrderById(bad.getOrderId());
            Goods goods = g.getGoodsById(currentOrder.getGoodsSku());
            String ManagerName = m.getCurrentuserName(bad.getManId());
            currentBadPage.setBadId(bad.getBadId());
            currentBadPage.setOrderId(bad.getOrderId());
            currentBadPage.setGoodsSku(goods.getGoodsSku());
            currentBadPage.setGoodsName(goods.getGoodsName());
            currentBadPage.setManagerName(ManagerName);
            currentBadPage.setBadBoxNumber(bad.getBadBoxNumber());
            currentBadPage.setBadDecoration(bad.getBadDecoration());
            badPages.add(currentBadPage);
        }
        return badPages;
    }
}
