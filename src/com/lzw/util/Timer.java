package com.lzw.util;

import java.util.Date;

public class Timer {
	private String num;
	private Timer(){
		Date date = new Date();
		String year = String.format("%ty", date);
		String month = String.format("%tm", date);
		String day = String.format("%td", date);
		String hour = String.format("%tH", date);
		String minute = String.format("%tM", date);
		String second = String.format("%tS", date);
		num = "No."+year+month+day+hour+minute+second;
	}
	public static String getNum(){
		return new Timer().num;
	}
}
