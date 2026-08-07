package com.example.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@NotBlank(message = "Product name cannot left blank")
	private String name;
	
	@Min(value = 1,message = "Price must be greater than 0")
	private double price;

	public Product(@NotBlank(message = "Product name cannot left blank") String name,
			@Min(value = 1, message = "Price must be greater than 0") double price) {
		super();
		
		this.name = name;
		this.price = price;
	}

	
	
	public Product() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	

}
