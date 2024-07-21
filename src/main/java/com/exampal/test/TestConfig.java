package com.exampal.test;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import com.exampal.service.CategoryService;

@Profile("test")
@Configuration
public class TestConfig {

	@Bean
	@Primary
	public CategoryService catService() {
		return Mockito.mock(CategoryService.class);
	}
}
