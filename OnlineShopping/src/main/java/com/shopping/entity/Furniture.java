package com.shopping.entity;


import jakarta.persistence.Entity;

@Entity
public class Furniture extends Product {

	private String material;

	public Furniture() {

	}

	public Furniture(String name, double price, String material) {
		super(name, price);
		this.material = material;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	@Override
	public String toString() {
		return super.toString() + " Furniture [material=" + material + "]";
	}

}
