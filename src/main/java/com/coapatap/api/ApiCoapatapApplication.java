package com.coapatap.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class ApiCoapatapApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiCoapatapApplication.class, args);
	}

}
