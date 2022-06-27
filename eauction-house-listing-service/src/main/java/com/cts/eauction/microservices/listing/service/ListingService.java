package com.cts.eauction.microservices.listing.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.eauction.microservices.listing.model.BidDetails;
import com.cts.eauction.microservices.listing.model.BidsPlacedForAProductByBuyerQuery;
import com.cts.eauction.microservices.listing.model.BidsPlacedForAProductQuery;
import com.cts.eauction.microservices.listing.model.BidsReceivedOnProductQuery;
import com.cts.eauction.microservices.listing.model.Listing;
import com.cts.eauction.microservices.listing.model.ProductDetails;
import com.cts.eauction.microservices.listing.model.ProductDetailsByProductIdQuery;
import com.cts.eauction.microservices.listing.repository.ListingProjection;

@Service
public class ListingService {
	
	@Autowired
	private ListingProjection projection;

	public ListingService() {
		
	}

	public ListingService(ListingProjection projection) {
		super();
		this.projection = projection;
	}
	
	public Listing listAllBidsByProductBySeller(BidsReceivedOnProductQuery query) {
		Listing listing = projection.handle(query);
		return listing;
	}
	
	public ProductDetails showProductDetail(ProductDetailsByProductIdQuery query) {
		ProductDetails productDetails = projection.showProductDetail(query);
		return productDetails;
	}
	
	public BidDetails showBids(BidsPlacedForAProductByBuyerQuery query) {
		BidDetails bidDetails = projection.showBids(query);
		return bidDetails;
	}
	
	public List<BidDetails> showBids(BidsPlacedForAProductQuery query) {
		List<BidDetails> bidDetails = projection.showBids(query);
		return bidDetails;
	}

}
