package com.example.practice.service;

import org.springframework.stereotype.Service;

@Service
public class SMSNotification implements Notification {
    @Override
    public void send(String message) {
        System.out.println("Notification send through SMS " + message);
    }
}
