package com.example.demo2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

public class SecurityConfig {
	
	 @Bean
	    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {

	        /**
	         * Custom configurations as per our requirement
	         */
	        http.csrf(csrf -> csrf
	                .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()))
	        .authorizeHttpRequests()
	                .requestMatchers("pharmacies", "gardes", "photos","users","villes","zones").permitAll()
	                .anyRequest().authenticated()
	                .and()
	                .formLogin()
	                .loginPage("/login")
	                .defaultSuccessUrl("pharmacies",true)
	                .permitAll();
	                return http.build();

	    }

}
