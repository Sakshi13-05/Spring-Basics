package com.example.practice.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class EmailNotification implements Notification {
    @Override
    public void send(String message) {
        System.out.println("Notification send through Email " + message);
    }
}
