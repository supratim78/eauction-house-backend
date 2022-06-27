package com.cts.eauction.microservices.buyer.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cts.eauction.microservices.buyer.model.Bid;

@FeignClient("bid")
public interface BidClient {
	
	@RequestMapping(method = RequestMethod.POST, value = "/e-auction/api/v1/bid/place-bid", consumes = "application/json")
	Bid placeBid(Bid bidRequest);
	
	@RequestMapping(method = RequestMethod.PUT, value = "/e-auction/api/v1/bid/update-bid/{productId}/{buyerId}/{newBidAmount}", consumes = "application/json")
	void updateBid(@PathVariable Integer productId, @PathVariable Integer buyerId, 
			@PathVariable Integer newBidAmount);

}
