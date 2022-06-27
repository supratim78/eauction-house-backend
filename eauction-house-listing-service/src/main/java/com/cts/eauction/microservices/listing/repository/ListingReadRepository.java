package com.cts.eauction.microservices.listing.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cts.eauction.microservices.listing.model.BidsReceivedOnProductQuery;
import com.cts.eauction.microservices.listing.model.ProductDetails;

public interface ListingReadRepository extends MongoRepository<ProductDetails, Integer>{

	public ProductDetails findByProductId(Integer productId);
}
