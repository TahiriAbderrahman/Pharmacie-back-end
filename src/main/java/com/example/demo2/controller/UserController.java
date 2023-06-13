package com.example.demo2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo2.entity.User;
import com.example.demo2.repository.UserRepository;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("users")
public class UserController {
	@Autowired
	private UserRepository userRepository;
	@PostMapping("/save")
	public void save(@RequestBody User user ){
	userRepository.save(user);
	}
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable (required = true) String id){
	User s = userRepository.findById(Integer.parseInt(id));
	userRepository.delete(s);
	}
	@GetMapping("/all")
	public List<User> findAll(){
	return userRepository.findAll();
	}
	@GetMapping(value = "/count")
	public long countUser() {
	return userRepository.count();
	}
}
