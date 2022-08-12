package com.pragma.image.infrastructure.config.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication(scanBasePackages = "com.pragma.image.infrastructure")
@EntityScan(basePackages = "com.pragma.image.domain")
//@ComponentScan(basePackages =  "com.pragma.person.infrastructure.db.springdata")
public class BackendDemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(BackendDemoApplication.class, args);
	}

}
