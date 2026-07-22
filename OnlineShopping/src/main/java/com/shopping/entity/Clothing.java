package com.shopping.entity;


import jakarta.persistence.Entity;

@Entity
public class Clothing extends Product {

	private String size;

	public Clothing() {

	}

	public Clothing(String name, double price, String size) {
		super(name, price);
		this.size = size;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	@Override
	public String toString() {
		return super.toString() + " Clothing [size=" + size + "]";
	}

}