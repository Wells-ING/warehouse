package cn.wellswang.service;

import cn.wellswang.dao.impl.GoodsInfoDAOImpl;
import cn.wellswang.dao.impl.OrderInfoDAOImpl;
import cn.wellswang.dao.impl.SupplierInfoDAOImpl;
import cn.wellswang.entity.Goods;
import cn.wellswang.entity.Order;

public class OrderGoodsService {
    public static Integer orderGoods(Order newOrder) {
        OrderInfoDAOImpl o = new OrderInfoDAOImpl();
        return o.insertOrderInfo(newOrder);
    }

    public static Boolean goodsIsExist(String goodsSku) {
        GoodsInfoDAOImpl g = new GoodsInfoDAOImpl();
        return g.isExit(goodsSku);
    }

    public static Goods getGoodsByGoodsSku(String goodsSku) {
        GoodsInfoDAOImpl g = new GoodsInfoDAOImpl();
        return g.getGoodsById(goodsSku);
    }

    public static Integer getIdBySupplierName(String supplierName) {
        SupplierInfoDAOImpl s = new SupplierInfoDAOImpl();
        return s.getIdByName(supplierName);
    }
}
