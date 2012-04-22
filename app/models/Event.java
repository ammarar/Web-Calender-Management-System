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
    private LocalDate date;
    
    public Event(String name, LocalDate date)
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
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	
}
