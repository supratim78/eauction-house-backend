package com.cts.eauction.microservices.seller.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.eauction.microservices.seller.model.Seller;

public interface SellerRepository extends JpaRepository<Seller, Integer> {
	
}
