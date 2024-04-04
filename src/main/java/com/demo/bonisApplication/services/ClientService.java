package com.demo.bonisApplication.services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.demo.bonisApplication.entities.Client;
import com.demo.bonisApplication.repositories.ClientRepository;
import com.demo.bonisApplication.services.exceptions.DataBaseException;
import com.demo.bonisApplication.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository clientRepository;
	
	public List<Client> findAll(){
		return clientRepository.findAll().stream().map(client -> {client.refreshTotalOrders(); return client;}).collect(Collectors.toList());
	}
	
	public Client findById(Long id) {
		try {
			Optional<Client> op = clientRepository.findById(id);
			if(op.get() != null) {
				op.get().refreshTotalOrders();
				}
			return op.get();
		}catch(NoSuchElementException e) {
			throw new ResourceNotFoundException(id);
		}
			
	}
	
	public Client insert(Client obj) {
		return clientRepository.save(obj);
	}
	
	public void delete(Long id) {
		try {
			if(!clientRepository.existsById(id)) {
				throw new ResourceNotFoundException(id);
			}
			clientRepository.deleteById(id);
		} catch(DataIntegrityViolationException e) {
			throw new DataBaseException(e.getMessage());
		}
	}
	
	public Client update(Client obj, Long id) {
		try {
			Client entity = clientRepository.getReferenceById(id);
			updateData(entity, obj);
			return clientRepository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}
	
	public void updateData(Client oldClient, Client newClient) {
		oldClient.setName(newClient.getName());
		oldClient.setPhone(newClient.getPhone());
	}
}

