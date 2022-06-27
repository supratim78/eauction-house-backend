package com.cts.eauction.microservices.bid.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.eauction.microservices.bid.model.BidCommand;

public interface BidRepository extends JpaRepository<BidCommand, Integer> {
	
	public BidCommand findByBuyerIdAndProductId(Integer buyerId,Integer productId); 

}
