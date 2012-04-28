package util;

import java.text.SimpleDateFormat;

import org.joda.time.DateTime;

public class CalendarHelper {
	
	
	public static String getCurrentYear(){
		
		DateTime date = new DateTime(); 
		
		return new Integer(date.getYear()).toString();
	}

}
