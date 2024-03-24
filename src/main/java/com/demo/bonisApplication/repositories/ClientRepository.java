package com.demo.bonisApplication.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.bonisApplication.entities.Client;

public interface ClientRepository  extends JpaRepository<Client, Long>{

}
