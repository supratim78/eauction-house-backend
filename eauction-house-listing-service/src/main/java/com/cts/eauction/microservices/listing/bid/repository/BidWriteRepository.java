package com.cts.eauction.microservices.listing.bid.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cts.eauction.microservices.listing.bid.model.BidCommand;

@Repository
public interface BidWriteRepository extends MongoRepository<BidCommand, String> {
	
}
