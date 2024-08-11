package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@CrossOrigin(origins = "*")
public class EmpBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmpBackendApplication.class, args);
	}

}
