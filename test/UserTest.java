import models.User;
import org.junit.*;

import java.util.*;
import play.test.*;

public class UserTest extends UnitTest {
	@Test
	public void createAndRetrieveUser() {
	    // Create a new user and save it
	    new User("TestingUser", "Bob", "Bob123","test@test.com", "pass123",10).save();
	    
	    // Retrieve the user with e-mail address bob@gmail.com
	    User test = User.find("byUserName", "TestingUser").first();
	    
	    // Test 
	    assertNotNull(test);
	    assertEquals("TestingUser", test.getUserName());
	}
}
