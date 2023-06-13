package com.example.demo2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo2.entity.Role;
import com.example.demo2.repository.RoleRepository;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("roles")
public class RoleController {
	@Autowired
	private RoleRepository roleRepository;
	@PostMapping("/save")
	public void save(@RequestBody Role role){
	roleRepository.save(role);
	}
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable (required = true) String id){
	Role s = roleRepository.findById(Integer.parseInt(id));
	roleRepository.delete(s);
	}
	@GetMapping("/all")
	public List<Role> findAll(){
	return roleRepository.findAll();
	}
	@GetMapping(value = "/count")
	public long countRole() {
	return roleRepository.count();
	}
}
