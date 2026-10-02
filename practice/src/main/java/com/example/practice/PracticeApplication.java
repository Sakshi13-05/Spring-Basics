package com.example.practice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.practice.domain.OrderProcessingService;

@SpringBootApplication
public class PracticeApplication {

	public static void main(String[] args) {
		SpringApplication.run(PracticeApplication.class, args);
	}

	// Automatically runs after the Spring context is loaded
	@Bean
	public CommandLineRunner initializeInventory(OrderProcessingService orderService) {
		return args -> {
			System.out.println("Initializing inventory data...");
			orderService.fillStock();
			orderService.placeOrder("123", "Shampoo", 12000.0);
			System.out.println("Store is open for orders!");
		};
	}
}