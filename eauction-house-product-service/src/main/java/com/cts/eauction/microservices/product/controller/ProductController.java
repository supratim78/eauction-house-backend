package com.cts.eauction.microservices.product.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.eauction.microservices.product.model.AddNewProductCommand;
import com.cts.eauction.microservices.product.model.ProductCommand;
import com.cts.eauction.microservices.product.services.ProductService;

@RestController
@RequestMapping("/e-auction/api/v1/product")
public class ProductController {

	@Autowired
	private ProductService service;
	
	@PostMapping(path = "/add-product", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ProductCommand addNewProduct(@RequestBody AddNewProductCommand command) throws ParseException {
		//LOG.info("Executing addNewProduct method with " + request);
		
		String date = command.getBidEndDate();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy"); // your template here
		java.util.Date dateStr = formatter.parse(date);
		java.sql.Date dateDB = new java.sql.Date(dateStr.getTime());
		
		ProductCommand product = new ProductCommand(command.getProductName(),command.getShortDescription(),
				command.getDetailedDescription(),command.getCategory(),command.getStartingPrice(),
				dateDB,command.getSellerId());
		product = service.addProduct(product);
		return product;
	}
	
	
	@DeleteMapping("/delete/{productId}")
	public void removeProductFromAuction(@PathVariable Integer productId) {
		ProductCommand productCommand = new ProductCommand();
		productCommand.setId(productId);
		service.deleteProduct(productCommand);
	}
}
