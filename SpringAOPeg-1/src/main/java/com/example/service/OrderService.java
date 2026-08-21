package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.OrderRequest;
import com.example.entity.Order;
import com.example.exception.OrderNotFoundException;
import com.example.repository.OrderRepository;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    // CREATE ORDER
    public Order createOrder(OrderRequest request) {

        if (request.getAmount() <= 0) {
            throw new IllegalArgumentException(
                    "Order amount must be greater than zero");
        }

        Order order = new Order();

        order.setCustomerName(request.getCustomername());
        order.setAmount(request.getAmount());
        order.setStatus("CREATED");

        return repository.save(order);
    }

    // GET ORDER
    public Order getOrder(Integer oid) {

        return repository.findById(oid)
                .orElseThrow(() ->
                        new OrderNotFoundException(
                                "Order not found " + oid));
    }

    // CANCEL ORDER
    public Order cancelOrder(Integer oid) {

        Order order = getOrder(oid);

        order.setStatus("CANCELLED");

        return repository.save(order);
    }
}