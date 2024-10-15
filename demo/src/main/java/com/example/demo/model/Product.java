package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    private double price;


    public Product() {
    }

    public Product(Long id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    // Getter cho name
    public String getName() {
        return name;
    }

    // Setter cho name
    public void setName(String name) {
        this.name = name;
    }

    // Getter cho price
    public double getPrice() {
        return price;
    }

    // Setter cho price
    public void setPrice(double price) {
        this.price = price;
    }

    // Getter cho id
    public Long getId() {
        return id;
    }

    // Setter cho id
    public void setId(Long id) {
        this.id = id;
    }
}




