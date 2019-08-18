package com.hibernate.HibernateExample;

import javax.persistence.*;


//If no name is specified: table name will be class name by default
@Entity
@Table(name="alien_table")
public class Alien {		//POJO
	
	@Id		//making it primary key
	private int aid;
	
	//@Transient		//This will not be getting stored if annotated as transient 
	private AlienName aname;
	
	@Column(name="alien_color")
	private String color;
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	
	public AlienName getAname() {
		return aname;
	}
	public void setAname(AlienName aname) {
		this.aname = aname;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	@Override
	public String toString() {
		return "Alien [aid=" + aid + ", aname=" + aname + ", color=" + color + "]";
	}
	
	
	
}
