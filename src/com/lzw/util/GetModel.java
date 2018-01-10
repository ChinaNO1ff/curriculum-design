package com.lzw.util;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.lzw.dao.Dao;
import com.lzw.dao.model.*;
import com.lzw.item.Item;

public class GetModel {
	
	/*
	 * 登录验证
	 */
	public static boolean getLogin(String name,String password){
		try {
			PreparedStatement sql = Dao.conn.prepareStatement("select * from tb_user where name = ? and password = ?");
			sql.setString(1, name);
			sql.setString(2, password);
			ResultSet res = sql.executeQuery();
			return res.next();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	/*
	 * 读取指定采购信息
	 */
	public static TbBuy getBuy(Item item){
		String where = "name='"+item.getName() + "'";
		TbBuy info = new TbBuy();
		if(item.getNumber() != null){
			where = "number='" + item.getNumber() + "'";
		}
		ResultSet set = Dao.findForResultSet("select * from tb_buy where "+where);
		try {
			if(set.next()){
				info.setNumber(set.getString("number"));
				info.setName(set.getString("name"));
				info.setUnit(set.getFloat("unit"));
				info.setCount(set.getInt("count"));
				info.setType(set.getString("type"));
				info.setPerson(set.getString("person"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return info;
	}
	/*
	 *	 查询所有的采购信息;
	 */
	@SuppressWarnings("unchecked")
	public static List<TbBuy> getAllBuy(){
		List<TbBuy> list = Dao.findForList("select * from tb_buy");
		return list;
	}
	/*
	 * 	读取指定销售信息;
	 */
	public static TbSell getSell(Item item){
		String where = "name='"+item.getName() + "'";
		TbSell info = new TbSell();
		if(item.getNumber() != null){
			where = "number='" + item.getNumber() + "'";
		}
		ResultSet set = Dao.findForResultSet("select * from tb_sell where "+where);
		try {
			if(set.next()){
				info.setNumber(set.getString("number"));
				info.setName(set.getString("name"));
				info.setUnit(set.getFloat("unit"));
				info.setCount(set.getInt("count"));
				info.setMore(set.getString("more"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return info;
	}
	/*
	 * 	读取所有的销售信息;
	 */
	@SuppressWarnings("unchecked")
	public static List<TbSell> getAllSell(){
		List<TbSell> list = Dao.findForList("select * from tb_sell");
		return list;
	}
	/*
	 * 	读取指定仓库信息
	 */
	public static TbStore getStore(Item item){
		String where = "name='"+item.getName() + "'";
		TbStore info = new TbStore();
		if(item.getNumber() != null){
			where = "number='" + item.getNumber() + "'";
		}
		ResultSet set = Dao.findForResultSet("select * from tb_store where "+where);
		try {
			if(set.next()){
				info.setNumber(set.getString("number"));
				info.setName(set.getString("name"));
				info.setUnit(set.getFloat("unit"));
				info.setCount(set.getInt("count"));
				info.setType(set.getString("type"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return info;
	}
	/*
	 * 	读取所有的仓库信息;
	 */
	@SuppressWarnings("unchecked")
	public static List<TbStore> getAllStore(){
		List<TbStore> list = Dao.findForList("select * from tb_store");
		return list;
	}
}
