package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.entity.Product;
import com.example.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {


    @Autowired
    ProductService service;

    @PostMapping
    public Product saveProduct(@RequestBody Product product){
        return service.saveProduct(product);
    }
    @GetMapping
    public List<Product> getAllProducts(){
        return service.getAllProducts();
    }
    @GetMapping("/{id}")
    public Product getProduct(@PathVariable Long id){
        return service.getProduct(id);
    }
    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id,
                                 @RequestBody Product product){

        product.setId(id);

        return service.updateProduct(product);
    }
    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable Long id){

        service.deleteProduct(id);

        return "Deleted Successfully";
    }
    @GetMapping("/price/{price}")
    public List<Product> getByPrice(@PathVariable double price){

        return service.getByPrice(price);
    }
    @GetMapping("/lowstock/{qty}")
    public List<Product> getLowStock(@PathVariable int qty){

        return service.getLowStock(qty);
    }

    @GetMapping("/brand/{brand}")
    public List<Product> getByBrand(@PathVariable String brand){

        return service.getByBrand(brand);
    }

    @GetMapping("/between/{min}/{max}")
    public List<Product> getBetweenPrice(@PathVariable double min,
                                         @PathVariable double max){

        return service.getBetweenPrice(min, max);
    }
}