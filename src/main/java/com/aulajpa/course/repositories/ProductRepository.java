package com.aulajpa.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aulajpa.course.entities.Product;



public interface ProductRepository extends JpaRepository<Product, Long>{
	
	
}
