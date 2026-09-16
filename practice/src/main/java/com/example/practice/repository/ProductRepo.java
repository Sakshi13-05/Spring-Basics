package com.example.practice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.practice.model.Product;

public interface ProductRepo extends JpaRepository<Product, Long> {
    Optional<Product> getPdtByName(String name);
}
