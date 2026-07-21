package com.ems.model;

public final class ContractEmployee extends Employee {
	
private double contractAmount;

	public ContractEmployee(int empId, String empName, Department department, Address address, double contractAmount) {
	super(empId, empName, department, address);
	this.contractAmount = contractAmount;
}

	@Override
	public double calcSalary() {
		// TODO Auto-generated method stub
		return contractAmount;
	}

}
