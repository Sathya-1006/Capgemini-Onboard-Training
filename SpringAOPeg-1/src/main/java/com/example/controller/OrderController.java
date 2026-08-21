package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.dto.OrderRequest;
import com.example.entity.Order;
import com.example.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService service;

    // CREATE
    @PostMapping
    public Order createOrder(@RequestBody OrderRequest request) {

        return service.createOrder(request);
    }

    // GET
    @GetMapping("/{oid}")
    public Order getOrder(@PathVariable Integer oid) {

        return service.getOrder(oid);
    }

    // CANCEL
    @PutMapping("/{oid}/cancel")
    public Order cancelOrder(@PathVariable Integer oid) {

        return service.cancelOrder(oid);
    }
}