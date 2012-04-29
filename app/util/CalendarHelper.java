package util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.text.DateFormatter;

import org.joda.time.DateTime;

public class CalendarHelper {
	
	
	public static String getCurrentYear(){
		
		DateTime date = new DateTime(); 
		
		return new Integer(date.getYear()).toString();
	}
	
	/**
	 * @author baljedai
	 * @param string Event date YYYY-MM-DD 
	 * @return MMDD string 
	 */
	public static String formatDateString(String strDate){
		
		strDate = strDate.substring(4, 10);
		strDate = strDate.replace("-","");
		return strDate;
	}

}
