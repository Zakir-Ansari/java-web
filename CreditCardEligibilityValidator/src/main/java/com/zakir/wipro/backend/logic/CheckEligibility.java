package com.zakir.wipro.backend.logic;

import java.util.HashMap;

public class CheckEligibility {
	HashMap<String,Double> creditScore = new HashMap<String,Double>();
	public String forPAN(String PAN) {
		String eligibility = "";
		creditScore.put("AXSSP1122H", 3.10);
		creditScore.put("APPSA3355P", 8.50);
		creditScore.put("APPXA2244X", 9.50);
		creditScore.put("AXVPS7766V", 1.50);
		creditScore.put("ASXPS2121S", 5.10);
		
		try {
			if(creditScore.get(PAN.toUpperCase()) >= 5) {
				eligibility = "Eligible";
			}
			if(creditScore.get(PAN.toUpperCase()) < 5) {
				eligibility = "Not Eligible";
			}
		} catch (Exception e) {
			eligibility = "Invalid";
		}
		
		return eligibility;
	}
}
