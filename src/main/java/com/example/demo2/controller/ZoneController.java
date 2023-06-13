package com.example.demo2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo2.entity.Zone;
import com.example.demo2.repository.ZoneRepository;

import io.swagger.v3.oas.annotations.parameters.RequestBody;


@RestController
@RequestMapping("zones")
public class ZoneController {
	@Autowired
	private ZoneRepository zoneRepository;
	@PostMapping("/save")
	public void save(@RequestBody Zone zone){
	zoneRepository.save(zone);
	}
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable (required = true) String id){
	Zone s = zoneRepository.findById(Integer.parseInt(id));
	zoneRepository.delete(s);
	}
	@GetMapping("/all")
	public List<Zone> findAll(){
	return zoneRepository.findAll();
	}
	@GetMapping(value = "/count")
	public long countZone() {
	return zoneRepository.count();
	}
	
	
}
