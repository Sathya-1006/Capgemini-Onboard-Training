package com.example.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.entity.User;
import com.example.repository.UserRepository;
@Configuration
public class DataInitializer 
{
	
	@Bean
	public CommandLineRunner initUsers(UserRepository repository, PasswordEncoder encoder)
	{
		
		return args -> 
		{
			if(repository.findByUsername("rahul").isEmpty()) 
			{
				User user = new User("rahul", encoder.encode("rahul123"),"USER_READ", true);
				repository.save(user);
			}
			if(repository.findByUsername("admin").isEmpty()) {
				User admin = new User("admin", encoder.encode("admin123"), "ADMIN_DASHBOARD", true);
				repository.save(admin);
			}
		};
	}

}