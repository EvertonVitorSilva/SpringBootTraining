package com.aulajpa.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aulajpa.course.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	
}
