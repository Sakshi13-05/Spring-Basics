package com.example.practice.domain;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Service;

import com.example.practice.interfaces.PaymentProcessor;
import com.example.practice.service.AuditService;
import com.example.practice.service.InventoryService;

@Service
public class OrderProcessingService {
    private final InventoryService inventoryService;
    private final PaymentProcessor paymentProcessor;
    private final AuditService auditService;

    // Use ConcurrentHashMap for thread safety in a Singleton bean
    private final Map<String, Integer> inventory = new ConcurrentHashMap<>();

    public OrderProcessingService(InventoryService inventoryService,
            PaymentProcessor paymentProcessor,
            AuditService auditService) {
        this.inventoryService = inventoryService;
        this.paymentProcessor = paymentProcessor;
        this.auditService = auditService;
    }

    public void fillStock() {
        inventory.put("Shampoo", 10);
        inventory.put("Soap", 19);
        inventory.put("Butter", 21);
        inventory.put("Shaver", 51);
    }

    public boolean placeOrder(String orderId, String itemSku, double amount) {
        // 1. Check stock first before taking any action
        if (!inventoryService.isItemInStock(inventory, itemSku)) {
            auditService.logTransaction(orderId, "FAILED", "OUT_OF_STOCK");
            return false;
        }

        // 2. Process payment only if in stock
        boolean paymentSuccess = paymentProcessor.processPayment(orderId, amount);
        if (!paymentSuccess) {
            auditService.logTransaction(orderId, "FAILED", "PAYMENT_FAILED");
            return false;
        }

        // 3. Safely decrement inventory after payment succeeds
        inventory.computeIfPresent(itemSku, (key, currentStock) -> currentStock - 1);

        // 4. Log successful transaction
        auditService.logTransaction(orderId, "SUCCESS", itemSku);
        return true;
    }
}