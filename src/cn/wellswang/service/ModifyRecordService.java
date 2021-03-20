package cn.wellswang.service;

import cn.wellswang.dao.GoodsInfoDAO;
import cn.wellswang.dao.ManagerInfoDAO;
import cn.wellswang.dao.OrderInfoDAO;
import cn.wellswang.dao.RecordInfoDAO;
import cn.wellswang.dao.impl.GoodsInfoDAOImpl;
import cn.wellswang.dao.impl.ManagerInfoDAOImpl;
import cn.wellswang.dao.impl.OrderInfoDAOImpl;
import cn.wellswang.dao.impl.RecordInfoDAOImpl;
import cn.wellswang.entity.Goods;

public class ModifyRecordService {
    public static Integer getRecordBoxNumberByRecordId(Integer recordId) {
        RecordInfoDAO o = new RecordInfoDAOImpl();
        return o.getBoxNumberByRecordId(recordId);
    }

    public static Integer getBoxNumberOfOrderByRecordId(Integer recordId) {
        OrderInfoDAO o = new OrderInfoDAOImpl();
        RecordInfoDAO r = new RecordInfoDAOImpl();
        return o.getBoxNumberByOrderId(r.getOrderIdByRecordId(recordId));
    }

    public static Integer getBoxNumberOfGoodsByGoodsSku(String goodsSku) {
        GoodsInfoDAO g = new GoodsInfoDAOImpl();
        return g.getGoodsBoxNumber(goodsSku);
    }

    public static Integer isExitOfManagerName(String manName) {
        ManagerInfoDAO m = new ManagerInfoDAOImpl();
        return m.getManagerIdByName(manName);
    }

    public static Integer modifyRecordById(Integer recordId, Integer goodsNumber, String recordTime, String manName) {
        RecordInfoDAO r = new RecordInfoDAOImpl();
        ManagerInfoDAO m = new ManagerInfoDAOImpl();
        Integer managerId = m.getManagerIdByName(manName);
        return r.mofiyRecordById(recordId, goodsNumber, recordTime, managerId);
    }

    public static Integer modifyGoodsBoxNumber(Integer recordId, Integer orderBoxNumberInFact, Integer goodsNumber) {
        GoodsInfoDAO g = new GoodsInfoDAOImpl();
        RecordInfoDAO r = new RecordInfoDAOImpl();

        Integer difference = orderBoxNumberInFact - goodsNumber;

        String currentGoodsSku = r.getRecordById(recordId).getGoodsSku();
        Goods currentGoods = g.getGoodsById(currentGoodsSku);

        Integer newGoodsBoxNumber = currentGoods.getGoodsBoxNumber() - difference;

        return g.modifyGoodsBoxNumber(currentGoodsSku, newGoodsBoxNumber);
    }
}
