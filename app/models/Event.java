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
    private long createdFor;
	private long createdBy;
	private String type;
	
	public Event(String name, String date, long createdFor, long createdBy,
			String type) {
		super();
		this.name = name;
		this.date = date;
		this.createdFor = createdFor;
		this.createdBy = createdBy;
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public long getCreatedFor() {
		return createdFor;
	}

	public void setCreatedFor(long createdFor) {
		this.createdFor = createdFor;
	}

	public long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(long createdBy) {
		this.createdBy = createdBy;
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

	@Override
	public String toString() {
		return "Event [name=" + name + ", date=" + date + ", createdFor="
				+ createdFor + ", createdBy=" + createdBy + ", type=" + type
				+ "]";
	}
}
