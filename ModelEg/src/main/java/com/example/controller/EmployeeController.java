package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.model.Employee;

@Controller
public class EmployeeController {
	
//	Model interface	
//	@GetMapping("/register")
//	public String showForm(Model model) {
//		model.addAttribute("employee", new Employee());
//		return "employeeview";
//	}
//	@PostMapping("/saveEmployee")
//	public String saveEmployee(@ModelAttribute("employee") Employee employee, Model model) {
//		model.addAttribute("emp", employee);
//		return "success";
//	}

	
	
	// -----using ModelMap-------- 
	
//	@GetMapping("/register")
//	public String showForm(ModelMap model) {
//	    model.put("employee", new Employee());
//	    return "employeeview";
//	}
//	
//	
//	@PostMapping("/saveEmployee")
//	public String saveEmployee(@ModelAttribute("employee") Employee employee,
//	                           ModelMap model) {
//
//	    model.addAttribute("emp", employee);
//	    return "success";
//	}
	
	
	//Using ModelandView
	@GetMapping("/register")
	public ModelAndView showForm() {
	    ModelAndView mv = new ModelAndView();
	    mv.addObject("employee", new Employee());
	    mv.setViewName("employeeview");
	    return mv;
	}
	
	@PostMapping("/saveEmployee")
	public ModelAndView saveEmployee(@ModelAttribute("employee") Employee employee) {
	    ModelAndView mv = new ModelAndView();
	    mv.addObject("emp", employee);
	    mv.setViewName("success");
	    return mv;
	}
	
	

}
