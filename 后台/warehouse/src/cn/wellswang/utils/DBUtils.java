package cn.wellswang.utils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBUtils {
	private static String driverClass = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://127.0.0.1:3306/warehouse";
	private static String user = "root";
	private static String password = "001005";
	private static Connection conn;
	/**
	 * 获取数据库的连接
	 */
	public static Connection getConnection() throws Exception {
		//1.读取配置文件的4个基本信息
//		InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties");
//		Properties pros = new Properties();
//		pros.load(is);
//		String user = pros.getProperty("user");
//		String password = pros.getProperty("password");
//		String url = pros.getProperty("url");
//		String driverClass = pros.getProperty("driverClass");
		//2.加载驱动
		Class.forName(driverClass);
		//3.获取连接
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
