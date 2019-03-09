package org.zakir.webservices.RestFullAPIs.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.zakir.webservices.RestFullAPIs.database.DatabaseClass;
import org.zakir.webservices.RestFullAPIs.model.Profile;

public class ProfileService {
	private Map<String, Profile> profiles = DatabaseClass.getProfile();
	
	public ProfileService() {
		profiles.put("Zakir", new Profile(1L,"zakir","Zakir","Ansari"));
	}
	
	public List<Profile> getAllProfiles() {
		return new ArrayList<Profile>(profiles.values());
	}
	
	public Profile getProfile(String profileName) {
		return profiles.get(profileName);
	}
	
	public Profile addProfile(Profile profile) {
		profile.setId(profiles.size() + 1);
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public Profile updateProfile(Profile profile) {
		if(profile.getProfileName().isEmpty())
			return null;
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public Profile removeProfile(String profileName) {
		return profiles.remove(profileName);
	}
	
	
	
}
