package com.demo.bonisApplication.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.bonisApplication.entities.Payment;
import com.demo.bonisApplication.repositories.PaymentRepository;

@Service
public class PaymentService {
	
	@Autowired
	private PaymentRepository repo;
	
	public List<Payment> findAll(){
		return repo.findAll();
	}
	
	public Payment findById(Long id) {
		Optional<Payment> op = repo.findById(id);
		return op.get();
	}
}
