package com.demo.bonisApplication.config;

import java.util.Arrays;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.demo.bonisApplication.entities.Category;
import com.demo.bonisApplication.entities.Client;
import com.demo.bonisApplication.entities.Order;
import com.demo.bonisApplication.entities.enums.Status;
import com.demo.bonisApplication.repositories.CategoryRepository;
import com.demo.bonisApplication.repositories.ClientRepository;
import com.demo.bonisApplication.repositories.OrderRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public void run(String... args) throws Exception {
		Client c1 = new Client(null, "Erick", "119999992");
		Client c2 = new Client(null, "Elcio", "119999993");
		
		Order o1 = new Order(null, "Pia da cozinha", 2000.00, new Date(), Status.PRODUCING, c1);
		Order o2 = new Order(null, "Sala e Cozinha completas", 8000.00, new Date(), Status.WAYTING_PAYMENT, c2);
		
		Category cat1 = new Category(null, "Marcenaria");
		Category cat2 = new Category(null, "Marmoraria");
		
		categoryRepository.saveAll(Arrays.asList(cat1, cat2));
		
		Optional<Category> obj1 = categoryRepository.findById(cat1.getId());
		Optional<Category> obj2 = categoryRepository.findById(cat2.getId());
		
		o1.getCategories().add(obj1.get());
		o2.getCategories().addAll(Arrays.asList(obj2.get()));
		
		clientRepository.saveAll(Arrays.asList(c1,c2));
		orderRepository.saveAll(Arrays.asList(o1, o2));
	}
}