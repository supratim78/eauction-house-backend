package com.cts.eauction.microservices.listing.product.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cts.eauction.microservices.listing.product.model.ProductCommand;



@Component
public class ProductAggregate {

	@Autowired
	private ProductWriteRepository productWriteRepository;

	public ProductAggregate() {
		
	}

	public ProductAggregate(ProductWriteRepository productWriteRepository) {
		super();
		this.productWriteRepository = productWriteRepository;
	}
	
	public void handleProductConsume(ProductCommand product) {
		productWriteRepository.save(product);
	}
	
	public long handleProductRemoval(ProductCommand product) {
		long noOfRecordsDeleted = productWriteRepository.deleteByProductId(product.getProductId());
		return noOfRecordsDeleted;
	}
	
	
	
	
}
