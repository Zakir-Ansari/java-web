package com.zakir.controller;

import java.util.Enumeration;

import javax.servlet.http.*;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.zakir.pojo.UserDetails;

@Controller
@RequestMapping("/")

public class ControllerClass {
	@RequestMapping(value="/login")
	public String getLogin(Model model,HttpServletRequest request) {
		//request.setAttribute("uesrSession", null);
		UserDetails userDetails = new UserDetails();
		model.addAttribute("userDetails", userDetails);
		return "login";
	}
	
	@RequestMapping(value = "/home", method = RequestMethod.POST )
	public String getHome(@ModelAttribute("userDetails") UserDetails userDetails, HttpServletRequest request,Model model) {
		System.out.println("user "+userDetails.getEmail());
		HttpSession session = request.getSession(true);
		session.setAttribute("uesrSession", userDetails.getEmail());
		Enumeration<String> username=(Enumeration<String>) session.getAttributeNames();
		//request.setAttribute("uesrSession", userDetails.getEmail());
		System.out.println(username.nextElement());
		HttpSession session1 = request.getSession();
		System.out.println("Session at Home page: "+session1.getAttribute("uesrSession"));
		model.addAttribute("User",userDetails);
	
		return "home";
	}
	
	@RequestMapping(value = "/details", method = RequestMethod.GET )
	public String getUserDetails(@ModelAttribute("User") UserDetails userDetails, HttpServletRequest request,Model model) {
		HttpSession session = request.getSession();
		System.out.println("Session at About page: "+session.getAttribute("userSession"));
		model.addAttribute(userDetails);
		
		return "home";
	}
	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String terminateSession(HttpServletRequest request,Model model) {
		HttpSession session = request.getSession();
		session.removeAttribute("userSession");
		System.out.println("Session after logout: "+session.getAttribute("userSession"));
		session.invalidate();
		
		model.addAttribute("logout","Success");
		return "redirect:/login";
	}
}
