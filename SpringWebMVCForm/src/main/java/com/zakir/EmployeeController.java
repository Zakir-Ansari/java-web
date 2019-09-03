package com.zakir;

import javax.servlet.ServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(path="/store")
public class EmployeeController {
	@RequestMapping(method=RequestMethod.POST)
	public String saveEmployee(Model model, Employee emp) {
		System.out.println("eno: "+emp.getEno()+" name: "+emp.getName()+" salary: "+emp.getSalary());
		model.addAttribute("emp",emp);
		return "display";
	}
}
