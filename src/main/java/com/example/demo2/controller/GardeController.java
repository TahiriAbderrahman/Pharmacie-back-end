package com.example.demo2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo2.entity.Garde;
import com.example.demo2.repository.GardeRepository;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("gardes")
public class GardeController {
	@Autowired
	private GardeRepository gardeRepository;

	@PostMapping("/save")
	public void save(@RequestBody Garde garde) {
		gardeRepository.save(garde);
	}

	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable(required = true) String id) {
		Garde s = gardeRepository.findById(Integer.parseInt(id));
		gardeRepository.delete(s);
	}

	@GetMapping("/all")
	public List<Garde> findAll() {
		return gardeRepository.findAll();
	}

	@GetMapping(value = "/count")
	public long countGarde() {
		return gardeRepository.count();
	}

}
