package controllers;

import play.*;
import play.mvc.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import org.joda.time.LocalDate;

import models.*;

public class Application extends Controller {

    public static void index() {
        render();
    }
    
    public static void createBirthdayEvent(String name, String date, String birthdayPerson, Boolean surprise)
    {
    	validation.required(name);
    	validation.required(date);
    	validation.required(birthdayPerson);
    	validation.required(surprise);
    	SimpleDateFormat f = new SimpleDateFormat("MM/dd/yyyy");
		try {
			f.parse(date);
		} catch (ParseException e) {
			validation.addError("date", "Date is not in MM/DD/YYYY format");
		}
    	BirthdayEvent be = new BirthdayEvent(name, date, birthdayPerson, surprise);
    	be.save();
    	//Put the view of the confirmation page
    }
    
    public static void createBirthdayEventForm()
    {
    	render();
    }

}