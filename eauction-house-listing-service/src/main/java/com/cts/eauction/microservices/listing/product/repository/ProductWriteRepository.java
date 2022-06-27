package com.cts.eauction.microservices.listing.product.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cts.eauction.microservices.listing.product.model.ProductCommand;



@Repository
public interface ProductWriteRepository extends MongoRepository<ProductCommand, String> {
	public long deleteByProductId(Integer productId);
}
