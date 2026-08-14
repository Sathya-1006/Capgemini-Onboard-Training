package com.example.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

	@GetMapping("/profile")
	public String profile(Authentication authentication) {
		return "Welcome "+ authentication.getName() + "user! this is your profile";
	}
	
	@GetMapping("/home")
	public String home() {
		return "Welcome to User home";
	}
}