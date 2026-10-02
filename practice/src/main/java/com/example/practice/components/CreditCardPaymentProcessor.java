package com.example.practice.components;

import org.springframework.stereotype.Component;

import com.example.practice.interfaces.PaymentProcessor;

@Component
public class CreditCardPaymentProcessor implements PaymentProcessor {
    public boolean processPayment(String orderId, double amount) {
        System.out.println("your card is charged for orderId " + orderId + " transcation amount " + amount);
        return (true);
    }

}
