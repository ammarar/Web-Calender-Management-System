package controllers;

import play.*;
import play.data.validation.Equals;
import play.data.validation.Required;
import play.jobs.OnApplicationStart;
import play.data.validation.*;
import play.libs.Crypto;
import play.libs.Mail;
import play.mvc.*;
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
    
    public static void createBirthdayEventForm(String name, String date, Long createdBy, String eventType)
    {
    	validation.required(name);
    	validation.required(date);
    	validation.required(createdBy);
    	SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
		try {
			f.parse(date);
		} catch (ParseException e) {
			validation.addError("date", "Date is not in yyyy-MM-dd format");
		}
	    if(validation.hasErrors()) 
	    {
	          params.flash();
	          validation.keep();
	          createBirthdayEvent();
	    }
	    //Put the username for createdBy instead of 2
	    Event ev = new Event(name, date, createdBy, 2, eventType);
	    System.out.println(ev);
	    ev.save();
		index();
    }
    
    /**
     * This method is responsible for rendering the Calendar monthly view..  
     */
    public static void calendarMonth()
    {
    	List<Event> events = Event.findAll();
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
