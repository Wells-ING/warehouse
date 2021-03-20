package cn.wellswang.service;

import cn.wellswang.dao.BadInfoDAO;
import cn.wellswang.dao.ManagerInfoDAO;
import cn.wellswang.dao.OrderInfoDAO;
import cn.wellswang.dao.impl.BadInfoDAOImpl;
import cn.wellswang.dao.impl.ManagerInfoDAOImpl;
import cn.wellswang.dao.impl.OrderInfoDAOImpl;
import cn.wellswang.entity.Bad;
import cn.wellswang.entity.BadPage;
import cn.wellswang.entity.Goods;
import cn.wellswang.entity.Order;

import java.util.ArrayList;

public class SelectInBadService {
    public static ArrayList<BadPage> getBadPageResultByLikeAndCurrentManagerId(Integer currentManagerId, String keyWords) {
        ArrayList<BadPage> badPages = new ArrayList<BadPage>();
        ArrayList<Goods> goods = SelectGoodsService.getGoodsByLike(keyWords);
        OrderInfoDAO o = new OrderInfoDAOImpl();
        BadInfoDAO b = new BadInfoDAOImpl();
        ManagerInfoDAO m = new ManagerInfoDAOImpl();
        for(Goods g : goods) {
            ArrayList<Order> orderArrayList = o.getOrdersByGoodsSku(g.getGoodsSku());
            for(Order order : orderArrayList) {
                Bad bad = b.getBadByOrderAndCurrentManagerId(currentManagerId, order.getOrderId());
                if(bad.getBadId() != null) {
                    BadPage currentBadPage = new BadPage();
                    currentBadPage.setBadId(bad.getBadId());
                    currentBadPage.setOrderId(order.getOrderId());
                    currentBadPage.setGoodsSku(g.getGoodsSku());
                    currentBadPage.setGoodsName(g.getGoodsName());
                    currentBadPage.setManagerName(m.getCurrentuserName(order.getManId()));
                    currentBadPage.setBadBoxNumber(bad.getBadBoxNumber());
                    currentBadPage.setBadDecoration(bad.getBadDecoration());
                    badPages.add(currentBadPage);
                }
            }
        }
        return badPages;
    }
}
