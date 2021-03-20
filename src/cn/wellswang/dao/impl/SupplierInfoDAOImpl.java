package cn.wellswang.dao.impl;

import cn.wellswang.dao.SupplierInfoDAO;
import cn.wellswang.entity.Supplier;
import cn.wellswang.utils.DBUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class SupplierInfoDAOImpl implements SupplierInfoDAO {

	@Override
	public int insertSupplierInfo(Supplier newSupplier) {
		Integer supplierId = newSupplier.getSupplierId();
		String supplierName = newSupplier.getSupplierName();
		String insertSQL = "INSERT INTO suppliers(supplier_name) "
				+ "VALUES('"
				+ supplierName + "'"
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
		String deleteSQL = "DELETE FROM supplier WHERE supplier_id = " + deleteSupplier.getSupplierId();
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
		Integer supplierId = oldSupplier.getSupplierId();
		String supplierName = newSupplier.getSupplierName();
		String updateSQL = "UPDATE suppliers SET "
							+ "supplier_name = '" + supplierName + "'"
							+ " WHERE supplier_id = " + supplierId;
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
	public Supplier getSupplierById(Integer supplierId) {
		String selectSQL = "SELECT * FROM suppliers WHERE supplier_id = " + supplierId;
		Supplier supplier = new Supplier();
		Connection conn = null;
		Statement stm = null;
		ResultSet rs = null;
		try {
			conn = DBUtils.getConnection();
			stm = conn.createStatement();
			rs = stm.executeQuery(selectSQL);
			while(rs.next()) {
				supplier.setSupplierId(rs.getInt("supplier_id"));
				supplier.setSupplierName(rs.getString("supplier_name"));
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
				currentSupplier.setSupplierId(rs.getInt("supplier_id"));
				currentSupplier.setSupplierName(rs.getString("supplier_name"));
				suppliers.add(currentSupplier);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeConnection(stm, rs);
		}
		return suppliers;
	}

	@Override
	public Integer getIdByName(String supplierName) {
		String selectSQL = "SELECT * FROM suppliers WHERE supplier_name = '" + supplierName + "'";
		Integer supplierId = null;
		Connection conn = null;
		Statement stm = null;
		ResultSet rs = null;
		try {
			conn = DBUtils.getConnection();
			stm = conn.createStatement();
			rs = stm.executeQuery(selectSQL);
			rs.next();
			supplierId = rs.getInt("supplier_id");
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeConnection(stm, rs);
		}
		return supplierId;
	}

	@Override
	public String getNameById(Integer supplierId) {
		String selectSQL = "SELECT * FROM suppliers WHERE supplier_id = '" + supplierId + "'";
		String supplierName = "";
		Connection conn = null;
		Statement stm = null;
		ResultSet rs = null;
		try {
			conn = DBUtils.getConnection();
			stm = conn.createStatement();
			rs = stm.executeQuery(selectSQL);
			rs.next();
			supplierName = rs.getString("supplier_name");
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeConnection(stm, rs);
		}
		return supplierName;
	}

	@Override
	public ArrayList<Supplier> getSupplierByLike(String keyWords) {
		String selectSQL = "SELECT * FROM suppliers WHERE supplier_name LIKE '%" + keyWords + "%'";
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
				currentSupplier.setSupplierId(rs.getInt("supplier_id"));
				currentSupplier.setSupplierName(rs.getString("supplier_name"));
				suppliers.add(currentSupplier);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeConnection(stm, rs);
		}
		return suppliers;
	}

	@Override
	public Integer deleteSupplierById(Integer supplierId) {
		String deleteSQL = "DELETE FROM suppliers WHERE supplier_id = " + supplierId;
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
	public Integer modifySupplierById(Integer supplierId, String supplierName) {
		String updateSQL = "UPDATE suppliers SET "
				+ "supplier_name = '" + supplierName + "'"
				+ " WHERE supplier_id = " + supplierId;
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
}
