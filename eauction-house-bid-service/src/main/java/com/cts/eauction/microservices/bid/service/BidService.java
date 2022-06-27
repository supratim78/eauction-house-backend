package com.cts.eauction.microservices.bid.service;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.cts.eauction.events.BidEvent;
import com.cts.eauction.events.EventType;
import com.cts.eauction.microservices.bid.model.BidCommand;
import com.cts.eauction.microservices.bid.repository.BidAggregate;

@Service
@Transactional
public class BidService {
	
	private static final Logger LOG = LoggerFactory.getLogger(BidService.class);

	@Autowired
	private BidAggregate bidAggregate;
	@Autowired 
	private Source source;

	public BidCommand placeBid(BidCommand bid) {
		LOG.info("Executing placeBid with BidCommand" + bid);
		bid = bidAggregate.placeBid(bid);
		
		LOG.info("After saving BidCommand" + bid);
		
		BidEvent bidEvent = new BidEvent(bid.getId(), bid.getProductId(), bid.getBidAmount(), bid.getBuyerId(),
				EventType.PLACEBID.getType(), bid.getBuyerName(), bid.getBuyerPhone(), bid.getBuyerEmail());
		
		LOG.info("After creating Bid Event" + bidEvent);
		
		source.output().send(MessageBuilder.withPayload(bidEvent).build());
		
		return bid;
	}
	
	public void updateBid(BidCommand bidCommand) {
		
		LOG.info("Executing updateBid with BidCommand" + bidCommand);
		
		BidCommand updatedBid = bidAggregate.updateBid(bidCommand);
		
		BidEvent bidEvent = new BidEvent(updatedBid.getId(), updatedBid.getProductId(), updatedBid.getBidAmount(),
				updatedBid.getBuyerId(), EventType.UPDATEBID.getType(), updatedBid.getBuyerName(), updatedBid.getBuyerPhone(),
				updatedBid.getBuyerEmail());
		
		LOG.info("Update bid event object " + bidEvent);
		
		source.output().send(MessageBuilder.withPayload(bidEvent).build());
		
	}

	
}
