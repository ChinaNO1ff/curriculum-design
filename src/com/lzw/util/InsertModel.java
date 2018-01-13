package com.lzw.util;

import java.sql.SQLException;
import java.sql.Statement;
import com.lzw.dao.Dao;
import com.lzw.dao.model.*;

public class InsertModel {
	/*
	 * 	插入数据方法;
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
	 *	 插入采购数据;
	 */
	public static void insertBuy(TbBuy tb){
		insert("insert into tb_buy values('"+ tb.getNumber() + "','" + tb.getName() + "','"
		+tb.getUnit() + "','" + tb.getCount() + "','" + tb.getTotal() + "','" + tb.getPerson() + "','" +
		tb.getType() + "')");
	}
	/*
	 * 	插入销售数据;
	 */
	public static void insertSell(TbSell tb){
		insert("insert into tb_sell values('"+ tb.getNumber() + "','" + tb.getName() + "','"
				+tb.getUnit() + "','" + tb.getCount() + "','" + tb.getTotal() + "','" 
				+ tb.getProvide() + "')");
	}
	/*
	 * 	插入库存数据;
	 */
	public static void insertStore(TbStore tb){
		insert("insert into tb_store values('"+ tb.getNumber() + "','" + tb.getName() + "','"
				+tb.getUnit() + "','" + tb.getCount() + "','" + tb.getType() + "')");
	}
	/*
	 *	 插入供应商数据;
	 */
	public static void insertPro(TbPro tb){
		insert("insert into tb_pro values('"+ tb.getNumber() + "','" + tb.getName() + "','"
				+tb.getPhone() + "','" + tb.getMail() + "','" + tb.getAddress() + "')");
	}
	/*
	 *	 插入用户数据;
	 */
	public static void insertUser(TbUser tb){
		insert("insert into tb_user values('"+ tb.getName() + "','" + tb.getPassword()+ "')");
	}

}
