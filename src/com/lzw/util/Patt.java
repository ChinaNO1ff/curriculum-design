package com.lzw.util;

import java.util.regex.Matcher;
/*
 * 	正则表达式工具类;
 */
import java.util.regex.Pattern;

public class Patt {
	/*
	 * 	判断是否为正整数;
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
	 * 	判断是否为正实数;
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
	 * 	判断是否为编号;
	 */
	public static boolean isNumber(String str){ 
		Pattern pattern = Pattern.compile("^No.[0-9]{12}");
		Matcher isNum = pattern.matcher(str);
		if( !isNum.matches() ){
			return false; 
		} 
		return true; 
	}
}
