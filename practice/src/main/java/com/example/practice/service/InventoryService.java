package com.example.practice.service;

import org.springframework.stereotype.Service;
import java.util.*;;

@Service
public class InventoryService {
    public boolean isItemInStock(Map<String, Integer> inventory, String itemSku) {
        return inventory.getOrDefault(itemSku, 0) > 0;
    }
}
