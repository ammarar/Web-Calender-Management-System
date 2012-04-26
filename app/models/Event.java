package models;

import play.*;
import play.db.jpa.*;

import javax.persistence.*;

import org.joda.time.LocalDate;

import java.util.*;

@Entity
public class Event extends Model 
{
    private String name;
    private String date;
    
    public Event(String name, String date)
    {
    	super();
    	this.name = name;
    	this.date = date;
    }
    
    public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
}
