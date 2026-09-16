package com.example.practice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.practice.model.Product;
import com.example.practice.repository.ProductRepo;

@SpringBootApplication
public class PracticeApplication {

	public static void main(String[] args) {
		SpringApplication.run(PracticeApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(ProductRepo repo) {
		return (args) -> {
			repo.save(new Product("shampoo", 100.0, 15));
			System.out.println("The database content are:");
			for (Product pdt : repo.findAll()) {
				System.out.println(pdt.getName() + " -->" + pdt.getPrice());
			}
		};
	}

}
