package com.example.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class HomeController {
	
	@GetMapping("/public/hello")
	public String hello() {
		return "Welcome to public pages";
	}
	
	@GetMapping("/public/info")
	public String info() {
		return "Public info page";
	}
	
	@GetMapping("/user/create")
	public String userHello(Authentication authentication) {
		return "User created "+ authentication.getName() + 
				"you are accessing USER endpoint...";
		
	}
	
	@GetMapping("/user/delete")
	public String userInfo(Authentication authentication) {
		return "User deleted by" + authentication.getName();
	}
	
	@GetMapping("/admin/dashboard")
	public String adminHello(Authentication authentication) {
		return "Hello Admin "+ authentication.getName() + 
				"you are accessing ADMIN endpoint...";
		
	}
	
	@GetMapping("/admin/info")
	public String adminInfo(Authentication authentication) {
		return "Admin info page" + authentication.getName();
	}
	
	

}