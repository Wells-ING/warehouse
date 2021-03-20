package cn.wellswang.dao;

import cn.wellswang.entity.Record;

import java.util.ArrayList;

public interface RecordInfoDAO {
	// 增
	public int insertRecordInfo(Record newRecord);
	// 删
	public int deleteRecordInfo(Record deleteRecord);
	// 改
	public int updateRecordInfo(Record oldRecord, Record newRecord);
	// 查询某个记录
	public Record getRecordById(Integer record_id);
	// 查询所有记录
	public ArrayList<Record> getAll();
	// 根据商品sku、出库人信息查询出库记录（type = 0）
	ArrayList<Record> getOutRecordBySku(Integer managerId, String goodsSku);

    ArrayList<Record> getAllOutRecordByUser(Integer currentUserId);

    ArrayList<Record> getAllInRecordByUser(Integer currentUserId);
    ArrayList<Record> getInRecordByLikeAndCurrentMangerId(Integer currentManagerId, String keyWords);

	ArrayList<Record> getInRecordBySku(Integer currentManagerId, String goodsSku);

    ArrayList<Record> getRecordsByGoodsSku(String goodsSku);

	Integer deleteRecordByBadId(Integer recordId);

    Integer getOrderIdByRecordId(Integer recordId);

	Integer mofiyRecordById(Integer recordId, Integer goodsNumber, String recordTime, Integer managerId);

	Integer getBoxNumberByRecordId(Integer recordId);
}
