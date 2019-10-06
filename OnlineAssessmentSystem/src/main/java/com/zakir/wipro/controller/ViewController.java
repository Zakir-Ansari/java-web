package com.zakir.wipro.controller;


import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.zakir.wipro.backendLogic.EvaluateMarks;
import com.zakir.wipro.backendLogic.Validate;
import com.zakir.wipro.bean.*;
import com.zakir.wipro.hibernateOperations.HibernateOperations;
import com.zakir.wipro.pojo.*;

@Controller
@RequestMapping("/")
//@SessionAttributes("userSession")
public class ViewController {
	
	private String validity = null;
	private String userSession = null;
	private String userExist = null;
		
	static HibernateOperations hibernateOperations = new HibernateOperations();
	static boolean initialUpdates = true;

	@RequestMapping(value = "/initialSetup")
	public String initialSetup() {
		hibernateOperations.dropTableInitially();
		hibernateOperations.dropAssessmentTableInitially();
		hibernateOperations.initialDataUpdate();
		
		initialUpdates = false;

		return "redirect:/terminateSession";
	}
	

	
	@RequestMapping(value = "/registration/login")
	public String redirectToLogin() {
		return "redirect:/login";
	}


	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model) {
		if(initialUpdates) {
			hibernateOperations.dropTableInitially();
			hibernateOperations.dropAssessmentTableInitially();
			hibernateOperations.initialDataUpdate();
			initialUpdates = false;
		}
		User user = new User();
		model.addAttribute("userDetails", user);
		return "login"; 
	}

	@RequestMapping(value = "/validate", method = RequestMethod.POST)
	public String validate(@ModelAttribute("userDetails") User user, Model model) {
		System.out.println("email: " + user.getEmail());
		System.out.println("password: " + user.getPassword());
		Validate validate = new Validate();
		validity = validate.validateUser(user.getEmail(), user.getPassword());
		if (!validity.isEmpty() && validity != null) {
			userSession = user.getEmail();
			System.out.println("Got Session: "+userSession);
		}
		
		
		return "redirect:/login/do";
	}
	
	@RequestMapping(value = "/login/do", method = RequestMethod.GET)
	public String getHome(Model model) {
		System.out.println("Validity got: "+validity);
		if(validity == null || validity.isEmpty() || userSession == null) {
			return "redirect:/login";
		}
		if (validity != null) {
			if (validity.equalsIgnoreCase("admin")) {
				model.addAttribute("current_user", "admin");
				model.addAttribute("title","Select Reports");
			}
			if (validity.equalsIgnoreCase("candidate")) {
				model.addAttribute("current_user", "candidate");
				model.addAttribute("title","Select Tests");
			}
			if (validity.equalsIgnoreCase("invalid")) {
				model.addAttribute("current_user", "invalid");
				model.addAttribute("title","Invalid User Page");
			}
			if (validity.equalsIgnoreCase("invalid_password")) {
				model.addAttribute("current_user", "invalid_password");
				model.addAttribute("title","Password Error Page");
			} 
		}
		return "user-home";
	}
	
	@RequestMapping(value = "/users/all", method = RequestMethod.GET)
	public String viewListOfAllCandidates(Model model) {
		if(userSession == null) {
			return "redirect:/login";
		}
		
		List<UserDetails> candidatesList = hibernateOperations.getCandidateList();
		model.addAttribute("candidatesList", candidatesList);
		return "candidates-list";
	}
	
	@RequestMapping(value = "/tests/all", method = RequestMethod.GET)
	public String veiewTestDetails(Model model) {
		if(userSession == null) {
			return "redirect:/login";
		}
		
		List<TestResults> results = hibernateOperations.getTestResultList();
		model.addAttribute("results", results);		
		return "test-details-list";
	}
	
	
	@RequestMapping(value="/register", method = RequestMethod.GET)
	public String getRegistrationPage(Model model) {
		if (userExist !=null) {
			model.addAttribute("userAlreadyExists","yes");
		}
		userExist = null;
		RegistrationDetails registrationDetails = new RegistrationDetails();
		model.addAttribute("registrationDetails", registrationDetails);
		return "register";
	}
	
	//registration/do
	@RequestMapping(value="/registration/do", method = RequestMethod.POST)
	public String registrationSuccessfullPage(@ModelAttribute("registrationDetails") RegistrationDetails registrationDetails, Model model) {
		System.out.println("Registration deatails" + registrationDetails.toString());
		UserDetails userExist = hibernateOperations.getUserDetails(registrationDetails.getEmail());
		if(userExist != null) {
			this.userExist = "yes";
			return "redirect:/register";
		}
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
	public String getSpringAssessmentPage(Model model) {
		
		if(userSession == null || userSession.isEmpty()) {
			return "redirect:/login";
		}
		
		SpringAssessment springAssessment = new SpringAssessment();
		SelectedOptions selectedOption = new SelectedOptions();
		model.addAttribute("selectedOption", selectedOption);
		model.addAttribute(springAssessment);
		return "springAssessment";
	}
	
	@RequestMapping(value="/hibernateAssessment", method = RequestMethod.GET)
	public String getHibernateAssessmentPage(Model model) {
		if(userSession == null || userSession.isEmpty()) {
			return "redirect:/login";
		}
		HibernateAssessment hibernateAssessment = new HibernateAssessment();
		SelectedOptions selectedOption = new SelectedOptions();
		model.addAttribute("selectedOption", selectedOption);
		model.addAttribute(hibernateAssessment);
		return "hibernateAssessment";
	}
	
	@RequestMapping(value="/evaluate/spring/test", method = RequestMethod.POST)
	public String getAssessmentResultForSpring(@ModelAttribute("selectedOption") SelectedOptions selectedOption, Model model) {
		if(userSession == null || userSession.isEmpty()) {
			return "redirect:/login";
		}
		
		System.out.println(selectedOption.toString());
		System.out.println(userSession.toString());
		EvaluateMarks evaluate = new EvaluateMarks();
		String result = evaluate.getEvaluations(selectedOption, userSession, "Spring");
		if(result.equalsIgnoreCase("Passed")) {
			model.addAttribute("resultMessage","Congratulations!!! You have passed!!!");
			model.addAttribute("title","Success Page");
			System.out.println("Passed-if");
		}
		else {
			model.addAttribute("resultMessage","Sorry!!! Better Luck Next Time!!!");
			model.addAttribute("title","Failure Page");
			System.out.println("Failed-if");
		}
		return "assessment-result";
	}
	
	@RequestMapping(value="/evaluate/hibernate/test", method = RequestMethod.POST)
	public String getAssessmentResultForHibernate(@ModelAttribute("selectedOption") SelectedOptions selectedOption,Model model) {
		if(userSession == null || userSession.isEmpty()) {
			return "redirect:/login";
		}
		
		System.out.println(selectedOption.toString());
		System.out.println(userSession.toString());
		EvaluateMarks evaluate = new EvaluateMarks();
		String result = evaluate.getEvaluations(selectedOption, userSession, "Hibernate");
		if(result.equalsIgnoreCase("Passed")) {
			model.addAttribute("resultMessage","Congratulations!!! You have passed!!!");
			model.addAttribute("title","Success Page");
			System.out.println("Passed-if");
		}
		else {
			model.addAttribute("resultMessage","Sorry!!! Better Luck Next Time!!!");
			model.addAttribute("title","Failure Page");
			System.out.println("Failed-if");
		}
		return "assessment-result";
	}
	
	@RequestMapping(value = "/terminateSession", method = RequestMethod.GET)
	public String terminateSession( Model model) {
	    userSession = null;
	    validity = null;
	    model.addAttribute("userSession",userSession);
	    
	    return "redirect:/login";
	}
	
}
