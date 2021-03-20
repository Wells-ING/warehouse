package cn.wellswang.service;

import cn.wellswang.dao.*;
import cn.wellswang.dao.impl.*;
import cn.wellswang.entity.Record;
import cn.wellswang.entity.RecordPage;

public class ShowRecordDataService {
    public static RecordPage getRecordPagesByRecordId(Integer recordId) {
        RecordPage recordPage = new RecordPage();

        BadInfoDAO b = new BadInfoDAOImpl();
        GoodsInfoDAO g = new GoodsInfoDAOImpl();
        OrderInfoDAO o = new OrderInfoDAOImpl();
        ManagerInfoDAO m = new ManagerInfoDAOImpl();
        RecordInfoDAO r = new RecordInfoDAOImpl();
        Record record = r.getRecordById(recordId);
        recordPage.setRecordId(recordId);
        recordPage.setGoodsSku(record.getGoodsSku());
        recordPage.setGoodsName(g.getGoodsName(record.getGoodsSku()));
        recordPage.setManName(m.getCurrentuserName(record.getManId()));
        recordPage.setRecordType(record.getRecordType());
        recordPage.setRecordTime(record.getRecordTime());
        recordPage.setGoodsNumber(record.getGoodsNumber());
        return recordPage;
    }
}
