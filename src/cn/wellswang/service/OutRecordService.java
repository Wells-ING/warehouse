package cn.wellswang.service;

import cn.wellswang.dao.GoodsInfoDAO;
import cn.wellswang.dao.RecordInfoDAO;
import cn.wellswang.dao.impl.GoodsInfoDAOImpl;
import cn.wellswang.dao.impl.RecordInfoDAOImpl;
import cn.wellswang.entity.Goods;
import cn.wellswang.entity.OutRecordPage;
import cn.wellswang.entity.Record;

import java.util.ArrayList;

public class OutRecordService {

    public static ArrayList<OutRecordPage> selectOutRecordByoutManagerLike(Integer currentUserId, String keyWords) {
        // 创建outRecordPages集合，用于返回
        ArrayList<OutRecordPage> outRecordPages = new ArrayList<OutRecordPage>();
        // 数据库DAO层
        GoodsInfoDAO g = new GoodsInfoDAOImpl();
        RecordInfoDAO r = new RecordInfoDAOImpl();
        // 查询符合模糊查询条件的商品信息
        ArrayList<Goods> goods = g.likeSelectGoods(keyWords);
        // 查询符合条件的出库订单信息，并保存至outRecordPages集合中
        for(Goods currentGoods : goods) {
            ArrayList<Record> records = r.getOutRecordBySku(currentUserId, currentGoods.getGoodsSku());
            for(Record currentRecord : records) {
                OutRecordPage currentOutRecordPage = new OutRecordPage();
                currentOutRecordPage.setRecordrId(currentRecord.getRecordId());
                currentOutRecordPage.setGoodsSku(currentGoods.getGoodsSku());
                currentOutRecordPage.setGoodsName(currentGoods.getGoodsName());
                currentOutRecordPage.setOutNumber(currentRecord.getGoodsNumber());
                currentOutRecordPage.setRecordTime(currentRecord.getRecordTime());
                // 将符合条件的outRecordPage加入集合中
                outRecordPages.add(currentOutRecordPage);
            }
        }
        return outRecordPages;
    }

    public static ArrayList<OutRecordPage> selectAllOutRecordByoutManagerLike(Integer currentUserId) {
        // 创建outRecordPages集合，用于返回
        ArrayList<OutRecordPage> outRecordPages = new ArrayList<OutRecordPage>();
        // 数据库DAO层
        GoodsInfoDAO g = new GoodsInfoDAOImpl();
        RecordInfoDAO r = new RecordInfoDAOImpl();
        // 查询符合条件的出库订单信息，并保存至outRecordPages集合中
            ArrayList<Record> records = r.getAllOutRecordByUser(currentUserId);
            for(Record currentRecord : records) {
                OutRecordPage currentOutRecordPage = new OutRecordPage();
                currentOutRecordPage.setRecordrId(currentRecord.getRecordId());
                currentOutRecordPage.setGoodsSku(currentRecord.getGoodsSku());
                currentOutRecordPage.setGoodsName(g.getGoodsName(currentRecord.getGoodsSku()));
                currentOutRecordPage.setOutNumber(currentRecord.getGoodsNumber());
                currentOutRecordPage.setRecordTime(currentRecord.getRecordTime());
                // 将符合条件的outRecordPage加入集合中
                outRecordPages.add(currentOutRecordPage);
            }
        return outRecordPages;
    }
}
