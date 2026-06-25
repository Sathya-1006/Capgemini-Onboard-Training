package com.ems.model;

public sealed abstract class Employee permits FullTimeEmployee, PartTimeEmployee, ContractEmployee {
	
	public int empId;
	public String empName;
	public Department department;
	protected Address address;
	
	public Department getDepartment() {
	    return department;
	}
	
	public Employee() {
		
	}
	public Employee(int empId, String empName,Department department,Address address) {
			
			this.empId = empId;
			this.empName = empName;
			this.department = department;
			this.address = address;
	}
	 
	 public abstract double calcSalary();
	 
	public void displayBasicInfo() {
			 System.out.println("Emp Id: "+empId );
			 System.out.println("Emp Name: "+empName);
			 System.out.println("Department: "+department);
			 System.out.println("Address: "+address );
		 }
	 
}

