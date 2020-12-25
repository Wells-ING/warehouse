package cn.wellswang.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import cn.wellswang.dao.SupplierInfoDAO;
import cn.wellswang.entity.Goods;
import cn.wellswang.entity.Record;
import cn.wellswang.entity.Supplier;
import cn.wellswang.utils.DBUtils;

public class SupplierInfoDAOImpl implements SupplierInfoDAO {

	@Override
	public int insertSupplierInfo(Supplier newSupplier) {
		Integer supplier_id = newSupplier.getSupplier_id();
		String supplier_name = newSupplier.getSupplier_name();
		String insertSQL = "INSET INTO suppliers(supplier_id, supplier_name) "
				+ "VALUES("
				+ supplier_id + ",'"
				+ supplier_name + "'"
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
	public int deleteSupplierInfo(Supplier deleteSupplier) {
		String deleteSQL = "DELETE FROM supplier WHERE supplier_id = " + deleteSupplier.getSupplier_id();
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
	public int updateSupplierInfo(Supplier oldSupplier, Supplier newSupplier) {
		Integer supplier_id = oldSupplier.getSupplier_id();
		String supplier_name = newSupplier.getSupplier_name();
		String updateSQL = "UPDATE bads SET " 
							+ "supplier_name = '" + supplier_name + "'"
							+ " WHERE supplier_id = " + supplier_id;
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
	public Supplier getSupplierById(Integer supplier_id) {
		String selectSQL = "SELECT * FROM suppliers WHERE supplier_id = " + supplier_id;
		Supplier supplier = new Supplier();
		Connection conn = null;
		Statement stm = null;
		ResultSet rs = null;
		try {
			conn = DBUtils.getConnection();
			stm = conn.createStatement();
			rs = stm.executeQuery(selectSQL);
			while(rs.next()) {
				supplier.setSupplier_id(rs.getInt("supplier_id"));
				supplier.setSupplier_name(rs.getString("supplier_name"));
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeConnection(stm, rs);
		}
		return supplier;
	}

	@Override
	public ArrayList<Supplier> getAll() {
		String selectSQL = "SELECT * FROM suppliers";
		ArrayList<Supplier> suppliers = new ArrayList<Supplier>();
		Connection conn = null;
		Statement stm = null;
		ResultSet rs = null;
		try {
			conn = DBUtils.getConnection();
			stm = conn.createStatement();
			rs = stm.executeQuery(selectSQL);
			while(rs.next()) {
				Supplier currentSupplier = new Supplier();
				currentSupplier.setSupplier_id(rs.getInt("supplier_id"));
				currentSupplier.setSupplier_name(rs.getString("supplier_name"));
				suppliers.add(currentSupplier);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeConnection(stm, rs);
		}
		return suppliers;
	}
}
