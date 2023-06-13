package com.example.demo2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo2.entity.Pharmacie;
import com.example.demo2.repository.PharmacieRepository;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("pharmacies")
public class PharmacieController {
	@Autowired
	private PharmacieRepository pharmacieRepository;

	@PostMapping("/save")
	public void save(@RequestBody Pharmacie pharmacie) {
		pharmacieRepository.save(pharmacie);
	}

	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable(required = true) String id) {
		Pharmacie s = pharmacieRepository.findById(Integer.parseInt(id));
		pharmacieRepository.delete(s);
	}

	@GetMapping("/all")
	public List<Pharmacie> findAll() {
		return pharmacieRepository.findAll();
	}

	@GetMapping(value = "/count")
	public long countPharmacie() {
		return pharmacieRepository.count();
	}
}
