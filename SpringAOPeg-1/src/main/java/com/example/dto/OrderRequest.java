package com.example.dto;

public class OrderRequest {

    private String customername;
    private double amount;

    public OrderRequest() {
    }

    public String getCustomername() {
        return customername;
    }

    public void setCustomername(String customername) {
        this.customername = customername;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}