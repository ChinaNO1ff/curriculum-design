package com.lzw.util;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import com.lzw.dao.Dao;
import com.lzw.dao.model.*;
import com.lzw.item.Item;

public class GetModel {
	
	/*
	 * ��¼��֤
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
	 * ��ȡָ���ɹ���Ϣ
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
			System.out.println("��ѯ����ʧ��,����Ϊ��");
		}
		return info;
	}
	/*
	 *	 ��ѯ���еĲɹ���Ϣ;
	 */
	@SuppressWarnings("unchecked")
	public static List<TbBuy> getAllBuy(){
		List<TbBuy> list = Dao.findForList("select * from tb_buy");
		return list;
	}
	/*
	 * 	��ȡָ��������Ϣ;
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
				info.setProvide(set.getString("provide"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return info;
	}
	/*
	 * 	��ȡ���е�������Ϣ;
	 */
	@SuppressWarnings("unchecked")
	public static List<TbSell> getAllSell(){
		List<TbSell> list = Dao.findForList("select * from tb_sell");
		return list;
	}
	/*
	 * 	��ȡָ���ֿ���Ϣ
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
	 * 	��ȡ���еĲֿ���Ϣ;
	 */
	@SuppressWarnings("unchecked")
	public static List<TbStore> getAllStore(){
		List<TbStore> list = Dao.findForList("select * from tb_store");
		return list;
	}
	/*
	 * ��ȡָ����Ӧ����Ϣ
	 */
	public static TbPro getPro(Item item){
		String where = "name='"+item.getName() + "'";
		TbPro info = new TbPro();
		if(item.getNumber() != null){
			where = "number='" + item.getNumber() + "'";
		}
		ResultSet set = Dao.findForResultSet("select * from tb_pro where "+where);
		try {
			if(set.next()){
				info.setNumber(set.getString("number"));
				info.setName(set.getString("name"));
				info.setPhone(set.getString("phone"));
				info.setMail(set.getString("mail"));
				info.setAddress(set.getString("address"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return info;
	}
	/*
	 * 	��ȡ���еĹ�Ӧ����Ϣ;
	 */
	@SuppressWarnings("unchecked")
	public static List<TbPro> getAllPro(){
		List<TbPro> list = Dao.findForList("select * from tb_pro");
		return list;
	}
	/*
	 * 	��ȡ���е�������Ϣ;
	 */
	@SuppressWarnings("unchecked")
	public static String getTypeByName(String name){
		List<TbType> list = Dao.findForList("select type from tb_type where name='"+name+"'");
		String res = list.toString();
		return res.substring(2,res.length()-2);//ȥ��[[]]
	}
	/*
	 * ��ȡ���е�������Ϣ;
	 */
	@SuppressWarnings("unchecked")
	public static List<TbType> getAllName(){
		List<TbType> list = Dao.findForList("select name from tb_type");
		return list;
	}
}
