package com.cts.eauction.microservices.listing.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cts.eauction.microservices.listing.exception.ProductNotFoundException;
import com.cts.eauction.microservices.listing.model.BidDetails;
import com.cts.eauction.microservices.listing.model.BidsPlacedForAProductByBuyerQuery;
import com.cts.eauction.microservices.listing.model.BidsPlacedForAProductQuery;
import com.cts.eauction.microservices.listing.model.BidsReceivedOnProductQuery;
import com.cts.eauction.microservices.listing.model.Listing;
import com.cts.eauction.microservices.listing.model.ProductDetails;
import com.cts.eauction.microservices.listing.model.ProductDetailsByProductIdQuery;
import com.cts.eauction.microservices.listing.service.ListingService;

@RestController
@RequestMapping("/e-auction/api/v1/seller")
public class ListingController {
	
	private static final Logger LOG = LoggerFactory.getLogger(ListingController.class);
	
	@Autowired
	private ListingService service;
	
	@GetMapping(path = "/show-bids/{productId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Listing listAllBidsForAProduct(@PathVariable String productId) {
		Integer productIdInQuery = Integer.parseInt(productId);
		LOG.info("productIdInQuery=" + productIdInQuery);
		BidsReceivedOnProductQuery query = new BidsReceivedOnProductQuery(productIdInQuery);
		Listing listing = service.listAllBidsByProductBySeller(query);
		return listing;
		
	}
	
	@GetMapping(path = "/show-product/{productId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ProductDetails showProductDetail(@PathVariable Integer productId) {
		Integer productIdInQuery = productId;
		LOG.info("productIdInQuery=" + productIdInQuery);
		ProductDetailsByProductIdQuery query = new ProductDetailsByProductIdQuery(productIdInQuery);
		ProductDetails productDetails = service.showProductDetail(query);
		return productDetails;
		
	}
	
	@GetMapping(path = "/show-bids/{productId}/{buyerId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody BidDetails showBidsOfAProductForABuyer(@PathVariable Integer productId, @PathVariable Integer buyerId) {
		
		BidsPlacedForAProductByBuyerQuery query = new BidsPlacedForAProductByBuyerQuery(productId,buyerId);
		BidDetails bidDetails = service.showBids(query);
		return bidDetails;
		
	}
	
	@GetMapping(path = "/get-bids/{productId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<BidDetails> showBidsOfAProduct(@PathVariable Integer productId) {
		
		BidsPlacedForAProductQuery query = new BidsPlacedForAProductQuery(productId);
		List<BidDetails> bidDetails = service.showBids(query);
		return bidDetails;
		
	}

}
