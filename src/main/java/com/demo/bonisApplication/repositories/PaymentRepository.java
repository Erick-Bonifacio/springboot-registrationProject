package com.demo.bonisApplication.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.bonisApplication.entities.Payment;

public interface PaymentRepository  extends JpaRepository<Payment, Long>{

}
