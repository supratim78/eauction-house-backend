package com.cts.eauction.microservices.listing.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cts.eauction.microservices.listing.model.BidDetails;

import org.springframework.data.domain.Sort;

public interface BidReadRepository extends MongoRepository<BidDetails, Integer> {
	
	public List<BidDetails> findByProductId(Integer productId,Sort sort);
	
	public BidDetails findByBuyerIdAndId(Integer buyerId, Integer id);
	
	public BidDetails findByProductIdAndBuyerId(Integer productId, Integer buyerId);
}
