package com.proyecto.crud_Library;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
public class CrudLibraryApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudLibraryApplication.class, args);
	}

}
