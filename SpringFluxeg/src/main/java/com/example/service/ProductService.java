package com.example.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.model.Product;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
public class ProductService {

    private List<Product> products = Arrays.asList(
            new Product(11, "Laptop", 50000),
            new Product(12, "Mouse", 3000),
            new Product(13, "Mobile", 35000));

    public Flux<Product> getproductById(){
        return Flux.fromIterable(products);
    }

    public Mono<Product> getProductById(int id){
        return Flux.fromIterable(products)
                .filter(p -> p.getId() == id)
                .next();
    }
}