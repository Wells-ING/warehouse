package cn.wellswang.dao.impl;

import cn.wellswang.dao.RecordInfoDAO;
import cn.wellswang.entity.Record;
import cn.wellswang.utils.DBUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class RecordInfoDAOImpl implements RecordInfoDAO {

	@Override
	public int insertRecordInfo(Record newRecord) {
		Integer manId = newRecord.getManId();
		Integer orderId = newRecord.getOrderId();
		String goodsSku = newRecord.getGoodsSku();
		Integer supplierId = newRecord.getSupplierId();
		Integer goodsNumber = newRecord.getGoodsNumber();
		Integer recordType = newRecord.getRecordType();
		String recordTime = newRecord.getRecordTime();
		String insertSQL = "INSERT INTO records(man_id, order_id, goods_sku, supplier_id, goods_number, "
				+ "record_type, record_time)"
				+ "VALUES("
				+ manId + ","
				+ orderId + ",'"
				+ goodsSku + "',"
				+ supplierId + ","
				+ goodsNumber + ",'"
				+ recordType + "','"
				+ recordTime + "'"
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
		String deleteSQL = "DELETE FROM records WHERE record_id = " + deleteRecord.getRecordId();
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
		Integer recordId = oldRecord.getRecordId();
		Integer manId = newRecord.getManId();
		Integer orderId = newRecord.getOrderId();
		String goodsSku = newRecord.getGoodsSku();
		Integer supplierId = newRecord.getSupplierId();
		Integer goodsNumber = newRecord.getGoodsNumber();
		Integer recordType = newRecord.getRecordType();
		String recordTime = newRecord.getRecordTime();
		String updateSQL = "UPDATE records SET "
							+ "man_id = " + manId + ","
							+ "order_id = " + orderId + ","
							+ "goods_sku = '" + goodsSku + "',"
							+ "supplier_id = " + supplierId + ","
							+ "goods_number = " + goodsNumber + ","
							+ "record_type = '" + recordType + "',"
							+ "record_time = " + recordTime
							+ " WHERE record_id = '" + recordId + "'";
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
	public Record getRecordById(Integer recordId) {
		String selectSQL = "SELECT * FROM records WHERE record_id = " + recordId;
		Record record = new Record();
		Connection conn = null;
		Statement stm = null;
		ResultSet rs = null;
		try {
			conn = DBUtils.getConnection();
			stm = conn.createStatement();
			rs = stm.executeQuery(selectSQL);
			while(rs.next()) {
				record.setRecordId(rs.getInt("record_id"));
				record.setManId(rs.getInt("man_id"));
				record.setGoodsSku(rs.getString("goods_sku"));
				record.setSupplierId(rs.getInt("supplier_id"));
				record.setGoodsNumber(rs.getInt("goods_number"));
				record.setRecordType(rs.getInt("record_type"));
				record.setRecordTime(rs.getString("record_time"));
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
				currentRecord.setRecordId(rs.getInt("record_id"));
				currentRecord.setManId(rs.getInt("man_id"));
				currentRecord.setGoodsSku(rs.getString("goods_sku"));
				currentRecord.setSupplierId(rs.getInt("supplier_id"));
				currentRecord.setGoodsNumber(rs.getInt("goods_number"));
				currentRecord.setRecordType(rs.getInt("record_type"));
				currentRecord.setRecordTime(rs.getString("record_time"));
				records.add(currentRecord);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeConnection(stm,rs);
		}
		return records;
	}

	@Override
	public ArrayList<Record> getOutRecordBySku(Integer managerId, String goodsSku) {
		String selectSQL = "SELECT * FROM records"
								+ " WHERE "
								+ "man_id = " + managerId + " AND "
								+ "goods_sku = '" +goodsSku + "' AND "
								+ "record_type = " + 0;
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
				currentRecord.setRecordId(rs.getInt("record_id"));
				currentRecord.setManId(rs.getInt("man_id"));
				currentRecord.setGoodsSku(rs.getString("goods_sku"));
				currentRecord.setSupplierId(rs.getInt("supplier_id"));
				currentRecord.setGoodsNumber(rs.getInt("goods_number"));
				currentRecord.setRecordType(rs.getInt("record_type"));
				currentRecord.setRecordTime(rs.getString("record_time"));
				records.add(currentRecord);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeConnection(stm,rs);
		}
		return records;
	}

	@Override
	public ArrayList<Record> getAllOutRecordByUser(Integer currentUserId) {
		String selectSQL = "SELECT * FROM records"
				+ " WHERE "
				+ "man_id = " + currentUserId + " AND "
				+ "record_type = " + 0;
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
				currentRecord.setRecordId(rs.getInt("record_id"));
				currentRecord.setManId(rs.getInt("man_id"));
				currentRecord.setGoodsSku(rs.getString("goods_sku"));
				currentRecord.setSupplierId(rs.getInt("supplier_id"));
				currentRecord.setGoodsNumber(rs.getInt("goods_number"));
				currentRecord.setRecordType(rs.getInt("record_type"));
				currentRecord.setRecordTime(rs.getString("record_time"));
				records.add(currentRecord);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeConnection(stm,rs);
		}
		return records;
	}

	@Override
	public ArrayList<Record> getAllInRecordByUser(Integer currentUserId) {
		String selectSQL = "SELECT * FROM records"
				+ " WHERE "
				+ "man_id = " + currentUserId + " AND "
				+ "record_type = " + 1;
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
				currentRecord.setRecordId(rs.getInt("record_id"));
				currentRecord.setManId(rs.getInt("man_id"));
				currentRecord.setOrderId(rs.getInt("order_id"));
				currentRecord.setGoodsSku(rs.getString("goods_sku"));
				currentRecord.setSupplierId(rs.getInt("supplier_id"));
				currentRecord.setGoodsNumber(rs.getInt("goods_number"));
				currentRecord.setRecordType(rs.getInt("record_type"));
				currentRecord.setRecordTime(rs.getString("record_time"));
				records.add(currentRecord);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeConnection(stm,rs);
		}
		return records;
	}

	@Override
	public ArrayList<Record> getInRecordByLikeAndCurrentMangerId(Integer currentManagerId, String keyWords) {
		String selectSQL = "SELECT * FROM records"
				+ " WHERE "
				+ "man_id = " + currentManagerId + " AND "
				+ "record_type = " + 1;
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
				currentRecord.setRecordId(rs.getInt("record_id"));
				currentRecord.setManId(rs.getInt("man_id"));
				currentRecord.setGoodsSku(rs.getString("goods_sku"));
				currentRecord.setSupplierId(rs.getInt("supplier_id"));
				currentRecord.setGoodsNumber(rs.getInt("goods_number"));
				currentRecord.setRecordType(rs.getInt("record_type"));
				currentRecord.setRecordTime(rs.getString("record_time"));
				records.add(currentRecord);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeConnection(stm,rs);
		}
		return records;
	}

	@Override
	public ArrayList<Record> getInRecordBySku(Integer managerId, String goodsSku) {
		String selectSQL = "SELECT * FROM records"
				+ " WHERE "
				+ "man_id = " + managerId + " AND "
				+ "goods_sku = '" +goodsSku + "' AND "
				+ "record_type = " + 1;
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
				currentRecord.setRecordId(rs.getInt("record_id"));
				currentRecord.setManId(rs.getInt("man_id"));
				currentRecord.setOrderId(rs.getInt("order_id"));
				currentRecord.setGoodsSku(rs.getString("goods_sku"));
				currentRecord.setSupplierId(rs.getInt("supplier_id"));
				currentRecord.setGoodsNumber(rs.getInt("goods_number"));
				currentRecord.setRecordType(rs.getInt("record_type"));
				currentRecord.setRecordTime(rs.getString("record_time"));
				records.add(currentRecord);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeConnection(stm,rs);
		}
		return records;
	}

	@Override
	public ArrayList<Record> getRecordsByGoodsSku(String goodsSku) {
		String selectSQL = "SELECT * FROM records"
				+ " WHERE "
				+ "goods_sku = '" +goodsSku + "'";
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
				currentRecord.setRecordId(rs.getInt("record_id"));
				currentRecord.setManId(rs.getInt("man_id"));
				currentRecord.setGoodsSku(rs.getString("goods_sku"));
				currentRecord.setSupplierId(rs.getInt("supplier_id"));
				currentRecord.setGoodsNumber(rs.getInt("goods_number"));
				currentRecord.setRecordType(rs.getInt("record_type"));
				currentRecord.setRecordTime(rs.getString("record_time"));
				records.add(currentRecord);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeConnection(stm,rs);
		}
		return records;
	}

	@Override
	public Integer deleteRecordByBadId(Integer recordId) {
		String deleteSQL = "DELETE FROM records WHERE record_id = " + recordId;
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
	public Integer getOrderIdByRecordId(Integer recordId) {
		String selectSQL = "SELECT * FROM records WHERE record_id = " + recordId;
		Integer orderId = null;
		Connection conn = null;
		Statement stm = null;
		ResultSet rs = null;
		try {
			conn = DBUtils.getConnection();
			stm = conn.createStatement();
			rs = stm.executeQuery(selectSQL);
			rs.next();
			orderId = rs.getInt("order_id");
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeConnection(stm, rs);
		}
		return orderId;
	}

	@Override
	public Integer mofiyRecordById(Integer recordId, Integer goodsNumber, String recordTime, Integer managerId) {
		String updateSQL = "UPDATE records SET "
				+ "man_id = " + managerId + ","
				+ "goods_number = " + goodsNumber + ","
				+ "record_time = '" + recordTime + "'"
				+ " WHERE record_id = '" + recordId + "'";
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
	public Integer getBoxNumberByRecordId(Integer recordId) {
		String selectSQL = "SELECT * FROM records WHERE record_id = " + recordId;
		Integer boxNumber = 0;
		Connection conn = null;
		Statement stm = null;
		ResultSet rs = null;
		try {
			conn = DBUtils.getConnection();
			stm = conn.createStatement();
			rs = stm.executeQuery(selectSQL);
			rs.next();
			boxNumber = rs.getInt("goods_number");
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeConnection(stm, rs);
		}
		return boxNumber;
	}
}
