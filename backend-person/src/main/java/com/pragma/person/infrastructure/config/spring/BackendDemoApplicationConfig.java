package com.pragma.person.infrastructure.config.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

import com.pragma.person.application.repository.PersonRepository;
import com.pragma.person.application.service.PersonService;

@Configuration
public class BackendDemoApplicationConfig {
	
    @Bean
    PersonService personService(PersonRepository personRepository) {
        return new PersonService(personRepository);
    }
    
    @Bean
    WebClient.Builder getWebClientBuilder() {
    	return WebClient.builder();
    }
}
