package com.example.practice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.example.practice.service.EmailMessageSender;
import com.example.practice.service.MessageSender;
import com.example.practice.service.OrderNotificationService;

@SpringBootApplication
public class PracticeApplication {

	public static void main(String[] args) {
		SpringApplication.run(PracticeApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(OrderNotificationService notificationService) {
		return args -> {
			notificationService.notifyCustomer("ORD-1001", "user@example.com");
		};
	}
}
