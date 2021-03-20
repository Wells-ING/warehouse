package cn.wellswang.dao.impl;

import cn.wellswang.dao.BadInfoDAO;
import cn.wellswang.entity.Bad;
import cn.wellswang.utils.DBUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class BadInfoDAOImpl implements BadInfoDAO {

	@Override
	public int insertBadInfo(Bad newBad) {
		Integer badId = newBad.getBadId();
		Integer orderId = newBad.getOrderId();
		Integer manId = newBad.getManId();
		Integer badBoxNumber = newBad.getBadBoxNumber();
		String badDecoration = newBad.getBadDecoration();
		String insertSQL = "INSERT INTO bads(order_id, man_id, bad_boxNumber, bad_decoration) "
				+ "VALUES("
				+ orderId + ","
				+ manId + ","
				+ badBoxNumber +",'"
				+ badDecoration + "'"
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
	public int deleteBadInfo(Bad deleteBad) {
		String deleteSQL = "DELETE FROM bads WHERE bad_id = " + deleteBad.getBadId();
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
	public int updateBadInfo(Bad oldBad, Bad newBad) {
		Integer badId = oldBad.getBadId();
		Integer orderId = newBad.getOrderId();
		Integer manId = newBad.getManId();
		Integer badBoxNumber = newBad.getBadBoxNumber();
		String badDecoration = newBad.getBadDecoration();
		String updateSQL = "UPDATE bads SET "
							+ "order_id = " + orderId + ","
							+ "man_id = " + manId + ","
							+ "bad_boxNumber = " + badBoxNumber + ","
							+ "bad_decoration = '" + badDecoration + "'"
							+ " WHERE bad_id = " + badId;
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
	public Bad getBadById(Integer badId) {
		String selectSQL = "SELECT * FROM bads WHERE bad_id = " + badId;
		Bad bad = new Bad();
		Connection conn = null;
		Statement stm = null;
		ResultSet rs = null;
		try {
			conn = DBUtils.getConnection();
			stm = conn.createStatement();
			rs = stm.executeQuery(selectSQL);
			while(rs.next()) {
				bad.setBadId(rs.getInt("bad_id"));
				bad.setOrderId(rs.getInt("order_id"));
				bad.setManId(rs.getInt("man_id"));
				bad.setBadBoxNumber(rs.getInt("bad_boxNumber"));
				bad.setBadDecoration(rs.getString("bad_decoration"));
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeConnection(stm, rs);
		}
		return bad;
	}

	@Override
	public ArrayList<Bad> getAll() {
		String selectSQL = "SELECT * FROM bads";
		ArrayList<Bad> bads = new ArrayList<Bad>();
		Connection conn = null;
		Statement stm = null;
		ResultSet rs = null;
		try {
			conn = DBUtils.getConnection();
			stm = conn.createStatement();
			rs = stm.executeQuery(selectSQL);
			while(rs.next()) {
				Bad currentBad = new Bad();
				currentBad.setBadId(rs.getInt("bad_id"));
				currentBad.setOrderId(rs.getInt("order_id"));
				currentBad.setManId(rs.getInt("man_id"));
				currentBad.setBadBoxNumber(rs.getInt("bad_boxNumber"));
				currentBad.setBadDecoration(rs.getString("bad_decoration"));
				bads.add(currentBad);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeConnection(stm, rs);
		}
		return bads;
	}

	@Override
	public Bad getBadByOrder(Integer orderId) {
		String selectSQL = "SELECT * FROM bads WHERE order_id = " + orderId;
		Bad bad = new Bad();
		Connection conn = null;
		Statement stm = null;
		ResultSet rs = null;
		try {
			conn = DBUtils.getConnection();
			stm = conn.createStatement();
			rs = stm.executeQuery(selectSQL);
			while(rs.next()) {
				bad.setBadId(rs.getInt("bad_id"));
				bad.setOrderId(rs.getInt("order_id"));
				bad.setManId(rs.getInt("man_id"));
				bad.setBadBoxNumber(rs.getInt("bad_boxNumber"));
				bad.setBadDecoration(rs.getString("bad_decoration"));
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeConnection(stm, rs);
		}
		return bad;
	}

	@Override
	public ArrayList<Bad> getAllByCurrentManagerId(Integer currentManagerId) {
		String selectSQL = "SELECT * FROM bads WHERE man_id = " + currentManagerId;
		ArrayList<Bad> bads = new ArrayList<Bad>();
		Connection conn = null;
		Statement stm = null;
		ResultSet rs = null;
		try {
			conn = DBUtils.getConnection();
			stm = conn.createStatement();
			rs = stm.executeQuery(selectSQL);
			while(rs.next()) {
				Bad currentBad = new Bad();
				currentBad.setBadId(rs.getInt("bad_id"));
				currentBad.setOrderId(rs.getInt("order_id"));
				currentBad.setManId(rs.getInt("man_id"));
				currentBad.setBadBoxNumber(rs.getInt("bad_boxNumber"));
				currentBad.setBadDecoration(rs.getString("bad_decoration"));
				bads.add(currentBad);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeConnection(stm, rs);
		}
		return bads;
	}

	@Override
	public Bad getBadByOrderAndCurrentManagerId(Integer currentManagerId, Integer orderId) {
		String selectSQL = "SELECT * FROM bads WHERE order_id = " + orderId + " AND man_id = " + currentManagerId;
		Bad bad = new Bad();
		Connection conn = null;
		Statement stm = null;
		ResultSet rs = null;
		try {
			conn = DBUtils.getConnection();
			stm = conn.createStatement();
			rs = stm.executeQuery(selectSQL);
			while(rs.next()) {
				bad.setBadId(rs.getInt("bad_id"));
				bad.setOrderId(rs.getInt("order_id"));
				bad.setManId(rs.getInt("man_id"));
				bad.setBadBoxNumber(rs.getInt("bad_boxNumber"));
				bad.setBadDecoration(rs.getString("bad_decoration"));
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeConnection(stm, rs);
		}
		return bad;
	}

	@Override
	public Integer deleteBadByBadId(Integer badId) {
		String deleteSQL = "DELETE FROM bads WHERE bad_id = " + badId;
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
	public Integer getBadBoxNumberById(Integer badId) {
		String selectSQL = "SELECT * FROM bads WHERE bad_id = " + badId;
		Integer badBoxNumber = 0;
		Connection conn = null;
		Statement stm = null;
		ResultSet rs = null;
		try {
			conn = DBUtils.getConnection();
			stm = conn.createStatement();
			rs = stm.executeQuery(selectSQL);
			rs.next();
			badBoxNumber = rs.getInt("bad_boxNumber");
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeConnection(stm, rs);
		}
		return badBoxNumber;
	}

	@Override
	public Integer mofiyBadById(Integer badId, Integer badBoxNumber, String badDecoration, Integer managerId) {
		String updateSQL = "UPDATE bads SET "
				+ "man_id = " + managerId + ","
				+ "bad_boxNumber = " + badBoxNumber + ","
				+ "bad_decoration = '" + badDecoration + "'"
				+ " WHERE bad_id = " + badId;
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
