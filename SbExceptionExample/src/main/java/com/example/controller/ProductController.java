package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Product;
import com.example.exception.ProductNotFoundException;
import com.example.repository.ProductRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	// Automatic dependency injection
    @Autowired
    private ProductRepository repository;

    @GetMapping
    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(() ->
            new ProductNotFoundException("Product not found with the ID - " + id));
    }

    @PostMapping
    public Product createProduct(@Valid @RequestBody Product product) {
        return repository.save(product);
    }
	
	@DeleteMapping("/{id}")
	public String deleteProduct(@PathVariable Long id) {
		if(!repository.existsById(id)) {
			throw new ProductNotFoundException("Cannot delete a product not found with the ID - "+id);
		}
		
		repository.deleteById(id);
		return "Product Deleted";
		
	}
	
	

}
