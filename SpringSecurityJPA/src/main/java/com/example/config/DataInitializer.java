package com.example.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.entity.User;
import com.example.repository.UserRepository;

@Configuration
public class DataInitializer {

    @Bean
    public CommandLineRunner initUsers(
            UserRepository repository,
            PasswordEncoder encoder) {

        return args -> {

            // USER
            if (repository.findByUsername("rahul").isEmpty()) {

                User user = new User(
                        "rahul",
                        encoder.encode("rahul123"),
                        "USER",
                        true
                );

                repository.save(user);
            }


            // ADMIN
            if (repository.findByUsername("admin").isEmpty()) {

                User admin = new User(
                        "admin",
                        encoder.encode("admin123"),
                        "ADMIN",
                        true
                );

                repository.save(admin);
            }
        };
    }
}