package com.hibernate.HibernateExample;

import javax.persistence.Embeddable;

@Embeddable   //To embedd object into an existing table
public class AlienName {
	private String fname;
	private String lname;
	private String ename;
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	@Override
	public String toString() {
		return "AlienName [fname=" + fname + ", lname=" + lname + ", ename=" + ename + "]";
	}
	
}
