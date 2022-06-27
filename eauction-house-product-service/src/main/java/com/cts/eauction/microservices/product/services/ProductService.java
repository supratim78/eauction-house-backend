package com.cts.eauction.microservices.product.services;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.cts.eauction.events.EventType;
import com.cts.eauction.events.ProductEvent;
import com.cts.eauction.microservices.product.model.ProductCommand;
import com.cts.eauction.microservices.product.repository.ProductAggregate;

@Service
@Transactional
public class ProductService {
	
	private static final Logger LOG = LoggerFactory.getLogger(ProductService.class);

	@Autowired
	private ProductAggregate productAggregate;
	@Autowired 
	private Source source;

	public ProductCommand addProduct(ProductCommand product) {
		product = productAggregate.handleAddNewProduct(product);
		
		ProductEvent productAddEvent = new ProductEvent(product.getId(), product.getProductName(), 
				product.getShortDescription(), product.getDetailedDescription(), product.getCategory(), 
				product.getStartingPrice(), product.getBidEndDate(), product.getSellerId(), 
				EventType.ADDNEW.getType());
		
		source.output().send(MessageBuilder.withPayload(productAddEvent).build());
		
		return product;
	}
	
	public void deleteProduct(ProductCommand productCommand) {
		
		LOG.info("productCommand=" + productCommand);
		
		productAggregate.handleAddNewProduct(productCommand);
		
		ProductEvent productDeleteEvent = new ProductEvent(productCommand.getId(),null,null,null,null,
				null,null,null,EventType.DELETE.getType());
		
		LOG.info("product Delete Event=" + productDeleteEvent);
		
		
		source.output().send(MessageBuilder.withPayload(productDeleteEvent).build());
	}
}
