package com.cotemig.br.sistemaVeiculos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class SistemaVeiculosApplication {

	public static void main(String[] args) {
		SpringApplication.run(SistemaVeiculosApplication.class, args);
		System.out.print(new BCryptPasswordEncoder().encode("123"));
	}
}
