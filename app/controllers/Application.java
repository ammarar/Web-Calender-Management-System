package controllers;

import play.*;
import play.data.validation.Equals;
import play.data.validation.Required;
import play.jobs.OnApplicationStart;
import play.data.validation.*;
import play.libs.Crypto;
import play.libs.Mail;
import play.mvc.*;
import util.CalendarHelper;
import util.SendEmails;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.apache.commons.mail.SimpleEmail;
import org.joda.time.LocalDate;

import models.*;

/** 
 * 
 * @author niau
 * Protect Main Application Controller 
 * To activate the protection e.g authentication please remove the comment from the following route 
 * *      / =               module:secure
 */
//@With(Secure.class)
public class Application extends Controller {

	
	@Before
	static void addDefaults() {
		String currentYear = CalendarHelper.getCurrentYear();
		 renderArgs.put("currentYear", currentYear);
	}
	
    public static void index() {
        //calendarMonth();
    	render();
    }
    
    public static void createBirthdayEvent()
    {
    	List<User> users = User.findAll();
    	System.out.println(users);
    	render(users);
    }
    
    public static void createBirthdayEventForm(String name, String date, String birthdayPerson, Boolean surprise)
    {
    	validation.required(name);
    	validation.required(date);
    	validation.required(birthdayPerson);
    	SimpleDateFormat f = new SimpleDateFormat("MM/dd/yyyy");
		try {
			f.parse(date);
		} catch (ParseException e) {
			validation.addError("date", "Date is not in MM/DD/YYYY format");
		}
	    if(validation.hasErrors()) {
	    	System.out.println("PRogleahj");
	          params.flash(); // add http parameters to the flash scope
	          validation.keep(); // keep the errors for the next request
	          createBirthdayEvent();
	    }
    	BirthdayEvent be = new BirthdayEvent(name, date, birthdayPerson, surprise);
    	be.save();
		index();
    }
    
    /**
     * This method is responsible for rendering the Calendar monthly view..  
     */
    public static void calendarMonth()
    {
    	List<Event> events = Event.findAll();
    	for (Event e : events)
    	{
    		e.getDate();
    	}
    	render(events);
    }

    /**
     * Get: register which direct to register form
     */
    public static void register() {
    	render();
    }
    /**
     * Post: process register form
     */
    public static void registerForm(
    		@Required String username, 
    		@Required String firstname,
    		@Required String lastname, 
    		@Required @Email String email,
    		@Required String password, 
    		@Required @Equals("password") String confirmPassword, 
    		String button) {
    	
    	if (button.equals("Cancel")) {
    		index();
    		return;
    	}
    	
    	// form validation	
    	if (validation.hasErrors()) {
    		params.flash();
    		validation.keep();
    		register();
    	}
    	else {
    		// save to database
    		String hashedPassword = Crypto.passwordHash(password);
    		User user = new User(username, firstname, lastname, email, hashedPassword, 0);
    		user.save();
    		
    		// send Email 
    		SendEmails se = new SendEmails();
    		se.welcome(user);
    		
    		index();
    	}
    }
  
}
