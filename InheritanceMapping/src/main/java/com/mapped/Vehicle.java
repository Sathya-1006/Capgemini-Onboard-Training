package com.mapped;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;


@MappedSuperclass
public class Vehicle {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String brand;
	private double price;
	
	public Vehicle(String brand, double price) {
	    this.brand = brand;
	    this.price = price;
	}
	
	public Vehicle() {
		
	}
	
	public Vehicle(int id, String brand, double price) {
		
		this.brand = brand;
		this.price = price;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	

}

@Entity
class Car extends Vehicle{
	private int seats;
	
	public Car() {
		
	}

	public Car(int seats,String brand, double price) {
		super(brand, price);
		this.seats = seats;
	}

	public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}
	
	
	
}

@Entity
class Bike extends Vehicle{
	private int mileage;

	public Bike() {
		
		// TODO Auto-generated constructor stub
	}

	public Bike(int mileage,String brand, double price) {
		super(brand, price);
		this.mileage = mileage;
	}

	public int getMileage() {
		return mileage;
	}

	public void setMileage(int mileage) {
		this.mileage = mileage;
	}
	
	
	
}
