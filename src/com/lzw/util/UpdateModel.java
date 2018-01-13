package com.lzw.util;

import java.sql.SQLException;
import java.sql.Statement;
import com.lzw.dao.Dao;
import com.lzw.dao.model.*;

public class UpdateModel {
	/*
	 * 	�޸����ݷ���;
	 */
	public static void update(String sql) {
		try {
			Statement stmt = Dao.conn.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/*
	 * 	�޸Ĳɹ�����;
	 */
	public static void updateBuy(TbBuy tb){
		update("update tb_buy set number='" + tb.getNumber() + "',name='" 
				+ tb.getName() + "',unit='" + tb.getUnit() + "',count='" 
				+ tb.getCount() + "',person='" + tb.getPerson() + "',type='" 
				+ tb.getType() + "',total='" + tb.getTotal() + "' where number='"
				+ tb.getNumber() + "'");
	}
	/*
	 * �޸���������;
	 */
	public static void updateSell(TbSell tb){
		update("update tb_sell set number='" + tb.getNumber() + "',name='"
				+ tb.getName() + "',unit='" + tb.getUnit() + "',count='" 
				+ tb.getCount() + "',total='" + tb.getTotal() + "',provide='"
				+ tb.getProvide()+ "' where number='" + tb.getNumber() + "'");
	}
	/*
	 * �޸Ŀ������;
	 */
	public static void updateStore(TbStore tb){
		update("update tb_store set number='" + tb.getNumber() + "',name='"
				+ tb.getName() + "',unit='" + tb.getUnit() + "',count='" 
				+ tb.getCount() + "',type='" + tb.getType() + "' where number='" 
				+ tb.getNumber() + "'");
	}
	/*
	 * �޸Ĺ�Ӧ������;
	 */
	public static void updatePro(TbPro tb){
		update("update tb_pro set name='" + tb.getName() + "',phone='" 
				+ tb.getPhone() + "',mail='" + tb.getMail() 
				+ "',address='" + tb.getAddress() + "' where number='" 
				+ tb.getNumber() + "'");
	}
	/*
	 * 	�޸��û�����;
	 */
	public static void updateUser(TbUser tb){
		update("update tb_user set password='" 
		+ tb.getPassword() + "' where name='" + tb.getName() + "'");
	}
}
