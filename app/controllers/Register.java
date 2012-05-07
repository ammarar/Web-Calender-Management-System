package controllers;

import models.User;
import play.data.validation.Email;
import play.data.validation.Equals;
import play.data.validation.Required;
import util.SendEmails;
import play.mvc.*;

public class Register extends Controller{
	/**
     * When user click register which direct to register form
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
    		Application.index();
    		return;
    	}
    	
    	User user;
    	user = User.find("byUserName", username).first();
    	if (user != null) {
    		validation.addError("username", "The username already exists");
    	}
    	
    	user = null;
    	user = User.find("byEmail", email).first();
    	if (user != null) {
    		validation.addError("email", "The email already exists");
    	}
    	
    	// form validation	
    	if (validation.hasErrors()) {
    		params.flash();
    		validation.keep();
    		register();
    	}
    	else {
    		// save to database
    		//String hashedPassword = Crypto.passwordHash(password);
    		user = new User(username, firstname, lastname, email, password, 0);
    		user.save();
    		
    		// send Email 
    		SendEmails se = new SendEmails();
    		se.welcome(user);
    		
    		Application.index();
    	}
    }

    /**
     * When user click 'forget password' link, direct user to the view to 
     * retrieve password
     */
    public static void forgetPassword() {
    	render();
    }
    /**
     * When user confirm to request password, process the request form
     */
    public static void requestPasswordForm (
    	@Required String username,  
		@Required @Email String email,
		String button) {
	
		if (button.equals("Cancel")) {
			Application.index();
			return;
		}
		
		User user = User.find("byUserName", username).first();
		if (user == null)
		{
			validation.addError("username", "username doesn't exist");
		}
		
		// form validation	
		if (validation.hasErrors()) {
			params.flash();
			validation.keep();
			forgetPassword();
		}
		else {	
			// send Email 
			SendEmails se = new SendEmails();
			se.sendPassword(user);
			
			Application.index();
		}
    }
}
