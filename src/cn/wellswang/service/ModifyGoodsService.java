package cn.wellswang.service;

import cn.wellswang.dao.GoodsInfoDAO;
import cn.wellswang.dao.impl.GoodsInfoDAOImpl;
import cn.wellswang.entity.Goods;

public class ModifyGoodsService {
    public static Integer modifyGoods(Goods newGoods) {
        GoodsInfoDAO g = new GoodsInfoDAOImpl();
        return g.updateGoodsInfo(newGoods);
    }
}
