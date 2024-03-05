package com.nklcb.cosmos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class CosmosApplication {

	public static void main(String[] args) {
		SpringApplication.run(CosmosApplication.class, args);
	}

}
