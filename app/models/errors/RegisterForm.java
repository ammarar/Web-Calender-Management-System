package models.errors;

import java.util.ArrayList;

public class RegisterForm {
	private String userName;
	private String firstName; 
	private String lastName;
	private String email;
	public ArrayList<String> errors;
	   
	
	public RegisterForm() {
		userName = "";
		firstName = "";
		lastName = "";
		email = "";
		errors = new ArrayList<String>();
		for (int i=0; i<5; i++) {
			errors.add("");
		}
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
