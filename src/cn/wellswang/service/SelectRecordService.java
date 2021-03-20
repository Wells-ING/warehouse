package cn.wellswang.service;

import cn.wellswang.dao.*;
import cn.wellswang.dao.impl.*;
import cn.wellswang.entity.Goods;
import cn.wellswang.entity.Record;
import cn.wellswang.entity.RecordPage;

import java.util.ArrayList;

public class SelectRecordService {
    public static ArrayList<RecordPage> getRecordPagesByLike(String keyWords) {
        ArrayList<RecordPage> recordPages = new ArrayList<RecordPage>();

        ArrayList<Goods> goods = SelectGoodsService.getGoodsByLike(keyWords);

        OrderInfoDAO o = new OrderInfoDAOImpl();
        BadInfoDAO b = new BadInfoDAOImpl();
        ManagerInfoDAO m = new ManagerInfoDAOImpl();
        RecordInfoDAO r = new RecordInfoDAOImpl();
        GoodsInfoDAO g = new GoodsInfoDAOImpl();

        for(Goods currentGoods : goods) {
            ArrayList<Record> records = r.getRecordsByGoodsSku(currentGoods.getGoodsSku());
            for(Record record : records) {
                RecordPage currentRecordPage = new RecordPage();
                currentRecordPage.setRecordId(record.getRecordId());
                currentRecordPage.setGoodsSku(record.getGoodsSku());
                currentRecordPage.setGoodsName(g.getGoodsName(record.getGoodsSku()));
                currentRecordPage.setGoodsNumber(record.getGoodsNumber());
                currentRecordPage.setRecordType(record.getRecordType());
                currentRecordPage.setRecordTime(record.getRecordTime());
                currentRecordPage.setManName(m.getCurrentuserName(record.getManId()));
                recordPages.add(currentRecordPage);
            }
        }
        return recordPages;
    }
}
