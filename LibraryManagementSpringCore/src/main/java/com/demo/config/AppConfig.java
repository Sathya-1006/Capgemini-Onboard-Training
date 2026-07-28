package com.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.demo.util.LibraryInfo;

@Configuration
@ComponentScan(basePackages = "com.demo")
@PropertySource("classpath:application.properties")
public class AppConfig {

    @Bean
    public LibraryInfo libraryInfo() {
        return new LibraryInfo();
    }

}