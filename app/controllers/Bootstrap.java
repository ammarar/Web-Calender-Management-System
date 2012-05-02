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
		User yamin = new User("yamin", "Yamin", "W", "yamin@cmu.edu", "test123", 5).save();
		User niko  = new User("niko", "Niko", "A", "niko@cmu.edu", "test123", 6).save();
		User john  = new User("john", "John", "Z", "john@cmu.edu", "test123", 7).save();
		User admin = new User("admin", "Admin", "A", "admin@test.com", "123", 0).save();
		User test  = new User("test", "Test", "B", "test@test.com", "1", 15).save();
		
		new Event("Basem BD!", "1986-08-06", basem.getId(), ammar.getId(), "Surprise").save();
		new Event("Ammar Birthday", "1985-06-17", ammar.getId(), ammar.getId(), "Birthday").save();
		new Event("Yamin birthday", "1988-01-01", yamin.getId(), admin.getId(), "Surprise").save();
		new Event("Niko birthday", "1989-05-05", niko.getId(), admin.getId(), "Surprise").save();
		new Event("John birthday", "1984-07-28", john.getId(), admin.getId(), "Birthday").save();
		new Event("Test", "1960-12-31", test.getId(), admin.getId(), "Birthday").save();
	}
	
}
