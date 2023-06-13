package com.example.demo2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo2.entity.Ville;
import com.example.demo2.repository.VilleRepository;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("villes")
public class VilleController {
	@Autowired
	private VilleRepository villeRepository;
	@PostMapping("/save")
	public Ville save(@RequestBody Ville ville){
	return villeRepository.save(ville);
	}
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable (required = true) String id){
	Ville s = villeRepository.findById(Integer.parseInt(id));
	villeRepository.delete(s);
	}
	@GetMapping("/all")
	public List<Ville> findAll(){
	return villeRepository.findAll();
	}
	@GetMapping(value = "/count")
	public long countVille() {
	return villeRepository.count();
	}
	
	
}
