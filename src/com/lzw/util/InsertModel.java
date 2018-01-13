package com.lzw.util;

import java.sql.SQLException;
import java.sql.Statement;
import com.lzw.dao.Dao;
import com.lzw.dao.model.*;

public class InsertModel {
	/*
	 * 	�������ݷ���;
	 */
	public static void insert(String sql) {
		try {
			Statement stmt = Dao.conn.createStatement();
			stmt.execute(sql);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	/*
	 *	 ����ɹ�����;
	 */
	public static void insertBuy(TbBuy tb){
		insert("insert into tb_buy values('"+ tb.getNumber() + "','" + tb.getName() + "','"
		+tb.getUnit() + "','" + tb.getCount() + "','" + tb.getTotal() + "','" + tb.getPerson() + "','" +
		tb.getType() + "')");
	}
	/*
	 * 	������������;
	 */
	public static void insertSell(TbSell tb){
		insert("insert into tb_sell values('"+ tb.getNumber() + "','" + tb.getName() + "','"
				+tb.getUnit() + "','" + tb.getCount() + "','" + tb.getTotal() + "','" 
				+ tb.getProvide() + "')");
	}
	/*
	 * 	����������;
	 */
	public static void insertStore(TbStore tb){
		insert("insert into tb_store values('"+ tb.getNumber() + "','" + tb.getName() + "','"
				+tb.getUnit() + "','" + tb.getCount() + "','" + tb.getType() + "')");
	}
	/*
	 *	 ���빩Ӧ������;
	 */
	public static void insertPro(TbPro tb){
		insert("insert into tb_pro values('"+ tb.getNumber() + "','" + tb.getName() + "','"
				+tb.getPhone() + "','" + tb.getMail() + "','" + tb.getAddress() + "')");
	}
	/*
	 *	 �����û�����;
	 */
	public static void insertUser(TbUser tb){
		insert("insert into tb_user values('"+ tb.getName() + "','" + tb.getPassword()+ "')");
	}

}
