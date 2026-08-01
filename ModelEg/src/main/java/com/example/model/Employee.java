package com.example.model;

import java.util.List;
import java.time.LocalDate;

public class Employee {
	
	private int id;
	private String name;
	private String email;
	private String gender;
	private String department;
	private double salary;
	private String joiningDate;
	private List<String> skills;
	private Address address;
	
	
	
	
	public Employee(int id, String name, String email, String gender, String department, double salary,
			String joiningDate, List<String> skills, Address address) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.gender = gender;
		this.department = department;
		this.salary = salary;
		this.joiningDate = joiningDate;
		this.skills = skills;
		this.address = address;
	}
	
	public Employee() {
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getJoiningDate() {
		return joiningDate;
	}
	public void setJoiningDate(String joiningDate) {
		this.joiningDate = joiningDate;
	}
	public List<String> getSkills() {
		return skills;
	}
	public void setSkills(List<String> skills) {
		this.skills = skills;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
	

}
