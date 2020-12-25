package cn.wellswang.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import cn.wellswang.entity.Bad;
import cn.wellswang.utils.DBUtils;
import cn.wellswang.dao.BadInfoDAO;

public class BadInfoDAOImpl implements BadInfoDAO {

	@Override
	public int insertBadInfo(Bad newBad) {
		Integer bad_id = newBad.getBad_id();
		Integer order_id = newBad.getOrder_id();
		Integer man_id = newBad.getMan_id();
		Integer bad_boxNumber = newBad.getBad_boxNumber();
		String bad_decoration = newBad.getBad_decoration();
		String insertSQL = "INSET INTO bads(bad_id, order_id, man_id, bad_boxNumber, bad_decoration) "
				+ "VALUES("
				+ bad_id + ","
				+ order_id + ","
				+ man_id + ","
				+ bad_boxNumber +",'"
				+ bad_decoration + "'"
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
		String deleteSQL = "DELETE FROM bad WHERE bad_id = " + deleteBad.getBad_id();
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
		Integer bad_id = oldBad.getBad_id();
		Integer order_id = newBad.getOrder_id();
		Integer man_id = newBad.getMan_id();
		Integer bad_boxNumber = newBad.getBad_boxNumber();
		String bad_decoration = newBad.getBad_decoration();
		String updateSQL = "UPDATE bads SET " 
							+ "order_id = " + order_id + ","
							+ "man_id = " + man_id + ","
							+ "bad_boxNumber = " + bad_boxNumber + ","
							+ "bad_decoration = '" + bad_decoration + "'"
							+ " WHERE bad_id = " + bad_id;
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
	public Bad getBadById(Integer bad_id) {
		String selectSQL = "SELECT * FROM bads WHERE bad_id = " + bad_id;
		Bad bad = new Bad();
		Connection conn = null;
		Statement stm = null;
		ResultSet rs = null;
		try {
			conn = DBUtils.getConnection();
			stm = conn.createStatement();
			rs = stm.executeQuery(selectSQL);
			while(rs.next()) {
				bad.setBad_id(rs.getInt("bad_id"));
				bad.setOrder_id(rs.getInt("order_id"));
				bad.setMan_id(rs.getInt("man_id"));
				bad.setBad_boxNumber(rs.getInt("bad_boxNumber"));
				bad.setBad_decoration(rs.getString("bad_decoration"));
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
				currentBad.setBad_id(rs.getInt("bad_id"));
				currentBad.setOrder_id(rs.getInt("order_id"));
				currentBad.setMan_id(rs.getInt("man_id"));
				currentBad.setBad_boxNumber(rs.getInt("bad_boxNumber"));
				currentBad.setBad_decoration(rs.getString("bad_decoration"));
				bads.add(currentBad);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeConnection(stm, rs);
		}
		return bads;
	}
	public static void main(String[] args) {
		
	}
}
