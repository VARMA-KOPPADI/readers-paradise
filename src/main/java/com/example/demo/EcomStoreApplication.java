package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
@OpenAPIDefinition(
		info=@Info(
				title = "EComers Readers paradice",
				version = "1.0",
				description = "Readers Paradise Store API provides a comprehensive platform for managing an online book store."
						+ " It allows users to browse and search books by categories, authors, and titles, manage user accounts,"
						+ " handle shopping cart operations, and process orders. The API also supports administrative features such as adding new books,"
						+ "updating inventory, and tracking sales. Designed for scalability and ease of integration,"
						+ " this service enables a seamless experience for both readers and store administrators.",
				contact = @Contact(name = "Varma Koppadi", email = "koppadivarma@gmail.com")))
@SpringBootApplication
public class EcomStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcomStoreApplication.class, args);
	}

}
