package com.veiculo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan(basePackages = "com.veiculo")
@EntityScan(basePackages = {"com.veiculo.domains"})
@EnableJpaRepositories(basePackages = "com.veiculo.repositories")
@SpringBootApplication
public class VeiculoApplication {

	public static void main(String[] args) {
		SpringApplication.run(VeiculoApplication.class, args);
	}

}