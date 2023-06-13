package com.example.demo2.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.authentication.PasswordEncoderParser;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.example.demo2.entity.User;
import com.example.demo2.repository.UserRepository;

@Component
public class UserAthentificationProvidor implements AuthenticationProvider{
	
	@Autowired 
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoderParser passwordEncoder;
	
	@Override
	public AuthenticationConfiguration authenticate(AuthenticationConfiguration authentication) {
		String username = authentication.getName();
		String pwd = authentication.getCredentials().toString();
		System.out.println("login and pw : "+ username + " " + pwd);
		User user = userRepository.findByNom(username);
		if (user.size() > 0) {
			System.out.println("hi");
			if (passwordEncoder.matches(pwd, user.getPassword())) {
				System.out.println("hihi");
				return new UsernamePasswordAuthenticationToken(username, pwd);
			} else {
				throw new BadCredentialsException("Invalid password!");
			}
		} else {
			throw new BadCredentialsException("No user registered with this details!");
		}
		

	}
	
	
	@Override
	public boolean supports(Class<?> authenticationType) {
		return authenticationType.equals(UsernamePasswordAuthenticationToken.class);
	}

}
