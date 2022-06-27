package com.cts.eauction.microservices.buyer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.eauction.microservices.buyer.model.Buyer;

public interface BuyerRepository extends JpaRepository<Buyer, Integer> {
	
	public Buyer findByEmail(String email);

}
