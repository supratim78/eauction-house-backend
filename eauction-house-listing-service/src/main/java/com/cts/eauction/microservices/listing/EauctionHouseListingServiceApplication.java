package com.cts.eauction.microservices.listing;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;

import com.cts.eauction.events.BidEvent;
import com.cts.eauction.events.EventType;
import com.cts.eauction.events.ProductEvent;
import com.cts.eauction.microservices.listing.bid.model.BidCommand;
import com.cts.eauction.microservices.listing.bid.service.BidService;
import com.cts.eauction.microservices.listing.channel.BidSink;
import com.cts.eauction.microservices.listing.product.model.ProductCommand;
import com.cts.eauction.microservices.listing.product.service.ProductService;

@SpringBootApplication
@EnableBinding(BidSink.class)
public class EauctionHouseListingServiceApplication {
	
	private static final Logger LOG = LoggerFactory.getLogger(EauctionHouseListingServiceApplication.class);
	@Autowired
	private ProductService productService;
	@Autowired
	private BidService bidService;
	
	public static void main(String[] args) {
		SpringApplication.run(EauctionHouseListingServiceApplication.class, args);
	}
	
	
	@SuppressWarnings("deprecation")
	@StreamListener(value = Sink.INPUT)
	public void consumeProductEvents(Message<ProductEvent> productEvent) {

		LOG.info("Product obtained from topic " + productEvent.getPayload().getEventType());
		
		if (EventType.ADDNEW.getType().equals(productEvent.getPayload().getEventType())) {

			ProductCommand productCommand = new ProductCommand(productEvent.getPayload().getProductId(),
					productEvent.getPayload().getProductName(), productEvent.getPayload().getShortDescription(),
					productEvent.getPayload().getDetailedDescription(), productEvent.getPayload().getCategory(),
					productEvent.getPayload().getStartingPrice(),
					productEvent.getPayload().getBidEndDate().toLocalDate(), productEvent.getPayload().getSellerId());

			LOG.info("Product obtained from topic to add " + productCommand);
			productService.handleProductConsume(productCommand);
			return;
		}
		
		if(EventType.DELETE.getType().equals(productEvent.getPayload().getEventType())) {
			
			ProductCommand productCommand = new ProductCommand();
			productCommand.setProductId(productEvent.getPayload().getProductId());
			
			LOG.info("Product obtained from topic to delete " + productCommand);
			
			long noOfRecordsDeleted = productService.handleProductRemoval(productCommand);
			
			LOG.info("No Of records deleted " + noOfRecordsDeleted);
			
		}
 
	}
	 
	@SuppressWarnings("deprecation")
	@StreamListener(value = BidSink.BIDINPUT)
	public void consumeBidEvents(Message<BidEvent> bidEvent) {
		LOG.info("start executing consumeBidEvents " + bidEvent);

		if (EventType.PLACEBID.getType().equals(bidEvent.getPayload().getEventType())) {

			BidCommand bidCommand = new BidCommand(bidEvent.getPayload().getBidId(),
					bidEvent.getPayload().getProductId(), bidEvent.getPayload().getBidAmount(),
					bidEvent.getPayload().getBuyerId(), bidEvent.getPayload().getBuyerName(),
					bidEvent.getPayload().getBuyerPhone(), bidEvent.getPayload().getBuyerEmail());

			LOG.info("Bid consumed from topic " + bidCommand);
			bidService.handleBidConsume(bidCommand);
			return;

		}
		
		if (EventType.UPDATEBID.getType().equals(bidEvent.getPayload().getEventType())) {
			
			BidCommand bidCommand = new BidCommand(bidEvent.getPayload().getBidId(),
					bidEvent.getPayload().getProductId(), bidEvent.getPayload().getBidAmount(),
					bidEvent.getPayload().getBuyerId());

			LOG.info("Bid consumed from topic for update " + bidCommand);
			bidService.handleBidUpdate(bidCommand);
			return;
		}

	}
}
