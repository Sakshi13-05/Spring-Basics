package com.example.practice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.practice.model.Product;
import com.example.practice.repository.ProductRepo;

import lombok.Data;
import lombok.ToString;

@SpringBootApplication

public class PracticeApplication {

	public static void main(String[] args) {
		SpringApplication.run(PracticeApplication.class, args);
	}

	@Bean

	public CommandLineRunner demo(ProductRepo repo) {
		return (args) -> {
			repo.save(new Product("shampoo", 100.0, 15));
			repo.save(new Product("soap", 100.0, 156));
			System.out.println("The database content are:");
			System.out.println(repo.getPdtByName("shampoo").get());
			// for (Product pdt : repo.findAll()) {
			// System.out.println(pdt.getId() + " " + pdt.getName() + " -->" +
			// pdt.getPrice());
			// }
		};
	}

}
