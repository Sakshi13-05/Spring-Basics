package com.example.practice.interfaces;

public interface PaymentProcessor {
    boolean processPayment(String orderId, double amount);
}
