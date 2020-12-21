package cn.wellswang.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import cn.wellswang.utils.DBUtils;

public class ManagerInfoDAOImpl implements ManagerInfoDAO{

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
}
