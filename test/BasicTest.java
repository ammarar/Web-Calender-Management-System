import org.joda.time.DateTime;
import org.joda.time.Days;
import org.junit.*;
import java.util.*;
import play.test.*;
import util.CalendarHelper;
import models.*;

public class BasicTest extends UnitTest {

    @Test
    public void userModelTest() {
        //Cerate a User 
    	User ammar = new User("ammar", "Ammar", "Alrasihd", "admin@webcal.com", "123", 3).save();
    	
    	
    	// Pull ammar user put and check if its there 
    	List<User> x ; 
    	x = User.findAll();
    	
    	assertEquals(ammar, x.get(0));
    }
    
    @Test
    public void notificationDateCalculationTest()
    {
    	// First create two events. 
    	Event ev1 = new Event("Ev1", "2012-05-16", 1, 1, "Surprise");
    	Event ev2 = new Event("Ev2", "2012-05-17", 1, 1, "Surprise");
    	
    	Days d = Days.daysBetween(DateTime.parse(ev1.getDate()), DateTime.parse(ev2.getDate()));
		int days = d.getDays();
		
		assertEquals("1", days);
    	 
    }

}
