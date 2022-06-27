package com.cts.eauction.microservices.seller.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cts.eauction.microservices.seller.model.ProductRequest;
import com.cts.eauction.microservices.seller.model.ProductResponse;

@FeignClient("product")
public interface ProductClient {
	
	@RequestMapping(method = RequestMethod.POST, value = "/e-auction/api/v1/product/add-product", consumes = "application/json")
	ProductResponse addNewProduct(ProductRequest product);
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/e-auction/api/v1/product/delete/{productId}", consumes = "application/json")
	void deleteProduct(@PathVariable("productId") Integer productId);

}
