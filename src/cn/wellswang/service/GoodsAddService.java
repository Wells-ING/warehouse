package cn.wellswang.service;

import cn.wellswang.dao.impl.GoodsInfoDAOImpl;
import cn.wellswang.entity.Goods;

public class GoodsAddService {
    public static Integer GoodsAdd(Goods newGoods) {
        GoodsInfoDAOImpl g = new GoodsInfoDAOImpl();
        return g.insertGoodsInfo(newGoods);
    }
}
