/*
 * @Author Rully Andhika a.k.a jarul
 * www.heyrul.com-2017
 */
package com.heyrul.utils;

import java.sql.Connection;

public class DBUtils {
	
	private static Connection connection;
	
	public static Connection getConnectionPostgreSQL() {
		return connection;
	}
	
	public static Connection getConnectionMSSQL() {
		return connection;
	}
	
	public static Connection getConnectionMySQL() {
		return connection;
	}
	
	public static Connection getConnectionOracle() {
		return connection;
	}

}
