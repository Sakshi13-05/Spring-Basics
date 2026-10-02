package com.example.practice.service;

import org.springframework.stereotype.Service;

@Service
public class AuditService {
    public void logTransaction(String orderId, String action, String status) {
        System.out.println("Action: " + action + " for orderId: " + orderId + " status is: " + status);
    }
}
