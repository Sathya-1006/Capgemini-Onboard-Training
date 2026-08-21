package com.example.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Product;
import com.example.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
    
	private final ProductService service;

	ProductController(ProductService service) {
		this.service = service;
	}
	
	@PostMapping
	public Product addProduct(@RequestBody Product product) {
		return service.addProduct(product);
	}
	
	@GetMapping("/{id}")
	public Product getProduct(@PathVariable int id) {
		return service.getProduct(id);
	}
	
	@GetMapping
	public List<Product> getAllProducts() {
		return service.getProducts();
	}
}
