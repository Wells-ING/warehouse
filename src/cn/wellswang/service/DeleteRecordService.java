package cn.wellswang.service;

import cn.wellswang.dao.RecordInfoDAO;
import cn.wellswang.dao.impl.RecordInfoDAOImpl;

public class DeleteRecordService {
    public static Integer deleteReocrdByRecordId(Integer recordId) {
        RecordInfoDAO d = new RecordInfoDAOImpl();
        return d.deleteRecordByBadId(recordId);
    }
}
