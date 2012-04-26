package models;

import play.*;
import play.db.jpa.*;

import javax.persistence.*;

import org.joda.time.LocalDate;

import java.util.*;

@Entity
public class BirthdayEvent extends Event {

	private String birthdayPerson;
	private boolean surprise;

	public BirthdayEvent(String name, String date) {
		super(name, date);
	}
    
	public BirthdayEvent(String name, String date, String birthdayPerson,
			boolean surprise) {
		super(name, date);
		this.birthdayPerson = birthdayPerson;
		this.surprise = surprise;
	}

	public String getBirthdayPerson() {
		return birthdayPerson;
	}
	
	public void setBirthdayPerson(String birthdayPerson) {
		this.birthdayPerson = birthdayPerson;
	}
	
	public boolean isSurprise() {
		return surprise;
	}

	public void setSurprise(boolean surprise) {
		this.surprise = surprise;
	}
}