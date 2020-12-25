package cn.wellswang.dao;

import java.util.ArrayList;

import cn.wellswang.entity.Record;

public interface RecordInfoDAO {
	// 增
	public int insertRecordInfo(Record newRecord);
	// 删
	public int deleteRecordInfo(Record deleteRecord);
	// 改
	public int updateRecordInfo(Record oldRecord, Record newRecord);
	// 查
	public Record getRecordById(Integer record_id);
	public ArrayList<Record> getAll();
}
