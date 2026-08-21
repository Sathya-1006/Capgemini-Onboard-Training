package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.model.Product;


@Service
public class ProductService {

	public Product addProduct(Product product) {
		System.out.println("Business Logic:  Adding Prodcut");
		return product;
	}
	
	public Product getProduct(int id) {
		if(id<=0)
			throw new IllegalArgumentException("Invalid product id");
		return new Product(id,"Laptop",55000);
	}
	
	public List<Product> getProducts(){
		System.out.println("Bussiness Logic: Getting All Products");
		List<Product> products=new ArrayList<>();
		products.add(new Product(101,"Keyboard",1000));
		products.add(new Product(102,"Mouse",750));
		products.add(new Product(103,"Mobile",15000));
		
		return products;
	}
}
