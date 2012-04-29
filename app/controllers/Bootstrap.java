package controllers;

import models.Event;
import models.User;
import play.jobs.Job;
import play.jobs.OnApplicationStart;

@OnApplicationStart
public class Bootstrap extends Job {

	@Override
	public void doJob()
	{
		User basem = new User("basem", "Basem", "J", "basem@cmu.edu", "test123", 5).save();
		User ammar = new User("ammar", "Ammar", "R", "ammar@cmu.edu", "test123", 5).save();
		new Event("Basem BD!", "1986-08-06", basem.getId(), ammar.getId(), "Surprise").save();
		new Event("Ammar Birthday", "1985-06-17", ammar.getId(), ammar.getId(), "Birthday").save();
	}
	
}
