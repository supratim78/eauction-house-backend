package com.cts.eauction.microservices.product.repository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cts.eauction.microservices.product.model.AddNewProductCommand;
import com.cts.eauction.microservices.product.model.ProductCommand;



@Component
public class ProductAggregate {
	
	@Autowired
	private ProductWriteRepository repository;

	public ProductAggregate() {
		
	}

	public ProductAggregate(ProductWriteRepository repository) {
		super();
		this.repository = repository;
	}
	
	public ProductCommand handleAddNewProduct(ProductCommand product) {
		product = repository.save(product);
		return product;
	}
	
	public void handleDeleteProduct(ProductCommand product) {
		repository.delete(product);
	}
	
	

}
