import org.junit.*;

import controllers.Application;
import controllers.Register;
import play.test.*;
import play.mvc.*;
import play.mvc.Http.*;
import play.data.*;
import models.*;

public class ApplicationTest extends FunctionalTest {

    @Test
    public void testThatIndexPageWorks() {
        Response response = GET("/");
        assertStatus(302, response);
    }
    
    @Test
    public void testRegister() {
    	Response response = GET("/register");
    	assertIsOk(response);
    	assertContentType("text/html", response);
        assertCharset(play.Play.defaultWebEncoding, response);
    }
    
//    @Test
//    public void testRegisterForm() {
//    	Register.registerForm("wenj", "fn", "ln", "wenjunzhang.surpass@gmail.com",
//    			"123", "123", "Submit");
//    	
//    	User test = User.find("byUsername", "wenj").first();
//	    
//	    // Test 
//	    assertNotNull(test);
//	    assertEquals("fn", test.getFirstName());
//	    assertEquals("ln", test.getLastName());
//	    assertEquals("fn", test.getFirstName());
//	    assertEquals("wenjunzhang.surpass@gmail.com", test.getEmail());
//	    assertEquals("123", test.getPassword());
//	    
//    }
    
    @Test
    public void testForgetPassword() {
    	Response response = GET("/forgetPassword");
    	assertIsOk(response);
    	assertContentType("text/html", response);
        assertCharset(play.Play.defaultWebEncoding, response);
    }
    
    
    @Test
    public void testRequestPasswordForm() {
    	// test manually
    }
    
    @Test
    public void testNotification() {
    	Response response = GET("/notification");
    	assertStatus(302, response);
    }
    
}