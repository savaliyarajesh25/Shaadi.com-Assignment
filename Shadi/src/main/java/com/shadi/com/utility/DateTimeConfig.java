package com.shadi.com.utility;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeConfig {

	public static String getCurrentDateAndTime(String formate) {
		SimpleDateFormat sdf = new SimpleDateFormat(formate); //formate: dd/MM/yyyy HH:mm:ss
	    Date date = new Date();  
		return sdf.format(date);  
	}
}
