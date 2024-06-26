package com.exampal.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
		.cors()
		.and()
		.authorizeHttpRequests()
		.requestMatchers(HttpMethod.POST ,"/user/v1")
		.permitAll()
		.requestMatchers("/swagger-ui/**","/v3/api-docs/**","auth/generate","/quiz/retrieve","/public/**","/images/**")
		.permitAll()
		.anyRequest()
		.authenticated()
		.and()
		.exceptionHandling()
		.authenticationEntryPoint(authEntryPoint)
		.and()
		.sessionManagement()
		.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and()
		.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);


		return http.build();
	}

	@Bean
	public AuthenticationManager authenticationManagerBean(AuthenticationConfiguration authConfig) throws Exception {
		return authConfig.getAuthenticationManager();
	}


	 @Bean
	 PasswordEncoder passwordEncoder()
	 {
		 return  new BCryptPasswordEncoder();
	 }
}
