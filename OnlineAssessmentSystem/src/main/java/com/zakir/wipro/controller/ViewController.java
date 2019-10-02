package com.zakir.wipro.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.zakir.wipro.backendLogic.EvaluateMarks;
import com.zakir.wipro.backendLogic.Validate;
import com.zakir.wipro.bean.*;
import com.zakir.wipro.hibernateOperations.HibernateOperations;
import com.zakir.wipro.pojo.*;

@Controller
@RequestMapping("/")
@SessionAttributes("userSession")
public class ViewController {

	//Add userSession in model attribute
	@ModelAttribute("userSession")
	public MySession userSession() {
		return new MySession();
	}
	static HibernateOperations hibernateOperations = new HibernateOperations();
	static boolean initialUpdates = true;

	@RequestMapping(value = "/initialSetup")
	public String initialSetup() {
		hibernateOperations.dropTableInitially();
		hibernateOperations.initialDataUpdate();
		initialUpdates = false;

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

	@RequestMapping(value = "/login/do", method = RequestMethod.POST)
	public String home(@ModelAttribute("userDetails") User user, @ModelAttribute("userSession") MySession userSession, Model model, HttpSession httpSession) {
		//----------------------------------
		System.out.println("email: " + user.getEmail());
		System.out.println("password: " + user.getPassword());
		userSession.setMySession(user.getEmail());
		
		httpSession.setAttribute("authentication", "valid");
		
		Validate validate = new Validate();
		String validity = validate.validateUser(user.getEmail(), user.getPassword());
		if (validity.equalsIgnoreCase("admin")) {
			model.addAttribute("current_user", "admin");
			//model.addAttribute("mySession", mySession);
			
		}
		if (validity.equalsIgnoreCase("candidate")) {
			model.addAttribute("current_user", "candidate");
			//model.addAttribute("mySession", mySession);
		}
		if (validity.equalsIgnoreCase("invalid")) {
			model.addAttribute("current_user", "invalid");
		}
		if (validity.equalsIgnoreCase("invalid_password")) {
			model.addAttribute("current_user", "invalid_password");
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
