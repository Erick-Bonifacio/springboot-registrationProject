package com.demo.bonisApplication.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.bonisApplication.entities.Client;
import com.demo.bonisApplication.repositories.ClientRepository;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository clientRepository;
	
	public List<Client> findAll(){
		return clientRepository.findAll();
	}
	
	public Client findById(Long id) {
		Optional<Client> op = clientRepository.findById(id);
		return op.get();
	}
}
