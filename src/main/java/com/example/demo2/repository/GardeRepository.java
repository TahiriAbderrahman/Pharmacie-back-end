package com.example.demo2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo2.entity.Garde;

public interface GardeRepository extends JpaRepository<Garde, Integer> {
	Garde findById(int id);
}
