package com.cts.eauction.microservices.bid.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cts.eauction.microservices.bid.model.BidCommand;

@Component
public class BidAggregate {

	@Autowired
	private BidRepository bidRepository;

	public BidAggregate() {
		
	}

	public BidAggregate(BidRepository bidRepository) {
		super();
		this.bidRepository = bidRepository;
	}
	
	public BidCommand placeBid(BidCommand bid) {
		bid = bidRepository.save(bid);
		return bid;
	}
	
	public BidCommand updateBid(BidCommand bidCommand) {
		BidCommand bid = bidRepository.findByBuyerIdAndProductId(bidCommand.getBuyerId(), bidCommand.getProductId());
		bid.setBidAmount(bidCommand.getBidAmount());
		BidCommand updatedBid = bidRepository.save(bid);
		return updatedBid;
	}
	

	
	
}
