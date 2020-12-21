package cn.wellswang.utils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DBUtils {
	private static String driverClass = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://127.0.0.1:3306/warehouse";
	private static String user = "root";
	private static String password = "001005";
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
		Connection con = DriverManager.getConnection(url,user,password);
		System.out.println(con);
		return con;
	}
}
