package com.pragma.person.infrastructure.config.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication(scanBasePackages = "com.pragma.person.infrastructure")
@EntityScan(basePackages = "com.pragma.person.domain")
public class BackendDemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(BackendDemoApplication.class, args);
	}

}
