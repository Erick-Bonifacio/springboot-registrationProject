package com.demo.bonisApplication.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.bonisApplication.entities.Client;



@RestController
@RequestMapping(value="/clients")
public class ClientResource {
	
	@GetMapping
	public ResponseEntity<Client> findAll(){
		Client erick = new Client(1L, "Erick", "119938117055");
		return ResponseEntity.ok().body(erick);
	}
	
	
}
