package com.aulajpa.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.aulajpa.course.entities.Order;
import com.aulajpa.course.entities.User;
import com.aulajpa.course.entities.enums.OrderStatus;
import com.aulajpa.course.repositories.OrderRepository;
import com.aulajpa.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	// Criando dependência desacoplada com notation Autowired
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;

	@Override
	public void run(String... args) throws Exception {
		
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		
		Order o1 = new Order(null, Instant.parse("2025-02-01T13:57:30Z"), OrderStatus.DELIVERED ,u1);
		Order o2 = new Order(null, Instant.parse("2025-02-01T13:59:45Z"), OrderStatus.WATING_PAYMENT, u2);
		Order o3 = new Order(null, Instant.parse("2025-02-01T14:05:10Z"),OrderStatus.CANCELED ,u1);
		
		userRepository.saveAll(Arrays.asList(u1, u2));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
		
	}
	
	
}
