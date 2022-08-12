package com.pragma.image.infrastructure.config.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.pragma.image.application.repository.ImageRepository;
import com.pragma.image.application.service.ImageService;

@Configuration
public class BackendDemoApplicationConfig {
	
    @Bean
    ImageService imageService(ImageRepository imageRepository) {
        return new ImageService(imageRepository);
    }
}
