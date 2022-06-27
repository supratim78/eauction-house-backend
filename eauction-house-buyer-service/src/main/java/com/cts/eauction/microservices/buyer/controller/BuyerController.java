package com.cts.eauction.microservices.buyer.controller;

import java.time.LocalDate;
import java.time.ZoneId;

import javax.validation.Valid;

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

import com.cts.eauction.microservices.buyer.Exception.BidRequestNotValidException;
import com.cts.eauction.microservices.buyer.client.BidClient;
import com.cts.eauction.microservices.buyer.client.ListingClient;
import com.cts.eauction.microservices.buyer.model.Bid;
import com.cts.eauction.microservices.buyer.model.Buyer;
import com.cts.eauction.microservices.buyer.model.PlaceBidRequest;
import com.cts.eauction.microservices.buyer.model.ProductDetails;
import com.cts.eauction.microservices.buyer.service.BuyerService;


@RestController
@RequestMapping("/e-auction/api/v1/buyer")
public class BuyerController {
	
	private static final Logger LOG = LoggerFactory.getLogger(BuyerController.class);
	
	@Autowired
	private BuyerService service;
	
	@Autowired 
	private BidClient bidClient;
	
	@Autowired
	private ListingClient listingClient;
	
	@PostMapping(path = "/place-bid", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Buyer placeBid(@RequestBody @Valid PlaceBidRequest request) throws BidRequestNotValidException {
		//LOG.info("Executing addNewProduct method with " + request);
		
		validatePlaceBidRequest(request);
		
		
		Buyer buyer = new Buyer(request.getFirstName(),request.getLastName(),request.getAddress(),request.getCity(),
				request.getState(),request.getPin(),request.getPhone(),request.getEmail());
		buyer = service.registerBuyer(buyer);
		
		
		Bid bidRequest = new Bid(null, request.getProductId(), request.getBidAmount(), buyer.getId(),
				buyer.getFirstName() + " " + buyer.getLastName(), buyer.getPhone(), buyer.getEmail());
		Bid bidResponse = bidClient.placeBid(bidRequest);
		return buyer;
	}
	
	@PutMapping(path = "/update-bid/{productId}/{buyerEmailld}/{newBidAmount}")
	public void updateBid(@PathVariable Integer productId, @PathVariable String buyerEmailld, 
			@PathVariable Integer newBidAmount) throws BidRequestNotValidException{
		
		validateUpdateBidRequest(productId, buyerEmailld, newBidAmount);
		
		Buyer buyer = service.findBuyerByEmail(buyerEmailld);
		bidClient.updateBid(productId, buyer.getId(), newBidAmount);
		
		
	}
	
	private boolean validatePlaceBidRequest(PlaceBidRequest request) throws BidRequestNotValidException {
		
		boolean flag = true;
		ProductDetails productDetails = listingClient.showProductDetail(request.getProductId());
		LOG.info("productDetails====" + productDetails);
		if(productDetails == null) {
			throw new BidRequestNotValidException("Bid is placed on a product that does not exist");
		}
		
		LocalDate localDateNow = LocalDate.now(ZoneId.systemDefault());
		if(localDateNow.isAfter(productDetails.getBidEndDate())) {
			throw new BidRequestNotValidException("Sorry! You cannot place a bid after Bid End Date of the product");
		}
		
		Buyer buyer = service.findBuyerByEmail(request.getEmail());
		Bid bidDetail = null;
		if(buyer!= null && (bidDetail = listingClient.showBidDetails(request.getProductId(), buyer.getId())) != null) {
			throw new BidRequestNotValidException("Bid already placed for the same product. Please update the bid instead of placing a new one");
		}
		
		return flag;
	}
	
	
	private boolean validateUpdateBidRequest(@PathVariable Integer productId, @PathVariable String buyerEmailld, 
			@PathVariable Integer newBidAmount) throws BidRequestNotValidException {
		boolean flag = true;
		
		ProductDetails productDetails = listingClient.showProductDetail(productId);
		LocalDate localDateNow = LocalDate.now(ZoneId.systemDefault());
		
		if(localDateNow.isAfter(productDetails.getBidEndDate())) {
			throw new BidRequestNotValidException("Sorry! You cannot update a bid after Bid End Date of the product");
		}
		
		return flag;
	}

}
