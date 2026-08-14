package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

	@GetMapping("/profile")
	public String profile() {
		return "Welcome User! this is your profile";
	}
	
	@GetMapping("/dashboard")
	public  String dashboard() {
		return "Hey user! Welcome to your dashboard ";
	}
	
	@GetMapping("/users")
	public String users() {
		return "Admin can access all users";
	}
	
}
