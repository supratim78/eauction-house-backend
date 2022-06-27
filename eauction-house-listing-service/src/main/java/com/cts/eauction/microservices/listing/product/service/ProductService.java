package com.cts.eauction.microservices.listing.product.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.eauction.microservices.listing.product.model.ProductCommand;
import com.cts.eauction.microservices.listing.product.repository.ProductAggregate;

@Service
public class ProductService {
	
	@Autowired
	private ProductAggregate ProductAggregate;
	
	public ProductService() {
		
	}
	
	public ProductService(ProductAggregate productAggregate) {
		super();
		ProductAggregate = productAggregate;
	}
	
	public void handleProductConsume(ProductCommand product) {
		ProductAggregate.handleProductConsume(product);
	}
	
	public void saveNewProduct(ProductCommand product) {
		ProductAggregate.handleProductConsume(product);
	}
	
	public long handleProductRemoval(ProductCommand product) {
		long noOfRecordsDeleted = ProductAggregate.handleProductRemoval(product);
		return noOfRecordsDeleted;	
	}

}
