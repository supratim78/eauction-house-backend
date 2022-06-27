package com.cts.eauction.microservices.listing.bid.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cts.eauction.microservices.listing.bid.model.BidCommand;
import com.cts.eauction.microservices.listing.model.BidDetails;
import com.cts.eauction.microservices.listing.repository.BidReadRepository;

@Component
public class BidAggregate {

	@Autowired
	private BidWriteRepository bidWriteRepository;
	
	@Autowired
	private BidReadRepository bidReadRepository;

	public BidAggregate() {
		
	}

	public BidAggregate(BidWriteRepository bidWriteRepository) {
		super();
		this.bidWriteRepository = bidWriteRepository;
	}
	
	public void placeBid(BidCommand bid) {
		bidWriteRepository.save(bid);
	}
	
	public void updateBid(BidCommand bid) {
		BidDetails bidDetails = bidReadRepository.findByBuyerIdAndId(bid.getBuyerId(),bid.getId());
		
		BidCommand bidCommand = new BidCommand(bidDetails.getId(), bidDetails.getProductId(), 
				bid.getBidAmount(), bidDetails.getBuyerId(),bidDetails.getBuyerName(),bidDetails.getBuyerPhone(),bidDetails.getBuyerEmail());
		bidWriteRepository.save(bidCommand);
	}
	
	
	
	
}
