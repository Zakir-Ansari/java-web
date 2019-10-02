package com.zakir.wipro.controller;


import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.WebRequest;

import com.zakir.wipro.backendLogic.EvaluateMarks;
import com.zakir.wipro.backendLogic.Validate;
import com.zakir.wipro.bean.*;
import com.zakir.wipro.hibernateOperations.HibernateOperations;
import com.zakir.wipro.pojo.*;

@Controller
@RequestMapping("/")
@SessionAttributes("userSession")
public class ViewController {
	
	private String validity = null;
		
	static HibernateOperations hibernateOperations = new HibernateOperations();
	static boolean initialUpdates = true;

	@RequestMapping(value = "/initialSetup")
	public String initialSetup() {
		hibernateOperations.dropTableInitially();
		hibernateOperations.initialDataUpdate();
		initialUpdates = false;

		return "redirect:/terminateSession";
	}
	

	@RequestMapping(value = "/terminateSession", method = RequestMethod.GET)
	public String page4( HttpSession session, SessionStatus status) {
	    /**
	     * store User ...
	     */
	    status.setComplete();
	    session.removeAttribute("userSession");
	    return "redirect:/login";
	}
	
	@RequestMapping(value = "/registration/login")
	public String redirectToLogin() {
		return "redirect:/login";
	}


	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model) {
		if(initialUpdates) {
			hibernateOperations.dropTableInitially();
			hibernateOperations.initialDataUpdate();
			initialUpdates = false;
		}
		User user = new User();
		MySession userSession = new MySession();
		model.addAttribute("userDetails", user);
		model.addAttribute("userSession", userSession);
		return "login"; 
	}

	@RequestMapping(value = "/validate", method = RequestMethod.POST)
	public String validate(@ModelAttribute("userDetails") User user, Model model) {
		System.out.println("email: " + user.getEmail());
		System.out.println("password: " + user.getPassword());
		Validate validate = new Validate();
		validity = validate.validateUser(user.getEmail(), user.getPassword());
		
		return "redirect:/login/do";
	}
	
	@RequestMapping(value = "/login/do", method = RequestMethod.GET)
	public String getHome(Model model) {
		
		System.out.println("Validity got: "+validity);
		if (validity.equalsIgnoreCase("admin")) {
			model.addAttribute("current_user", "admin");
			model.addAttribute("userSession", "admin");
		}
		if (validity.equalsIgnoreCase("candidate")) {
			model.addAttribute("current_user", "candidate");
			model.addAttribute("userSession", "admin");
		}
		if (validity.equalsIgnoreCase("invalid")) {
			model.addAttribute("current_user", "invalid");
			model.addAttribute("userSession", "invalid");
		}
		if (validity.equalsIgnoreCase("invalid_password")) {
			model.addAttribute("current_user", "invalid_password");
			model.addAttribute("userSession", "invalid_password");
		}
		return "user-home";
	}
	
	@RequestMapping(value="/register", method = RequestMethod.GET)
	public String getRegistrationPage(Model model) {
		RegistrationDetails registrationDetails = new RegistrationDetails();
		model.addAttribute("registrationDetails", registrationDetails);
		return "register";
	}
	
	//registration/do
	@RequestMapping(value="/registration/do", method = RequestMethod.POST)
	public String registrationSuccessfullPage(@ModelAttribute("registrationDetails") RegistrationDetails registrationDetails, Model model) {
		System.out.println("Registration deatails" + registrationDetails.toString());
		String response = hibernateOperations.addCandidate(
								registrationDetails.getFirstName(), 
								registrationDetails.getLastName(), 
								registrationDetails.getEmail(), 
								registrationDetails.getPassword(), 
								"candidate");
		model.addAttribute("userName", registrationDetails.getFirstName()+" "+registrationDetails.getLastName());
		model.addAttribute("registrationStatus", response);
		return "registration-confirm";
	}
	
	@RequestMapping(value="/springAssessment", method = RequestMethod.GET)
	public String getSpringAssessmentPage(@SessionAttribute("userSession") MySession userSession ,Model model) {
		System.out.println(userSession.toString());
		
		if(userSession.getMySession() == null) {
			return "redirect:/login";
		}
		
		SpringAssessment springAssessment = new SpringAssessment();
		SelectedOptions selectedOption = new SelectedOptions();
		model.addAttribute("selectedOption", selectedOption);
		model.addAttribute(springAssessment);
		model.addAttribute("mySession", userSession);
		return "springAssessment";
	}
	
	@RequestMapping(value="/hibernateAssessment", method = RequestMethod.GET)
	public String getHibernateAssessmentPage(Model model) {
		HibernateAssessment hibernateAssessment = new HibernateAssessment();
		SelectedOptions selectedOption = new SelectedOptions();
		model.addAttribute("selectedOption", selectedOption);
		model.addAttribute(hibernateAssessment);
		return "hibernateAssessment";
	}
	
	@RequestMapping(value="/evaluate/spring/test", method = RequestMethod.POST)
	public String getAssessmentResultForSpring(@ModelAttribute("selectedOption") SelectedOptions selectedOption, @ModelAttribute("userSession") MySession userSession, Model model) {
		System.out.println(selectedOption.toString());
		System.out.println(userSession.toString());
		EvaluateMarks evaluate = new EvaluateMarks();
		evaluate.getEvaluations(selectedOption, userSession.getMySession(), "Spring");
		//model.addAttribute("mySession",mySession);
		
		
		return "assessment-result";
	}
	
	@RequestMapping(value="/evaluate/hibernate/test", method = RequestMethod.POST)
	public String getAssessmentResultForHibernate(@ModelAttribute("selectedOption") SelectedOptions selectedOption,Model model) {
		System.out.println("Selected options: \n"+selectedOption.getForQuestion1()+" "+selectedOption.getForQuestion2());
		return "assessment-result";
	}
	
}
