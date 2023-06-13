package com.example.demo2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo2.entity.Photo;

public interface PhotoRepository extends JpaRepository<Photo, Integer> {
	Photo findById(int id);
}
