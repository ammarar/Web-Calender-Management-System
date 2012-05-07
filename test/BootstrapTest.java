import static org.junit.Assert.*;

import models.User;

import org.junit.Test;

import controllers.Bootstrap;


public class BootstrapTest {

	@Test
	public void testDoJob() {
		Bootstrap bs = new Bootstrap();
		bs.doJob();
		
		User test;
		
		test = User.find("byUsername", "test").first();
	    assertNotNull(test);
	    assertEquals("test", test.getUserName());
	    assertEquals("B", test.getLastName());
	    assertEquals("Test", test.getFirstName());
	    assertEquals("test@test.com", test.getEmail());
	    assertEquals("1", test.getPassword());
	    assertTrue(15 == test.getNotificationDays());
	    
	    
	    
	}

}
