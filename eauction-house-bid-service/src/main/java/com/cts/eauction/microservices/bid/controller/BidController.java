package com.cts.eauction.microservices.bid.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.eauction.microservices.bid.model.BidCommand;
import com.cts.eauction.microservices.bid.service.BidService;

@RestController
@RequestMapping("/e-auction/api/v1/bid")
public class BidController {
	
	private static final Logger LOG = LoggerFactory.getLogger(BidController.class);

	@Autowired
	private BidService service;
	
	@PostMapping(path = "/place-bid", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public BidCommand placeBid(@RequestBody BidCommand request) {
		//LOG.info("Executing addNewProduct method with " + request);
		
		BidCommand bid = service.placeBid(request);
		return bid;
	}
	
	@PutMapping(path = "/update-bid/{productId}/{buyerId}/{newBidAmount}")
	public void updateBid(@PathVariable Integer productId, @PathVariable Integer buyerId, 
			@PathVariable Integer newBidAmount) {
		
		BidCommand bidCommand =new BidCommand();
		bidCommand.setBuyerId(buyerId);
		bidCommand.setBidAmount(newBidAmount);
		bidCommand.setProductId(productId);
		
		LOG.info("BidCommand received for updating Bid: " + bidCommand);
		
		service.updateBid(bidCommand);
	}
}
