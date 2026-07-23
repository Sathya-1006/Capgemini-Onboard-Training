package com.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Customer {

    @Id
    private int custId;

    private String custName;

    private String mobile;

    @OneToMany(mappedBy = "customer",
            cascade = CascadeType.ALL)
    private List<Orders> orders = new ArrayList<>();

    // Default Constructor
    public Customer() {
    }

    // Parameterized Constructor
    public Customer(int custId, String custName, String mobile) {
        this.custId = custId;
        this.custName = custName;
        this.mobile = mobile;
    }

    // Getters & Setters

    public int getCustId() {
        return custId;
    }

    public void setCustId(int custId) {
        this.custId = custId;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public List<Orders> getOrders() {
        return orders;
    }

    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }

}