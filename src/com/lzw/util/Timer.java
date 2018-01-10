package com.lzw.util;

import java.util.Date;

public class Timer {
	
	private static Date date = new Date();
	public static String getNum(){
		String year = String.format("%ty", date);
		String month = String.format("%tm", date);
		String day = String.format("%td", date);
		String hour = String.format("%tH", date);
		String minute = String.format("%tM", date);
		String second = String.format("%tS", date);
		return "No."+year+month+day+hour+minute+second;
	}
}
