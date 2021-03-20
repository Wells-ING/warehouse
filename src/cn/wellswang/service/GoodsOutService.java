package cn.wellswang.service;

import cn.wellswang.dao.impl.GoodsInfoDAOImpl;
import cn.wellswang.dao.impl.RecordInfoDAOImpl;
import cn.wellswang.entity.Goods;
import cn.wellswang.entity.Record;

public class GoodsOutService {
    public static Integer saveRecord(Record newRecord) {
        RecordInfoDAOImpl r = new RecordInfoDAOImpl();
        return r.insertRecordInfo(newRecord);
    }
    public static Goods getGoodsByGoodsSku(String goodsSku) {
        GoodsInfoDAOImpl r = new GoodsInfoDAOImpl();
        return r.getGoodsById(goodsSku);
    }
    public static Integer updateGoodsNumber(String goodsSku, Integer goodsNumber) {
        GoodsInfoDAOImpl g = new GoodsInfoDAOImpl();
        return g.updateGoodsNumber(goodsSku, goodsNumber);
    }
}
