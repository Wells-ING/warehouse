package cn.wellswang.service;

import cn.wellswang.dao.BadInfoDAO;
import cn.wellswang.dao.GoodsInfoDAO;
import cn.wellswang.dao.ManagerInfoDAO;
import cn.wellswang.dao.OrderInfoDAO;
import cn.wellswang.dao.impl.BadInfoDAOImpl;
import cn.wellswang.dao.impl.GoodsInfoDAOImpl;
import cn.wellswang.dao.impl.ManagerInfoDAOImpl;
import cn.wellswang.dao.impl.OrderInfoDAOImpl;
import cn.wellswang.entity.Goods;

public class ModifyBadService {
    public static Integer getBadBoxNumberById(Integer badId) {
        BadInfoDAO b = new BadInfoDAOImpl();
        return b.getBadBoxNumberById(badId);
    }

    public static Integer getBoxNumberOfOrderByOrderId(Integer orderId) {
        OrderInfoDAO o = new OrderInfoDAOImpl();
        return o.getBoxNumberByOrderId(orderId);
    }

    public static Integer isExitOfManagerName(String managerName) {
        ManagerInfoDAO m = new ManagerInfoDAOImpl();
        return m.getManagerIdByName(managerName);
    }

    public static Integer modifyBadById(Integer badId, Integer badBoxNumber, String badDecoration, String managerName) {
        BadInfoDAO b = new BadInfoDAOImpl();
        ManagerInfoDAO m = new ManagerInfoDAOImpl();
        Integer managerId = m.getManagerIdByName(managerName);
        return b.mofiyBadById(badId, badBoxNumber, badDecoration, managerId);
    }

    public static Integer modifyGoodsBoxNumber(Integer orderId, Integer badBoxNumberInFact, Integer badBoxNumber) {
        GoodsInfoDAO g = new GoodsInfoDAOImpl();
        OrderInfoDAO o = new OrderInfoDAOImpl();

        Integer difference = badBoxNumberInFact - badBoxNumber;

        String currentGoodsSku = o.getOrderById(orderId).getGoodsSku();
        Goods currentGoods = g.getGoodsById(currentGoodsSku);

        Integer newGoodsBoxNumber = currentGoods.getGoodsBoxNumber() + difference;

        return g.modifyGoodsBoxNumber(currentGoodsSku, newGoodsBoxNumber);
    }
}
