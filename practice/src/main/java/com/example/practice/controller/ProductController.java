package com.example.practice.controller;

import java.util.*;

import org.springframework.web.bind.annotation.RestController;

import com.example.practice.model.Product;
import com.example.practice.service.ProductService;

import jakarta.validation.Valid;

import org.hibernate.validator.constraints.pl.PESEL;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
public class ProductController {
    private final ProductService service;

    ProductController(ProductService service) {
        this.service = service;
    }

    @PostMapping("/blinkit/add-pdt")
    public void addPdt(@Valid @RequestBody Product pdt) {
        service.createProduct(pdt.getPdtName(), pdt.getPrice(), pdt.getQuantity());
    }

    @GetMapping("/blinkit/get-pdt/{pdt_name}")
    public Product getPdt(String pdt_name) {
        Optional<Product> pdt = service.getByName(pdt_name);
        return pdt.orElse(null);

    }

}
