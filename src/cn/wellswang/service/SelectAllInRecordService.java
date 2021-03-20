package cn.wellswang.service;

import cn.wellswang.dao.*;
import cn.wellswang.dao.impl.*;
import cn.wellswang.entity.Record;
import cn.wellswang.entity.RecordPage;

import java.util.ArrayList;

public class SelectAllInRecordService {

//    public static ArrayList<RecordPage> selectInRecordByoutManagerLike(Integer currentUserId, String keyWords) {
//        // 创建outRecordPages集合，用于返回
//        ArrayList<RecordPage> recordPages = new ArrayList<RecordPage>();
//        // 数据库DAO层
//        GoodsInfoDAO g = new GoodsInfoDAOImpl();
//        RecordInfoDAO r = new RecordInfoDAOImpl();
//        SupplierInfoDAO s = new SupplierInfoDAOImpl();
//        BadInfoDAO b = new BadInfoDAOImpl();
//        ManagerInfoDAO m = new ManagerInfoDAOImpl();
//        // 查询符合模糊查询条件的商品信息
//        ArrayList<Goods> goods = g.likeSelectGoods(keyWords);
//        // 查询符合条件的出库订单信息，并保存至outRecordPages集合中
//        for(Goods currentGoods : goods) {
//            ArrayList<Record> records = r.getOutRecordBySku(currentUserId, currentGoods.getGoodsSku());
//            for(Record currentRecord : records) {
//                RecordPage currentRecordPage = new RecordPage();
//                currentRecordPage.setRecordId(currentRecord.getRecordId());
//                currentRecordPage.setGoodsSku(currentGoods.getGoodsSku());
//                currentRecordPage.setGoodsName(currentGoods.getGoodsName());
//                currentRecordPage.setSupplierName(s.getNameById(currentRecord.getSupplierId()));
//                currentRecordPage.setGoodsNumber(currentRecord.getGoodsNumber() - b.getBadByOrder(currentRecord.getOrderId()).getBadBoxNumber());
//                currentRecordPage.setRecordTime(currentRecord.getRecordTime());
//                currentRecordPage.setManName(m.getCurrentuserName(currentUserId));
//                // 将符合条件的outRecordPage加入集合中
//                recordPages.add(currentRecordPage);
//            }
//        }
//        return recordPages;
//    }

    public static ArrayList<RecordPage> selectAllInRecordByManagerLike(Integer currentUserId) {
        ArrayList<RecordPage> recordPages = new ArrayList<RecordPage>();
        // 数据库DAO层
        GoodsInfoDAO g = new GoodsInfoDAOImpl();
        RecordInfoDAO r = new RecordInfoDAOImpl();
        SupplierInfoDAO s = new SupplierInfoDAOImpl();
        BadInfoDAO b = new BadInfoDAOImpl();
        ManagerInfoDAO m = new ManagerInfoDAOImpl();
        ArrayList<Record> records = r.getAllInRecordByUser(currentUserId);
        for(Record currentRecord : records) {
            RecordPage currentRecordPage = new RecordPage();
            currentRecordPage.setRecordId(currentRecord.getRecordId());
            currentRecordPage.setGoodsSku(currentRecord.getGoodsSku());
            currentRecordPage.setGoodsName(g.getGoodsName(currentRecord.getGoodsSku()));
            currentRecordPage.setGoodsNumber(currentRecord.getGoodsNumber());
            currentRecordPage.setRecordTime(currentRecord.getRecordTime());
            currentRecordPage.setManName(m.getCurrentuserName(currentUserId));
            recordPages.add(currentRecordPage);
        }
        return recordPages;
    }
}
