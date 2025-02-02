package com.aulajpa.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aulajpa.course.entities.Category;



public interface CategoryRepository extends JpaRepository<Category, Long>{
	
	
}
