package com.zakir.wipro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.condition.RequestMethodsRequestCondition;

import com.zakir.wipro.backend.logic.CheckEligibility;
import com.zakir.wipro.bean.PAN;  


@Controller
@RequestMapping("/")
public class CreditCardEligibilityController {
	@RequestMapping(value="/home", method=RequestMethod.GET)
	public String home(Model model) {
		PAN pan = new PAN();
		model.addAttribute("panDetails", pan);
		return "home";
	}
	
	@RequestMapping(value="/checkEligibility", method=RequestMethod.POST)
	public String checkEligibility(@ModelAttribute("panDetails") PAN pan, Model model) {
		CheckEligibility check = new CheckEligibility();
		String eligibility = check.forPAN(pan.getPanNumber());
		
		model.addAttribute("Eligibility", eligibility);
		if(eligibility.equalsIgnoreCase("Eligible")) {
			model.addAttribute("message", "Congratulations!!! You are eligible for a credit card");
			model.addAttribute("backgroundColor", "orange");
		}
		if(eligibility.equalsIgnoreCase("Not Eligible")) {
			model.addAttribute("message", "Sorry!!! You are not eligible for a credit card");
			model.addAttribute("backgroundColor", "green");
		}
		if(eligibility.equalsIgnoreCase("Invalid")) {
			model.addAttribute("message", "Invalid PAN Entry !!!");
			model.addAttribute("backgroundColor", "red");
			model.addAttribute("link", "<a href=\"home\">Enter Again</a>");
		}
		
		
		return "eligibility-check";
	}
}
