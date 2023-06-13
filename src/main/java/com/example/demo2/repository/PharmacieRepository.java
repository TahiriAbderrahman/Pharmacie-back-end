package com.example.demo2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo2.entity.Pharmacie;

public interface PharmacieRepository extends JpaRepository<Pharmacie, Integer> {
	 Pharmacie findById(int id);
}
