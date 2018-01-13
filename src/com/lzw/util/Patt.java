package com.lzw.util;

import java.util.regex.Matcher;
/*
 * 	������ʽ������;
 */
import java.util.regex.Pattern;

public class Patt {
	/*
	 * 	�ж��Ƿ�Ϊ������;
	 */
	public static boolean isCount(String str){ 
		Pattern pattern = Pattern.compile("[1-9]\\d*");
		Matcher isNum = pattern.matcher(str);
		if( !isNum.matches() ){
			return false; 
		} 
		return true; 
	}
	/*
	 * 	�ж��Ƿ�Ϊ��ʵ��;
	 */
	public static boolean isUnit(String str){ 
		Pattern pattern = Pattern.compile("([1-9]\\d*|0)(\\.\\d+)?");
		Matcher isNum = pattern.matcher(str);
		if( !isNum.matches() ){
			return false; 
		} 
		return true; 
	}
	/*
	 * 	�ж��Ƿ�Ϊ���;
	 */
	public static boolean isNumber(String str){ 
		Pattern pattern = Pattern.compile("^No.[0-9]{12}");
		Matcher isNum = pattern.matcher(str);
		if( !isNum.matches() ){
			return false; 
		} 
		return true; 
	}
	/*
	 * 	�ж��Ƿ�Ϊ�ֻ���;
	 */
	public static boolean isPhone(String str){
		Pattern pattern = Pattern.compile("(13\\d|14[579]|15[^4\\D]|17[^49\\D]|18\\d)\\d{8}");
		Matcher isNum = pattern.matcher(str);
		if( !isNum.matches() ){
			return false; 
		} 
		return true; 
	}
	/*
	 * 	�ж��Ƿ�Ϊ�Ϸ��������;
	 */
	public static boolean isMail(String str){
		Pattern pattern = Pattern.compile("\\w[-\\w.+]*@([A-Za-z0-9][-A-Za-z0-9]+\\.)+[A-Za-z]{2,14}");
		Matcher isNum = pattern.matcher(str);
		if( !isNum.matches() ){
			return false; 
		} 
		return true; 
	}
}
