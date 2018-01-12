package com.lzw.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Dao {
	
	private final static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private final static String DB_URL = "jdbc:mysql://60.205.211.111:3306/db_design?useSSL=false&autoReconnect=true&failOverReadOnly=false";
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
	 * 	查询指定结果集;
	 */
	public static ResultSet findForResultSet(String sql){
		if (conn == null){
			System.out.println("conn=null");
			return null;
		}
		ResultSet rs = null;
		try {
			Statement stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (Exception e) {
			System.out.println("连接数据库超时");
		}
		return rs;
	}
	/*
	 *	 查询所有结果的集合;
	 */
	@SuppressWarnings("rawtypes")
	public static List findForList(String sql) {
		List<List> list = new ArrayList<List>();
		ResultSet rs = findForResultSet(sql);
		try {
			ResultSetMetaData metaData = rs.getMetaData();
			int colCount = metaData.getColumnCount();
			while (rs.next()) {
				List<String> row = new ArrayList<String>();
				for (int i = 1; i <= colCount; i++) {
					String str = rs.getString(i);
					if (str != null && !str.isEmpty())
						str = str.trim();
					row.add(str);
				}
				list.add(row);
			}
		} catch (Exception e) {
			System.out.println("查询数据失败,集合为空");
		}
		return list;
	}
}
