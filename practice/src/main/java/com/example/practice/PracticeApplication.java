package com.example.practice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.practice.service.UserOnboardingService;

import lombok.Data;
import lombok.ToString;

@SpringBootApplication

public class PracticeApplication {

	public static void main(String[] args) {
		SpringApplication.run(PracticeApplication.class, args);
	}

	@Bean
	public CommandLineRunner funcationalRunner(UserOnboardingService service) {
		return args -> {
			service.registerUser();
		};
	}

}
