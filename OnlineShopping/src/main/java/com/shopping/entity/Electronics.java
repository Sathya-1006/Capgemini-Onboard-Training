package com.shopping.entity;



import jakarta.persistence.Entity;

@Entity
public class Electronics extends Product {

	private int warrantyYears;

	public Electronics() {

	}

	public Electronics(String name, double price, int warrantyYears) {
		super(name, price);
		this.warrantyYears = warrantyYears;
	}

	public int getWarrantyYears() {
		return warrantyYears;
	}

	public void setWarrantyYears(int warrantyYears) {
		this.warrantyYears = warrantyYears;
	}

	@Override
	public String toString() {
		return super.toString() + " Electronics [warrantyYears=" + warrantyYears + "]";
	}

}
