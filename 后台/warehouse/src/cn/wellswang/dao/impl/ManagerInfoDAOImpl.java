package cn.wellswang.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import cn.wellswang.dao.ManagerInfoDAO;
import cn.wellswang.entity.Goods;
import cn.wellswang.entity.Manager;
import cn.wellswang.entity.Supplier;
import cn.wellswang.utils.DBUtils;

public class ManagerInfoDAOImpl implements ManagerInfoDAO{

	@Override
	public int insertManagerInfo(Manager newManager) {
		Integer man_id = newManager.getMan_id();
		String man_name = newManager.getMan_name();
		String man_password = newManager.getMan_password();
		Integer man_type = newManager.getMan_type();
		String insertSQL = "INSERT INTO managers(man_id, man_name, man_password, man_type) "
				+ "VALUES("
				+ man_id + ",'"
				+ man_name + "','"
				+ man_password + "',"
				+ man_type + ""
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
		String deleteSQL = "DELETE FROM managers WHERE man_id = " + deleteManager.getMan_id();
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
		Integer man_id = oldManager.getMan_id();
		String man_name = newManager.getMan_name();
		String man_password = newManager.getMan_password();
		Integer man_type = newManager.getMan_type();
		String updateSQL = "UPDATE managers SET " 
							+ "man_name = '" + man_name + "',"
							+ "man_password = '" + man_password + "',"
							+ "man_type = '" + man_type + "'"
							+ " WHERE man_id = " + man_id;
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
				manager.setMan_id(rs.getInt("man_id"));
				manager.setMan_name(rs.getString("man_name"));
				manager.setMan_password(rs.getString("man_password"));
				manager.setMan_type(rs.getInt("man_type"));
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
				currentManager.setMan_id(rs.getInt("man_id"));
				currentManager.setMan_name(rs.getString("man_name"));
				currentManager.setMan_password(rs.getString("man_password"));
				currentManager.setMan_type(rs.getInt("man_type"));
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
	public boolean login(Integer man_type, Integer man_id, String man_password) {
		String SQL = "SELECT * FROM managers WHERE man_id = " + man_id;
		boolean flag = false;
		try {
			Connection con = DBUtils.getConnection();
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(SQL);
			rs.next();
			Integer executeMan_type = Integer.parseInt(rs.getString("man_type"));
			String executeMan_password = rs.getString("man_password");
			if(man_type == executeMan_type && man_password.equals(executeMan_password)) {
				flag = true;
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	public static void main(String[] args) {
		ManagerInfoDAOImpl m = new ManagerInfoDAOImpl();
//		Manager manager = new Manager(4, "Eric", "001005", 3);
//		Manager modifyManager = new Manager(4, "Eric2", "20001005", 2);
//		m.insertManagerInfo(manager);
//		m.deleteManagerInfo(manager);
//		m.updateManagerInfo(manager, modifyManager);
//		Manager returnManager = m.getManagerById(4);
//		System.out.println("编号：" + returnManager.getMan_id());
//		System.out.println("用户名：" + returnManager.getMan_name());
//		System.out.println("密码：" + returnManager.getMan_password());
//		System.out.println("类型：" + returnManager.getMan_type());
		ArrayList<Manager> managers = m.getAll();
		
		for(Manager manager : managers) {
			System.out.println("编号：" + manager.getMan_id());
			System.out.println("用户名：" + manager.getMan_name());
			System.out.println("密码：" + manager.getMan_password());
			System.out.println("类型：" + manager.getMan_type());
			System.out.println("--------");
		}
	}
}
