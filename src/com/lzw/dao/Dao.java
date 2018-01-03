package com.lzw.dao;

import java.sql.*;

public class Dao {
	
	private final static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private final static String DB_URL = "jdbc:mysql://60.205.211.111:3306/demo_db?useSSL=false&autoReconnect=true";
	private final static String USER = "ywm";
	private final static String PASS = "qmdx00";
	
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
	
}
