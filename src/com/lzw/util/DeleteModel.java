package com.lzw.util;

import java.sql.SQLException;
import com.lzw.dao.Dao;
import com.lzw.item.Item;

public class DeleteModel {
	/*
	 * 	删除数据;
	 */
	public static void delete(String sql) {
		UpdateModel.update(sql);
	}
	/*
	 * 	删除指定采购数据
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
	 * 	删除所有采购数据
	 */
	public static void deleteAllBuy(){
		try {
			Dao.conn.createStatement().execute("delete from tb_buy");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/*
	 * 	删除指定销售数据
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
	 * 	删除所有销售数据
	 */
	public static void deleteAllSell(Item item){
		try {
			Dao.conn.createStatement().execute("delete from tb_sell");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/*
	 * 	删除指定库存数据
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
	 * 	删除所有库存数据
	 */
	public static void deleteAllStore(Item item){
		try {
			Dao.conn.createStatement().execute("delete from tb_store");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/*
	 * 	删除指定供应商数据
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
	 * 	删除所有供应商数据
	 */
	public static void deleteAllPro(Item item){
		try {
			Dao.conn.createStatement().execute("delete from tb_pro");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/*
	 * 	删除指定用户数据
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
