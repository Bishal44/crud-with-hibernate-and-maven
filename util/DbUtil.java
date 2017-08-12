package com.bishal.sis.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {
	private static final String DRIVER_NAME = "com.mysql.jdbc.Driver";
	private static final String DATABASE_NAME = "servlet_curd_demo";
	private static final String URL = "jdbc:mysql://localhost:3306/";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "root";
	
	public static Connection getConnection() throws ClassNotFoundException,SQLException{
		Class.forName(DRIVER_NAME);
		Connection con = DriverManager.getConnection(URL + DATABASE_NAME, USERNAME, PASSWORD);
		return con;
	}

}
