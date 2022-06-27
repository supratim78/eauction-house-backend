package com.cts.eauction.microservices.listing.bid.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.eauction.microservices.listing.bid.model.BidCommand;
import com.cts.eauction.microservices.listing.bid.repository.BidAggregate;

@Service
public class BidService {
	
	@Autowired
	private BidAggregate bidAggregate;

	public BidService() {
		
	}

	public BidService(BidAggregate bidAggregate) {
		super();
		this.bidAggregate = bidAggregate;
	}
	
	public void handleBidConsume(BidCommand bid) {
		bidAggregate.placeBid(bid);
	}
	
	public void handleBidUpdate(BidCommand bid) {
		bidAggregate.updateBid(bid);
	}
}
