package com.ems.model;

public final class FullTimeEmployee extends Employee {

	
	private double monthlySalary;
	
	
	
	
	public FullTimeEmployee(int empId, String empName, Department department, Address address, double monthlySalary) {
		super(empId,empName,department, address);
		this.monthlySalary = monthlySalary;
	}

	@Override
	public double calcSalary() {
		
		return monthlySalary;
	}

}
