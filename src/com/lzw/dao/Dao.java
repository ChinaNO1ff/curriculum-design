package com.lzw.dao;

import java.sql.*;

public class Dao {
	
	private final static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private final static String DB_URL = "jdbc:mysql://60.205.211.111:3306/db_design?useSSL=false&autoReconnect=true";
	private final static String USER = "admin";
	private final static String PASS = "abc123";
	
	public static Connection conn = null;
	
	static{
		try {
			if(conn == null){
				Class.forName(JDBC_DRIVER).newInstance();
				conn = DriverManager.getConnection(DB_URL,USER,PASS);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private Dao(){}

	/*
	 *	返回查询结果集;
	 */
	public static ResultSet findForResultSet(String sql){
		if (conn == null)
			return null;
		ResultSet rs = null;
		try {
			Statement stmt = null;
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			rs = stmt.executeQuery(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}
}
