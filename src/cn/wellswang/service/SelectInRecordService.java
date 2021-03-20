package cn.wellswang.service;

import cn.wellswang.dao.BadInfoDAO;
import cn.wellswang.dao.ManagerInfoDAO;
import cn.wellswang.dao.RecordInfoDAO;
import cn.wellswang.dao.SupplierInfoDAO;
import cn.wellswang.dao.impl.BadInfoDAOImpl;
import cn.wellswang.dao.impl.ManagerInfoDAOImpl;
import cn.wellswang.dao.impl.RecordInfoDAOImpl;
import cn.wellswang.dao.impl.SupplierInfoDAOImpl;
import cn.wellswang.entity.Goods;
import cn.wellswang.entity.Record;
import cn.wellswang.entity.RecordPage;

import java.util.ArrayList;

public class SelectInRecordService {
    public static ArrayList<RecordPage> getInRecordByLikeAndCurrentManagerId(Integer currentManagerId, String keyWords) {
        ArrayList<RecordPage> recordPages = new ArrayList<RecordPage>();
        RecordInfoDAO r = new RecordInfoDAOImpl();
        ArrayList<Goods> goods = SelectGoodsService.getGoodsByLike(keyWords);
        SupplierInfoDAO s = new SupplierInfoDAOImpl();
        ManagerInfoDAO m = new ManagerInfoDAOImpl();
        BadInfoDAO b = new BadInfoDAOImpl();
        r.getInRecordByLikeAndCurrentMangerId(currentManagerId, keyWords);
        for(Goods g : goods) {
            ArrayList<Record> records = r.getInRecordBySku(currentManagerId, g.getGoodsSku());
            for(Record record : records) {
                RecordPage currentRecordPage = new RecordPage();
                currentRecordPage.setRecordId(record.getRecordId());
                currentRecordPage.setGoodsSku(g.getGoodsSku());
                currentRecordPage.setGoodsName(g.getGoodsName());
                currentRecordPage.setGoodsNumber(record.getGoodsNumber());
                currentRecordPage.setRecordTime(record.getRecordTime());
                currentRecordPage.setManName(m.getCurrentuserName(currentManagerId));
                recordPages.add(currentRecordPage);
            }
        }
        return recordPages;
    }
}
