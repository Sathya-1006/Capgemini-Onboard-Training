package com.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Orders {

    @Id
    private int ordId;

    private LocalDate ordDate;

    private double totalAmount;

    @ManyToOne
    @JoinColumn(name = "cust_id")
    private Customer customer;

    // Default Constructor
    public Orders() {
    }

    // Parameterized Constructor
    public Orders(int ordId, LocalDate ordDate, double totalAmount) {
        this.ordId = ordId;
        this.ordDate = ordDate;
        this.totalAmount = totalAmount;
    }

    // Getters & Setters

    public int getOrdId() {
        return ordId;
    }

    public void setOrdId(int ordId) {
        this.ordId = ordId;
    }

    public LocalDate getOrdDate() {
        return ordDate;
    }

    public void setOrdDate(LocalDate ordDate) {
        this.ordDate = ordDate;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

}