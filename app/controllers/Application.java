package controllers;

import play.*;
import play.mvc.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import org.joda.time.LocalDate;

import models.*;
import models.errors.RegisterForm;

/** 
 * 
 * @author niau
 * Protect Main Application Controller 
 * To activate the protection e.g authentication please remove the comment from the following route 
 * *      / =               module:secure
 */
@With(Secure.class)
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

    /**
     * Get: register
     * direct to register form
     */
    public static void register() {
    	render();
    }
    /**
     * Post: process register form
     */
    public static void registerForm(String username, String firstname,
    		String lastname, String email, String password, 
    		String confirmPassword, String button) {
    	
    	if (button.equals("Cancel")) {
    		index();
    		return;
    	}
    	
    	boolean hasError = false;
    	RegisterForm rf = new RegisterForm();
    	
    	// check username
    	if ((username == null) || (username.equals(""))) {
    		rf.errors.set(0, "User name required.");
    		hasError = true;
    	}
    	else {
    		rf.setUserName(username);
    		User user = User.find("byUserName", username).first();
        	if (user != null) {
        		rf.errors.set(0, "Username already exists. Please choose another one.");
        		hasError = true;
        	}
    	}
    	// check first name
    	if ((firstname == null) || (firstname.equals(""))){
    		rf.errors.set(1, "First name required.");
    		hasError = true;
    	}
    	else {
    		rf.setFirstName(firstname);
    	}
    	// check last name
    	if ((lastname == null) || (lastname.equals(""))){
    		rf.errors.set(2, "Last name required.");
    		hasError = true;
    	}
    	else {
    		rf.setLastName(lastname);
    	}
    	// check email
    	if ((email == null) || (email.equals(""))){
    		rf.errors.set(3, "Email required.");
    		hasError = true;
    	}
    	else {
    		rf.setEmail(email);
    		User user = User.find("byEmail", email).first();
        	if (user != null) {
        		rf.errors.set(3, "The email address already exists. Please user another one.");
        		hasError = true;
        	}
    	}
    	
    	// check password
    	if ((password == null) || (confirmPassword == null) || 
    		(password.equals("") || (confirmPassword.equals("")))){
    		rf.errors.set(4, "Password required.");
    		hasError = true;
    	}
    	else {
    		if (!password.equals(confirmPassword)) {
    			rf.errors.set(4, "Password doesn't match. Please try again.");
    			hasError = true;
        	}
    	}
    	
    	if (hasError) {
    		registerError(rf);
    	}
    	else {
    		User user = new User(username, firstname, lastname, email, password, 0);
    		user.save();
    		///TODO
    		// send Email 
    		
    		index();
    	}
    }
    /**
     * return register form with valid inputs and errors
     */
    public static void registerError(RegisterForm rf) {
    	render(rf);
    }
}