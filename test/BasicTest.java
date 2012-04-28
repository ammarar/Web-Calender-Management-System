import org.junit.*;
import java.util.*;
import play.test.*;
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

}
