package com.ems.model;

public final class PartTimeEmployee extends Employee {
	private int hoursWorked;
	private double hourlyRate;
	
	public PartTimeEmployee(int empId, String empName, Department department, Address address, int hoursWorked, double hourlyRate) {
		super(empId, empName, department, address);
		this.hoursWorked = hoursWorked;
		this.hourlyRate = hourlyRate;
	}

	@Override
	public double calcSalary() {
		// TODO Auto-generated method stub
		return hoursWorked * hourlyRate;
	}

}
