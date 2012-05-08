package util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.text.DateFormatter;

import org.joda.time.DateTime;

public class CalendarHelper {
	
	
	/**
	 * @author baljedai
	 *  This method will use JODA API to return current year.
	 * @return current year. 
	 */
	public static String getCurrentYear(){
		
		DateTime date = new DateTime(); 
		
		return new Integer(date.getYear()).toString();
	}
	
	
   public static String getTodayDate(){
	   DateTime date = new DateTime(); 
		
		return new Integer(date.getYear()).toString() + "-" + new Integer(date.getMonthOfYear()).toString()+"-"+new Integer(date.getDayOfMonth()).toString();
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
