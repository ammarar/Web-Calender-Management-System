package models;

import play.*;
import play.db.jpa.*;

import javax.persistence.*;
import java.util.*;

@Entity
public class User extends Model {
	private String userName;
	private String firstName;
	private String lastName;
	private String password;
	private Integer notificationDays;

	public User(String userName, String firstName, String lastName,
			String password, Integer notificationDays) {
		super();
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.notificationDays = notificationDays;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getNotificationDays() {
		return notificationDays;
	}

	public void setNotificationDays(Integer notificationDays) {
		this.notificationDays = notificationDays;
	}

}
