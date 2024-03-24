package com.demo.bonisApplication.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.bonisApplication.entities.Order;

public interface OrderRepository  extends JpaRepository<Order, Long>{

}
