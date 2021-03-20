package cn.wellswang.dao.impl;

import cn.wellswang.dao.ManagerInfoDAO;
import cn.wellswang.entity.Manager;
import cn.wellswang.utils.DBUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ManagerInfoDAOImpl implements ManagerInfoDAO{

	@Override
	public int insertManagerInfo(Manager newManager) {
		Integer manId = newManager.getManId();
		String manName = newManager.getManName();
		String manPassword = newManager.getManPassword();
		Integer manType = newManager.getManType();
		String insertSQL = "INSERT INTO managers(man_name, man_password, man_type) "
				+ "VALUES('"
				+ manName + "','"
				+ manPassword + "',"
				+ manType + ""
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
	public int deleteManagerInfo(Manager deleteManager) {
		String deleteSQL = "DELETE FROM managers WHERE man_id = " + deleteManager.getManId();
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
	public int updateManagerInfo(Manager oldManager, Manager newManager) {
		Integer manId = oldManager.getManId();
		String manName = newManager.getManName();
		String manPassword = newManager.getManPassword();
		Integer manType = newManager.getManType();
		String updateSQL = "UPDATE managers SET " 
							+ "man_name = '" + manName + "',"
							+ "man_password = '" + manPassword + "',"
							+ "man_type = '" + manType + "'"
							+ " WHERE man_id = " + manId;
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
	public Manager getManagerById(Integer manager_id) {
		String selectSQL = "SELECT * FROM managers WHERE man_id = " + manager_id;
		Manager manager = new Manager();
		Connection conn = null;
		Statement stm = null;
		ResultSet rs = null;
		try {
			conn = DBUtils.getConnection();
			stm = conn.createStatement();
			rs = stm.executeQuery(selectSQL);
			while(rs.next()) {
				manager.setManId(rs.getInt("man_id"));
				manager.setManName(rs.getString("man_name"));
				manager.setManPassword(rs.getString("man_password"));
				manager.setManType(rs.getInt("man_type"));
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeConnection(stm, rs);
		}
		return manager;
	}

	
	@Override
	public ArrayList<Manager> getAll() {
		String selectSQL = "SELECT * FROM managers";
		ArrayList<Manager> managers = new ArrayList<Manager>();
		Connection conn = null;
		Statement stm = null;
		ResultSet rs = null;
		try {
			conn = DBUtils.getConnection();
			stm = conn.createStatement();
			rs = stm.executeQuery(selectSQL);
			while(rs.next()) {
				Manager currentManager = new Manager();
				currentManager.setManId(rs.getInt("man_id"));
				currentManager.setManName(rs.getString("man_name"));
				currentManager.setManPassword(rs.getString("man_password"));
				currentManager.setManType(rs.getInt("man_type"));
				managers.add(currentManager);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeConnection(stm, rs);
		}
		return managers;
	}
	
	@Override
	public boolean login(Integer manType, Integer manId, String manPassword) {
		String SQL = "SELECT * FROM managers WHERE man_id = " + manId;
		boolean flag = false;
		try {
			Connection con = DBUtils.getConnection();
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(SQL);
			rs.next();
			Integer executemanType = Integer.parseInt(rs.getString("man_type"));
			String executemanPassword = rs.getString("man_password");
			if(manType == executemanType && manPassword.equals(executemanPassword)) {
				flag = true;
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	/**
	 * 初始化用户界面：获取当前用户的姓名
	 * @param manId
	 * @return
	 */
	@Override
	public String getCurrentuserName(Integer manId) {
		String SQL = "SELECT man_name FROM managers WHERE man_id = " + manId;
		try {
			Connection con = DBUtils.getConnection();
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(SQL);
			rs.next();
			return rs.getString("man_name");
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean modifyPassword(Integer managerId, String oldPassword, String newPassword) {
		boolean flag = false;
		String SQL = "SELECT * FROM managers WHERE man_id = " + managerId;
		try {
			Connection con = DBUtils.getConnection();
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(SQL);
			rs.next();
			if(oldPassword.equals(rs.getString("man_password"))) {
				modifyPassword(managerId, newPassword);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	public boolean modifyPassword(Integer managerId, String newPassword) {
		String SQL = "UPDATE managers SET man_password = '"+newPassword+"' WHERE man_id = " + managerId;
		try {
			Connection con = DBUtils.getConnection();
			Statement stm = con.createStatement();
			stm.executeUpdate(SQL);
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean isTruePassword(Integer currentManager, String oldPassword) {
		String SQL = "SELECT * FROM managers WHERE man_id = " + currentManager;
		try {
			Connection con = DBUtils.getConnection();
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(SQL);
			rs.next();
			if(oldPassword.equals(rs.getString("man_password"))) {
				return true;
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Integer getManagerIdByName(String managerName) {
		String SQL = "SELECT * FROM managers WHERE man_name = '" + managerName + "'";
		try {
			Connection con = DBUtils.getConnection();
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(SQL);
			rs.next();
			return rs.getInt("man_id");
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<Manager> getManagerByLike(String keyWords) {
		String selectSQL = "SELECT * FROM managers WHERE man_name LIKE '%" + keyWords + "%'";
		ArrayList<Manager> managers = new ArrayList<Manager>();
		Connection conn = null;
		Statement stm = null;
		ResultSet rs = null;
		try {
			conn = DBUtils.getConnection();
			stm = conn.createStatement();
			rs = stm.executeQuery(selectSQL);
			while(rs.next()) {
				Manager currentManager = new Manager();
				currentManager.setManId(rs.getInt("man_id"));
				currentManager.setManName(rs.getString("man_name"));
				currentManager.setManPassword(rs.getString("man_password"));
				currentManager.setManType(rs.getInt("man_type"));
				managers.add(currentManager);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeConnection(stm, rs);
		}
		return managers;
	}

	@Override
	public Integer deleteManagerById(Integer managerId) {
		String deleteSQL = "DELETE FROM managers WHERE man_id = " + managerId;
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
	public Integer modifyManagerById(Integer manId, String manName, String manPassword, Integer manType) {
		String updateSQL = "UPDATE managers SET "
				+ "man_name = '" + manName + "',"
				+ "man_password = '" + manPassword + "',"
				+ "man_type = '" + manType + "'"
				+ " WHERE man_id = " + manId;
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
