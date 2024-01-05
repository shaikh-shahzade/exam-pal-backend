package com.exampal.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {

	@Autowired
	AuthenticationEntryPoint authEntryPoint;

	@Autowired
	JwtAuthenticationFilter jwtFilter;

	@Bean
	public SecurityFilterChain filter(HttpSecurity http) throws Exception
	{
		http.csrf().disable()
		.authorizeHttpRequests()
		.requestMatchers("**","auth/generate","/quiz/retrieve","/public/**","/images/**","/user")
		.permitAll()
		.anyRequest()
		.authenticated()
		.and()
		.exceptionHandling()
		.authenticationEntryPoint(authEntryPoint)
		.and()
		.sessionManagement()
		.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		;
		http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);


		return http.build();
	}

	@Bean
	public AuthenticationManager authenticationManagerBean(AuthenticationConfiguration authConfig) throws Exception {
		return authConfig.getAuthenticationManager();
	}


	 @Bean
	 PasswordEncoder passwordEncoder()
	 {
		 return  NoOpPasswordEncoder.getInstance();
	 }
}
