package com.example.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.LoginResponse;
import com.example.dto.RegisterRequest;
import com.example.entity.AppUser;
import com.example.repository.UserRepository;
import com.example.service.CustomUserDetailsService;
import com.example.service.JwtService;

@RestController
@RequestMapping("/auth")
public class AuthController {
		
	private final AuthenticationManager authenticationManager;
	private final CustomUserDetailsService userDetailsService;
	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;
	private final JwtService jwtService;
	
	public AuthController(AuthenticationManager authenticationManager, CustomUserDetailsService userDetailsService,
			UserRepository userRepository, PasswordEncoder passwordEncoder, JwtService jwtService) {
		this.authenticationManager = authenticationManager;
		this.userDetailsService = userDetailsService;
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
		this.jwtService = jwtService;
	}
	
	
	@PostMapping("/register")
	public ResponseEntity<String> register(@RequestBody RegisterRequest request){
		
		if(userRepository.findByUsername(request.getUsername())
				
				.isPresent()) {
			return ResponseEntity.badRequest().body("User already exists");
		}
		
		String encodedPassword = passwordEncoder.encode(request.getPassword());
		
		
		String role = request.getRole() == null || request.getRole().isBlank() ? "USER" : request.getRole().toUpperCase();
		
		AppUser user =  new AppUser(request.getUsername(),encodedPassword,role);
		
		userRepository.save(user);
		return ResponseEntity.ok("User Registeres Successfully");
	}
	
	
	@PostMapping("/login")
	public ResponseEntity<LoginResponse> login(@RequestBody RegisterRequest request){
		
		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(
						request.getUsername(),request.getPassword()
						)
				
				
				);
		
		UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUsername());
		
		String token = jwtService.generateToken(userDetails);
		
		return ResponseEntity.ok(new LoginResponse(token));
		
		
		
	}
	
}
