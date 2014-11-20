package com.rcd.im.info;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

	public static Connection getJDBCConnection() {
		String driverClassName = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost/movie";
		String username = "root";
		String password = "";
		Connection conn = null;
		try {
			Class.forName(driverClassName);
			conn = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return conn;
	}

}