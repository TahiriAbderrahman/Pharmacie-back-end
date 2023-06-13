package com.example.demo2.controller;

import java.util.List;

public interface IDao<T> {
	 void save (T o);
	 List<T> findAll();
	 void delete (T o);
	 void update (T o);
	 T findById (int id);
	 
}
