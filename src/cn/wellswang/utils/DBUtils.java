package cn.wellswang.utils;

import java.sql.*;

public class DBUtils {
	private static String driverClass = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://47.93.182.162:3306/warehouse?useUnicode=true&characterEncoding=utf-8";
	private static String user = "root";
	private static String password = "001005";
	private static Connection conn;
	/**
	 * 获取数据库的连接
	 */
	public static Connection getConnection() throws Exception {
		//1.加载驱动
		Class.forName(driverClass);
		//2.获取连接
		conn = DriverManager.getConnection(url,user,password);
		return conn;
	}
	public static void closeConnection(Statement stm) {
		try {
			if(stm != null) {
				stm.close();
			}
			if(conn != null) {
				conn.close();
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public static void closeConnection(Statement stm, ResultSet rs) {
		try {
			if(stm != null) {
				stm.close();
			}
			if(rs != null) {
				rs.close();
			}
			if(conn != null) {
				conn.close();
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
