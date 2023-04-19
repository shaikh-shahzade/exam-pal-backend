package com.exampal.config;

import java.net.http.HttpRequest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

	@Bean
	public SecurityFilterChain filter(HttpSecurity http) throws Exception 
	{
		http.csrf().disable()
		.authorizeHttpRequests()
		
		.anyRequest()
		.authenticated()
		.and()
		.httpBasic();
		
		
		return http.build();
	}
	
	
	 
	 @Bean
	 PasswordEncoder passwordEncoder()
	 {
		 return  NoOpPasswordEncoder.getInstance();
	 }
}
