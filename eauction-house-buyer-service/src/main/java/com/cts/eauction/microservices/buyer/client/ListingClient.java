package com.cts.eauction.microservices.buyer.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cts.eauction.microservices.buyer.model.Bid;
import com.cts.eauction.microservices.buyer.model.ProductDetails;

@FeignClient("listing")
public interface ListingClient {
	
	@RequestMapping(method = RequestMethod.GET, value = "/e-auction/api/v1/seller/show-product/{productId}", consumes = "application/json")
	ProductDetails showProductDetail(@PathVariable Integer productId);
	
	@RequestMapping(method = RequestMethod.GET, value = "/e-auction/api/v1/seller/show-bids/{productId}/{buyerId}", consumes = "application/json")
	Bid showBidDetails(@PathVariable Integer productId, @PathVariable Integer buyerId);

}
