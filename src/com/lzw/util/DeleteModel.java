package com.lzw.util;

import java.sql.SQLException;
import com.lzw.dao.Dao;
import com.lzw.item.Item;

public class DeleteModel {
	/*
	 * 	ɾ������;
	 */
	public static void delete(String sql) {
		UpdateModel.update(sql);
	}
	/*
	 * 	ɾ��ָ���ɹ�����
	 */
	public static void deleteBuy(Item item){
		String where = "name='"+item.getName() + "'";
		if(item.getNumber() != null){
			where = "number='" + item.getNumber() + "'";
		}
		try {
			Dao.conn.createStatement().execute("delete from tb_buy where "+where);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/*
	 * 	ɾ�����вɹ�����
	 */
	public static void deleteAllBuy(){
		try {
			Dao.conn.createStatement().execute("delete from tb_buy");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/*
	 * 	ɾ��ָ����������
	 */
	public static void deleteSell(Item item){
		String where = "name='"+item.getName() + "'";
		if(item.getNumber() != null){
			where = "number='" + item.getNumber() + "'";
		}
		try {
			Dao.conn.createStatement().execute("delete from tb_sell where "+where);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/*
	 * 	ɾ��������������
	 */
	public static void deleteAllSell(Item item){
		try {
			Dao.conn.createStatement().execute("delete from tb_sell");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/*
	 * 	ɾ��ָ���������
	 */
	public static void deleteStore(Item item){
		String where = "name='"+item.getName() + "'";
		try {
			Dao.conn.createStatement().execute("delete from tb_store where "+where);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/*
	 * 	ɾ�����п������
	 */
	public static void deleteAllStore(Item item){
		try {
			Dao.conn.createStatement().execute("delete from tb_store");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/*
	 * 	ɾ��ָ����Ӧ������
	 */
	public static void deletePro(Item item){
		String where = "name='"+item.getName() + "'";
		if(item.getNumber() != null){
			where = "number='" + item.getNumber() + "'";
		}
		try {
			Dao.conn.createStatement().execute("delete from tb_pro where "+where);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/*
	 * 	ɾ�����й�Ӧ������
	 */
	public static void deleteAllPro(Item item){
		try {
			Dao.conn.createStatement().execute("delete from tb_pro");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/*
	 * 	ɾ��ָ���û�����
	 */
	public static void deleteUser(String username){
		String where = "name='"+username + "'";
		try {
			Dao.conn.createStatement().execute("delete from tb_User where "+where);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
