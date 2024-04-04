package com.demo.bonisApplication.config;

import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.demo.bonisApplication.entities.Category;
import com.demo.bonisApplication.entities.Client;
import com.demo.bonisApplication.entities.Order;
import com.demo.bonisApplication.entities.Payment;
import com.demo.bonisApplication.entities.enums.Status;
import com.demo.bonisApplication.repositories.CategoryRepository;
import com.demo.bonisApplication.repositories.ClientRepository;
import com.demo.bonisApplication.repositories.OrderRepository;
import com.demo.bonisApplication.repositories.PaymentRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private PaymentRepository paymentRepository;

	@Override
	public void run(String... args) throws Exception {
		Client c1 = new Client(null, "Erick", "119999992");
		Client c2 = new Client(null, "Elcio", "119999993");
		Client c3 = new Client(null, "Maria", "119993993");
		
		clientRepository.saveAll(Arrays.asList(c1,c2));
		
		Order o1 = new Order(null, "Pia da cozinha", 2000.00, new Date(), Status.PRODUCING, c1);
		Order o2 = new Order(null, "Sala e Cozinha completas", 8000.00, new Date(), Status.WAYTING_PAYMENT, c2);
		
		Category cat1 = new Category(null, "Marcenaria");
		Category cat2 = new Category(null, "Marmoraria");
		
		categoryRepository.saveAll(Arrays.asList(cat1, cat2));
		orderRepository.saveAll(Arrays.asList(o1, o2));
		
		Payment p1 = new Payment(null, 1000.00, new Date(), o1);
		paymentRepository.save(p1);
		
		o1.getCategories().add(cat1);
		o2.getCategories().addAll(Arrays.asList(cat1, cat2));
		
		o1.getPayments().add(p1);
		
		clientRepository.saveAll(Arrays.asList(c1,c2));
		orderRepository.saveAll(Arrays.asList(o1, o2));
	}
}