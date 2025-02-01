package com.aulajpa.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aulajpa.course.entities.Order;



public interface OrderRepository extends JpaRepository<Order, Long>{
	
	
}
