package com.example.practice.service;

import org.springframework.stereotype.Service;

import com.example.practice.service.MessageSender;

@Service
public class OrderNotificationService {
    private final MessageSender sender;

    public OrderNotificationService(MessageSender sender) {
        this.sender = sender;
    }

    public void notifyCustomer(String orderId, String customerContact) {
        sender.send(customerContact, "Your order " + orderId + " is confirmed!");
    }
}
