package com.aulajpa.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.aulajpa.course.entities.Category;
import com.aulajpa.course.entities.Order;
import com.aulajpa.course.entities.Product;
import com.aulajpa.course.entities.User;
import com.aulajpa.course.entities.enums.OrderStatus;
import com.aulajpa.course.repositories.CategoryRepository;
import com.aulajpa.course.repositories.OrderRepository;
import com.aulajpa.course.repositories.ProductRepository;
import com.aulajpa.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	// Criando dependência desacoplada com notation Autowired
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public void run(String... args) throws Exception {
		
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		
		Order o1 = new Order(null, Instant.parse("2025-02-01T13:57:30Z"), OrderStatus.DELIVERED ,u1);
		Order o2 = new Order(null, Instant.parse("2025-02-01T13:59:45Z"), OrderStatus.WATING_PAYMENT, u2);
		Order o3 = new Order(null, Instant.parse("2025-02-01T14:05:10Z"),OrderStatus.CANCELED ,u1);
		
		Category c1 = new Category(null, "Eletronic");
		Category c2 = new Category(null, "Computers");
		Category c3 = new Category(null, "Books");
		
		
		Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
		Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
		Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
		Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
		Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, ""); 
		
		
		
		userRepository.saveAll(Arrays.asList(u1, u2));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
		categoryRepository.saveAll(Arrays.asList(c1, c2));
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
		
	}
	
	
}
