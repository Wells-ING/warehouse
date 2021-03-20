package cn.wellswang.service;

import cn.wellswang.dao.GoodsInfoDAO;
import cn.wellswang.dao.impl.GoodsInfoDAOImpl;

public class GoodsIsCanModifyService {
    public static Integer getGoodsBoxNumberByGoodsSku(String goodsSku) {
        GoodsInfoDAO g = new GoodsInfoDAOImpl();
        return g.getGoodsBoxNumber(goodsSku);
    }
}
