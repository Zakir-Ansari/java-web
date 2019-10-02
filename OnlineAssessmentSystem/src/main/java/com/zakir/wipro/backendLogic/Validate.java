package com.zakir.wipro.backendLogic;

import com.zakir.wipro.hibernateOperations.HibernateOperations;
import com.zakir.wipro.pojo.UserDetails;

public class Validate {
	public String validateUser(String email, String password) {
		HibernateOperations hb = new HibernateOperations();
		UserDetails user = hb.getUserDetails(email);
		if(hb.getSessionForUserDetails(UserDetails.class) !=null) {
			hb.closeSession();
		}
		
		try {
			if (user.getEmail() !=null && user.getPassword() != null) {
				if (user.getUserType().equalsIgnoreCase("admin") && user.getPassword().equalsIgnoreCase(password)) {
					return "admin";
				}
				if (user.getUserType().equalsIgnoreCase("candidate") && user.getPassword().equalsIgnoreCase(password)) {
					return "candidate";
				} 
				if (user.getUserType().equalsIgnoreCase("admin") || user.getUserType().equalsIgnoreCase("candidate") && !user.getPassword().equalsIgnoreCase(password)) {
					return "invalid_password";
				}
				
				else {
					return "invalid";
				} 
			}
			else {
				return "invalid";
			}
		}
		catch(Exception ex) {
			System.out.println("Exception while login"+ex.getMessage());
			return "invalid";
		}
	}
}
