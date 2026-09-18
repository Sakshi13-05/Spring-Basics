package com.example.practice.service;

import org.springframework.stereotype.Service;

import com.example.practice.model.Product;
import com.example.practice.repository.ProductRepo;

import java.util.Optional;

import javax.management.RuntimeErrorException;

@Service
public class ProductService {
    private final ProductRepo repo;

    ProductService(ProductRepo repo) {
        this.repo = repo;
    }

    public void createProduct(String pdt_name, double price, Integer quantity) {
        repo.save(new Product(pdt_name, price, quantity));
    }

    public Optional<Product> getByName(String pdt_name) {
        return (repo.getByPdt_name(pdt_name));
    }

    public Optional<Product> getById(Long id) {
        return (repo.findById(id));
    }

    public void updatePrice(Long id, double new_price) {
        Optional<Product> opt_pdt = repo.findById(id);

        if (opt_pdt.isPresent()) {
            Product pdt = opt_pdt.get();
            pdt.setPrice(new_price);
            repo.save(pdt);
        } else {
            throw new RuntimeException("Product not found with ID " + id);
        }

    }
}
