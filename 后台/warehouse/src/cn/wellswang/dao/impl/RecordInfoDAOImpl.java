package cn.wellswang.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import cn.wellswang.dao.RecordInfoDAO;
import cn.wellswang.entity.Manager;
import cn.wellswang.entity.Order;
import cn.wellswang.entity.Record;
import cn.wellswang.utils.DBUtils;

public class RecordInfoDAOImpl implements RecordInfoDAO {

	@Override
	public int insertRecordInfo(Record newRecord) {
		Integer record_id = newRecord.getRecord_id();
		Integer man_id = newRecord.getMan_id();
		String goods_sku = newRecord.getGoods_sku();
		Integer supplier_id = newRecord.getSupplier_id();
		Integer goods_number = newRecord.getGoods_number();
		Integer record_type = newRecord.getRecord_type();
		Date record_time = newRecord.getRecord_time();
		String insertSQL = "INSET INTO records(record_id, man_id, goods_sku, supplier_id, goods_number, "
				+ "record_type, record_time)"
				+ "VALUES("
				+ record_id + ","
				+ man_id + ",'"
				+ goods_sku + "',"
				+ supplier_id + ","
				+ goods_number + ",'"
				+ record_type + "',"
				+ record_time
				+ ")";
		int count = 0;
		Connection conn = null;
		Statement stm = null;
		try {
			conn = DBUtils.getConnection();
			stm = conn.createStatement();
			count = stm.executeUpdate(insertSQL);
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeConnection(stm);
		}
		return count;
	}

	@Override
	public int deleteRecordInfo(Record deleteRecord) {
		String deleteSQL = "DELETE FROM records WHERE record_id = " + deleteRecord.getRecord_id();
		int count = 0;
		Connection conn = null;
		Statement stm = null;
		try {
			conn = DBUtils.getConnection();
			stm = conn.createStatement();
			count = stm.executeUpdate(deleteSQL);
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeConnection(stm);
		}
		return count;
	}

	@Override
	public int updateRecordInfo(Record oldRecord, Record newRecord) {
		Integer record_id = oldRecord.getRecord_id();
		Integer man_id = newRecord.getMan_id();
		String goods_sku = newRecord.getGoods_sku();
		Integer supplier_id = newRecord.getSupplier_id();
		Integer goods_number = newRecord.getGoods_number();
		Integer record_type = newRecord.getRecord_type();
		Date record_time = newRecord.getRecord_time();
		String updateSQL = "UPDATE bads SET " 
							+ "man_id = " + man_id + ","
							+ "goods_sku = '" + goods_sku + "',"
							+ "supplier_id = " + supplier_id + ","
							+ "goods_number = " + goods_number + ","
							+ "record_type = '" + record_type + "',"
							+ "record_time = " + record_time
							+ " WHERE record_id = '" + record_id + "'";
		int count = 0;
		Connection conn = null;
		Statement stm = null;
		try {
			conn = DBUtils.getConnection();
			stm = conn.createStatement();
			count = stm.executeUpdate(updateSQL);
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeConnection(stm);
		}
		return count;
	}

	@Override
	public Record getRecordById(Integer record_id) {
		String selectSQL = "SELECT * FROM records WHERE record_id = " + record_id;
		Record record = new Record();
		Connection conn = null;
		Statement stm = null;
		ResultSet rs = null;
		try {
			conn = DBUtils.getConnection();
			stm = conn.createStatement();
			rs = stm.executeQuery(selectSQL);
			while(rs.next()) {
				record.setRecord_id(rs.getInt("record_id"));
				record.setMan_id(rs.getInt("man_id"));
				record.setGoods_sku(rs.getString("goods_sku"));
				record.setSupplier_id(rs.getInt("supplier_id"));
				record.setGoods_number(rs.getInt("goods_number"));
				record.setRecord_type(rs.getInt("record_type"));
				record.setRecord_time(rs.getDate("record_time"));
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeConnection(stm, rs);
		}
		return record;
	}

	@Override
	public ArrayList<Record> getAll() {
		String selectSQL = "SELECT * FROM records";
		ArrayList<Record> records = new ArrayList<Record>();
		Connection conn = null;
		Statement stm = null;
		ResultSet rs = null;
		try {
			conn = DBUtils.getConnection();
			stm = conn.createStatement();
			rs = stm.executeQuery(selectSQL);
			while(rs.next()) {
				Record currentRecord = new Record();
				currentRecord.setRecord_id(rs.getInt("record_id"));
				currentRecord.setMan_id(rs.getInt("man_id"));
				currentRecord.setGoods_sku(rs.getString("goods_sku"));
				currentRecord.setSupplier_id(rs.getInt("supplier_id"));
				currentRecord.setGoods_number(rs.getInt("goods_number"));
				currentRecord.setRecord_type(rs.getInt("record_type"));
				currentRecord.setRecord_time(rs.getDate("record_time"));
				records.add(currentRecord);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeConnection(stm,rs);
		}
		return records;
	}
	
}
