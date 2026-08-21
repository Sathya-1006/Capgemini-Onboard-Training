package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.entity.User;
import com.example.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository repository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user = repository.findByUsername(username)
				.orElseThrow(() -> 
				new UsernameNotFoundException("User name not found "+ username));
		//
		return org.springframework.security.core.userdetails
				.User.withUsername(user.getUsername())
				.password(user.getPassword())
				.authorities(user.getAuthority())
				.disabled(!user.isEnabled())
				.build();
	}

}
