package com.example.practice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue
    private Long pdt_id;
    private String pdt_name;
    private double price;
    private Integer quantity;

    // if not value is not added to db
    public Product(String pdt_name, double price, Integer quantity) {
        this.pdt_name = pdt_name;
        this.price = price;
        this.quantity = quantity;
    }

}
