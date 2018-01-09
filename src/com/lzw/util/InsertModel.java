package com.lzw.util;

import java.sql.SQLException;
import java.sql.Statement;
import com.lzw.dao.Dao;
import com.lzw.dao.model.*;

public class InsertModel {
	/*
	 * 	�������ݷ���;
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
	 *	 ����ɹ�����;
	 */
	public static void insertBuy(TbBuy tb){
		insert("insert into tb_buy values("+ tb.getNumber() + tb.getName()
		+tb.getUnit() + tb.getCount() + tb.getTotal() + tb.getPerson() +
		tb.getType() + ");");
	}
	/*
	 * 	������������;
	 */
	public static void insertSell(TbSell tb){
		insert("insert into tb_buy values("+ tb.getNumber() + tb.getName()
		+tb.getUnit() + tb.getCount() + tb.getTotal() + tb.getTotal() +
		tb.getMore() + ");");
	}
	/*
	 * 	����������;
	 */
	public static void insertStore(TbStore tb){
		insert("insert into tb_buy values("+ tb.getNumber() + tb.getName()
		+tb.getUnit() + tb.getCount() + tb.getType() + ");");
	}
}
