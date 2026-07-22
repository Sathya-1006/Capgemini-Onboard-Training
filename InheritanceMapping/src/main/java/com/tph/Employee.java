package com.tph;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name= "type")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	public Employee() {
		
	}
	
	
	public Employee(String name) {
		super();
		this.name = name;
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

}


@Entity
@DiscriminatorValue(value="reg")

class RegEmployee extends Employee{
	double salary;
	
	public RegEmployee() {
		
	}

	public RegEmployee(double salary, String name) {
		super(name);
		this.salary = salary;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	
	
}



@Entity
@DiscriminatorValue(value="con")
class ContractEmployee extends Employee{
	private float payercontract;
	private int contractPeriod;
	
	public ContractEmployee() {
		
	}
	
	public ContractEmployee(String name, float payercontract, int contractPeriod) {
		super(name);
		this.payercontract = payercontract;
		this.contractPeriod = contractPeriod;
	}

	public float getPayercontract() {
		return payercontract;
	}

	public void setPayercontract(float payercontract) {
		this.payercontract = payercontract;
	}

	public int getContractPeriod() {
		return contractPeriod;
	}

	public void setContractPeriod(int contractPeriod) {
		this.contractPeriod = contractPeriod;
	}
	
	
}
