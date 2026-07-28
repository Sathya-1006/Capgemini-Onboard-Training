package org.examples;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
//@Scope("prototype")
public class Car {

	@Autowired
	@Qualifier("petrol") // Field based dependency injection -> here we give custom names - like giving class a name
	private Engine engine;
	
	//constructor
//	@Autowired
//	public Car(@Qualifier("petrolEngine")  Engine engine) {
//		this.engine = engine;
//		
//	}
	
	
	//setter method --> setter based dependency injection
//	@Autowired
//	@Qualifier("dieselEngine")
//	public void setEngine(Engine engine) {
//		this.engine = engine;
//	}
	
	
	
	
	
	public void drive() {
		engine.start();
		System.out.println("Car is running...");
	}

	public Car() {
		
		System.out.println("One instance initialized...");
		
	}
	
	@PostConstruct
	public void init() {
		System.out.println("Post Construct..");
	}
	
	@PreDestroy
	public void destroy() {
		System.out.println("Pre destroy");
	}
}
