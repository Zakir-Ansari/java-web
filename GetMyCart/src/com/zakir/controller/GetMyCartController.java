package com.zakir.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zakir.pojo.*;

@Controller
@RequestMapping("/")
public class GetMyCartController {
	LoginData loginData = new LoginData();
	UserDetails userDetails = new UserDetails();
	
	@RequestMapping(value="/about", method=RequestMethod.GET)
	public String getAboutPage(Model model) {
		model.addAttribute("this_page","home");
		return "about";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String getLoginPage(Model model) {
		model.addAttribute("this_page", "login");
		model.addAttribute("loginDetails",  loginData);
		return "login";
	}
	
	@RequestMapping(value="/sign-up", method=RequestMethod.GET)
	public String getSignUpPage(Model model) {
		model.addAttribute("this_page", "signup");
		model.addAttribute("signUpdDetails",  userDetails);
		return "sign-up";
	}
	
	
	@RequestMapping(value="/checkEligibility", method=RequestMethod.POST)
	public String getValidateUser(@ModelAttribute("loginDetails") LoginData loginData,Model model) {
		System.out.println(loginData.toString());
		return "user-home";
	}
	
}
