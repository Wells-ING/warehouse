package cn.wellswang.service;

import cn.wellswang.dao.GoodsInfoDAO;
import cn.wellswang.dao.OrderInfoDAO;
import cn.wellswang.dao.impl.BadInfoDAOImpl;
import cn.wellswang.dao.impl.GoodsInfoDAOImpl;
import cn.wellswang.dao.impl.OrderInfoDAOImpl;
import cn.wellswang.dao.impl.RecordInfoDAOImpl;
import cn.wellswang.entity.Record;

public class GoodsInService {
    public static Integer saveRecord(Record newRecord) {
        RecordInfoDAOImpl r = new RecordInfoDAOImpl();
        return r.insertRecordInfo(newRecord);
    }
    public static Integer getBadsBoxNumberByOrderId(Integer orderId) {
        BadInfoDAOImpl b = new BadInfoDAOImpl();
        return b.getBadByOrder(orderId).getBadBoxNumber();
    }

    public static void modifyStates(Integer orderId, Integer i) {
        OrderInfoDAO o = new OrderInfoDAOImpl();
        o.modifyOrderState(orderId, i);
    }

    public static void modifyGoodsBoxNumber(String goodsSku, Integer goodsBoxNumber) {
        GoodsInfoDAO g = new GoodsInfoDAOImpl();

        g.updateGoodsNumber(goodsSku,  GoodsInService.getGoodsBoxNumber(goodsSku) + goodsBoxNumber);
    }
    public static Integer getGoodsBoxNumber(String goodsSku) {
        GoodsInfoDAO g = new GoodsInfoDAOImpl();
        return g.getGoodsBoxNumber(goodsSku);
    }
}
