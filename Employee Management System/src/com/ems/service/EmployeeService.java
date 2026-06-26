package com.ems.service;

import java.util.*;

import com.ems.model.Department;
import com.ems.model.Employee;

public class EmployeeService {
	
	private List<Employee> employees= new ArrayList<>();
	public void addEmployee(Employee employee) {
		employees.add(employee);
		
	}
	
	public void displayEmployees() {
		for(Employee emp :  employees) {
			emp.displayBasicInfo();
			System.out.println(emp.calcSalary());
			System.out.println("---------------------------------");
		}
	}
	
	public void updateName(int empId, String name) {
		for(Employee emp: employees) {
			if(emp.empId == empId) {
				emp.empName= name;
				
			}
		}
	}
	//Search operation
	public Employee searchEmployee(int empId) {

	    for(Employee emp : employees) {

	        if(emp.empId == empId) {
	            return emp;
	        }

	    }

	    return null;
	}
	//Remove operation
	
	public boolean removeEmployee(int empId) {

	    Iterator<Employee> itr = employees.iterator();

	    while(itr.hasNext()) {

	        Employee emp = itr.next();

	        if(emp.empId == empId) {
	            itr.remove();
	            return true;
	        }
	    }

	    return false;
	}
	
	//Highest paid employee
	public Employee highestPaidEmployee() {

	    Employee highest = employees.get(0);

	    for(Employee emp : employees) {

	        if(emp.calcSalary() > highest.calcSalary()) {
	            highest = emp;
	        }
	    }

	    return highest;
	}
	
	//department wise count
	public void departmentWiseCount() {

	    Map<Department,Integer> map = new HashMap<>();

	    for(Employee emp : employees) {

	        Department dept = emp.department;

	        map.put(dept,
	                map.getOrDefault(dept,0) + 1);
	    }

	    System.out.println(map);
	}
	
	public void totalSalaryExpense() {
		
		double total=0;
		for(Employee emp : employees) {
			total += emp.calcSalary();
			
		}
		System.out.println("Total Salary Expense: "+total);
	}
	

}
