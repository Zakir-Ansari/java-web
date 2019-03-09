package org.zakir.webservices.RestFullAPIs.database;


import java.util.HashMap;
import java.util.Map;

import org.zakir.webservices.RestFullAPIs.model.*;

public class DatabaseClass {

	private static Map<Long,Message> messages = new HashMap<>();
	private static Map<String,Profile> profile = new HashMap<>();
	
	public static Map<Long,Message> getMessage() {
		return messages;
	}
	
	public static Map<String, Profile> getProfile() {
		return profile;
	}
}
