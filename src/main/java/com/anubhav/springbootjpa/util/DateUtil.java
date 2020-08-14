package com.anubhav.springbootjpa.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	
	public static Date formatDate(Date date) throws ParseException {
		SimpleDateFormat targetFormat=new SimpleDateFormat("dd-MM-yyyy");
		String dateString =targetFormat.format(date);
		Date result=targetFormat.parse(dateString);
		return result;
	}
}
