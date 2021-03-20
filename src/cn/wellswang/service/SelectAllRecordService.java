package cn.wellswang.service;

import cn.wellswang.dao.GoodsInfoDAO;
import cn.wellswang.dao.ManagerInfoDAO;
import cn.wellswang.dao.RecordInfoDAO;
import cn.wellswang.dao.impl.GoodsInfoDAOImpl;
import cn.wellswang.dao.impl.ManagerInfoDAOImpl;
import cn.wellswang.dao.impl.RecordInfoDAOImpl;
import cn.wellswang.entity.Record;
import cn.wellswang.entity.RecordPage;

import java.util.ArrayList;

public class SelectAllRecordService {
    public static ArrayList<RecordPage> getAllRecordPage() {
        ArrayList<RecordPage> recordPages = new ArrayList<RecordPage>();

        RecordInfoDAO r = new RecordInfoDAOImpl();
        GoodsInfoDAO g = new GoodsInfoDAOImpl();
        ManagerInfoDAO m = new ManagerInfoDAOImpl();
        ArrayList<Record> records = r.getAll();
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
        return recordPages;
    }
}
