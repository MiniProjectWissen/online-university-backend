package com.example.university;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories ("domain.repositroy-package")
public class OnlineUniversityBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineUniversityBackendApplication.class, args);
	}

}
