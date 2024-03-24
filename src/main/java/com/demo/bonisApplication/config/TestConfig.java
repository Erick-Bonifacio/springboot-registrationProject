package com.demo.bonisApplication.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.demo.bonisApplication.entities.Client;
import com.demo.bonisApplication.repositories.ClientRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

	@Autowired //auto injecao de dependencia
	private ClientRepository clientRepository;

	@Override
	public void run(String... args) throws Exception {
		Client c1 = new Client(null, "Erick", "119999992");
		Client c2 = new Client(null, "Elcio", "119999993");
		clientRepository.saveAll(Arrays.asList(c1,c2));
	}
}