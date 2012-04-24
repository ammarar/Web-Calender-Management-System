package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import org.joda.time.LocalDate;

import models.*;

public class Application extends Controller {

    public static void index() {
        render();
    }
    
    public static void createBirthdayEvent(String name, LocalDate date, User birthdayPerson, boolean surprise)
    {
    	BirthdayEvent be = new BirthdayEvent(name, date, birthdayPerson, surprise);
    	be.save();
    	//Put the view of the confirmation page
    }
    
    public static void createBirthdayEventForm()
    {
    	render();
    }

}