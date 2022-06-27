package com.cts.eauction.microservices.listing.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cts.eauction.microservices.listing.model.ProductDetails;

public interface ProductReadRepository extends MongoRepository<ProductDetails, Integer> {
	public ProductDetails findByProductId(Integer productId);
}
