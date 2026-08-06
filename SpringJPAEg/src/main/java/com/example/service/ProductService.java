package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Product;
import com.example.repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    ProductRepository repository;

    public Product saveProduct(Product product) {
        return repository.save(product);
    }

    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    public Product getProduct(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Product updateProduct(Product product) {
        return repository.save(product);
    }

    public void deleteProduct(Long id) {
        repository.deleteById(id);
    }
    
    public List<Product> getByPrice(double price) {
        return repository.findByPrice(price);
    }

    public List<Product> getLowStock(int qty) {
        return repository.findByQuantityLessThan(qty);
    }

    public List<Product> getByBrand(String brand) {
        return repository.findByBrand(brand);
    }

    public List<Product> getBetweenPrice(double min,double max){
        return repository.findByPriceBetween(min, max);
    }

}