package com.demo.bonisApplication.services;

import java.util.List;
import java.util.Optional;

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
		return clientRepository.findAll();
	}
	
	public Client findById(Long id) {
		Optional<Client> op = clientRepository.findById(id);
		return op.get();
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

