package com.lzw.util;

import java.sql.SQLException;
import java.sql.Statement;
import com.lzw.dao.Dao;
import com.lzw.dao.model.*;

public class InsertModel {
	/*
	 * 	插入数据方法;
	 */
	public static boolean insert(String sql) {
		boolean result = false;
		try {
			Statement stmt = Dao.conn.createStatement();
			result = stmt.execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	/*
	 *	 插入采购数据;
	 */
	public static void insertBuy(TbBuy tb){
		insert("insert into tb_buy values("+ tb.getNumber() + tb.getName()
		+tb.getUnit() + tb.getCount() + tb.getTotal() + tb.getPerson() +
		tb.getType() + ");");
	}
	/*
	 * 	插入销售数据;
	 */
	public static void insertSell(TbSell tb){
		insert("insert into tb_buy values("+ tb.getNumber() + tb.getName()
		+tb.getUnit() + tb.getCount() + tb.getTotal() + tb.getTotal() +
		tb.getMore() + ");");
	}
	/*
	 * 	插入库存数据;
	 */
	public static void insertStore(TbStore tb){
		insert("insert into tb_buy values("+ tb.getNumber() + tb.getName()
		+tb.getUnit() + tb.getCount() + tb.getType() + ");");
	}
}
