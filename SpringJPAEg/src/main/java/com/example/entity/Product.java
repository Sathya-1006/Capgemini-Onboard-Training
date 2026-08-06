package com.example.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="productdata")
@Data
public class Product {

	@Id
    private Long id;
    private String name;
    private String brand;
    private double price;
    private int quantity;
    private LocalDate mfgDt;
}