/*
 * @Author Rully Andhika a.k.a jarul
 * www.heyrul.com-2017
 */
package com.heyrul.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtils {
	
	private static Connection connection;
	
	public static Connection getConnectionPostgreSQL() {
		if(connection == null) {
			try {
				// String url = "jdbc:postgresql://localhost:5432/rcollection?user=postgres?password=postgres&ssl=true";
				/* Using Properties */
				String url = "jdbc:postgresql://192.168.43.211:5432/rcollection";
				Properties properties = new Properties();
				properties.setProperty("user", "postgres");
				properties.setProperty("password", "postgres");
				properties.setProperty("ssl", "true");
				properties.setProperty("sslfactory", "org.postgresql.ssl.NonValidatingFactory"); // to ignore ssl certificate issue
				
				DriverManager.registerDriver(new org.postgresql.Driver());
				// connection = DriverManager.getConnection(url);
				connection = DriverManager.getConnection(url, properties);
			} catch (SQLException e) {
				e.printStackTrace();;
			}
		}
		return connection;
	}
	
	public static Connection getConnectionMSSQL() {
		if(connection == null) {
			try {
				// String url = "jdbc:sqlserver://localhost:1433;database=rcollection;integratedSecurity=true"; // With windows authentication
				String url = "jdbc:sqlserver://localhost:1433;user=sa;password=pass1234;database=rcollection";
				
				DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
				connection = DriverManager.getConnection(url);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return connection;
	}
	
	public static Connection getConnectionMySQL() {
		if(connection == null) {
			try {
				String url = "jdbc:mysql://localhost:3306/rcollection";
				String user = "root";
				String password = "toor";
				
				DriverManager.registerDriver(new com.mysql.jdbc.Driver());
				connection = DriverManager.getConnection(url, user, password);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return connection;
	}
	
	public static Connection getConnectionOracle() {
		if(connection == null) {
			try {
				String url = "jdbc:oracle:thin:@localhost:1521/orcl";
				String user = "SYSTEM";
				String password = "Pass123";
				
				DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
				connection = DriverManager.getConnection(url, user, password);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return connection;
	}

}
