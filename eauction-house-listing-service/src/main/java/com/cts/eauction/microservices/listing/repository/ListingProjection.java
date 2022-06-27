package com.cts.eauction.microservices.listing.repository;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cts.eauction.microservices.listing.model.BidDetails;
import com.cts.eauction.microservices.listing.model.BidsPlacedForAProductByBuyerQuery;
import com.cts.eauction.microservices.listing.model.BidsPlacedForAProductQuery;
import com.cts.eauction.microservices.listing.model.BidsReceivedOnProductQuery;
import com.cts.eauction.microservices.listing.model.Listing;
import com.cts.eauction.microservices.listing.model.ProductDetails;
import com.cts.eauction.microservices.listing.model.ProductDetailsByProductIdQuery;
import org.springframework.data.domain.Sort;

@Component
public class ListingProjection {
	
	private static final Logger LOG = LoggerFactory.getLogger(ListingProjection.class);
	
	@Autowired
	private ProductReadRepository productRepository;
	
	@Autowired
	private BidReadRepository bidRepository;

	public ListingProjection() {
		
	}

	public ListingProjection(ProductReadRepository productRepository, BidReadRepository bidRepository) {
		super();
		this.productRepository = productRepository;
		this.bidRepository = bidRepository;
	}

	public Listing handle(BidsReceivedOnProductQuery query) {
		ProductDetails productDetails = productRepository.findByProductId(query.getProductId());
		LOG.info("Products obtained from database " + productDetails);
		List<BidDetails> bids = bidRepository.findByProductId(query.getProductId(),Sort.by(Sort.Direction.DESC, "bidAmount"));
		Listing listing = new Listing(productDetails.getProductId(), productDetails.getProductName(), productDetails.getShortDescription(), productDetails.getDetailedDescription(), 
				productDetails.getCategory(), productDetails.getStartingPrice(), 
				productDetails.getBidEndDate(), bids);
		return listing;
	}
	
	public ProductDetails showProductDetail(ProductDetailsByProductIdQuery query) {
		ProductDetails productDetails = productRepository.findByProductId(query.getProductId());
		LOG.info("Products obtained from database " + productDetails);
		return productDetails;
	}
	
	public BidDetails showBids(BidsPlacedForAProductByBuyerQuery query) {
		BidDetails bidDetails = bidRepository.findByProductIdAndBuyerId(query.getProductId(), query.getBuyerId());
		LOG.info("Bids obtained from database " + bidDetails);
		return bidDetails;
	}
	
	public List<BidDetails> showBids(BidsPlacedForAProductQuery query) {
		List<BidDetails> bidDetails = bidRepository.findByProductId(query.getProductId(), Sort.by(Sort.Direction.DESC, "bidAmount"));
		LOG.info("Bids obtained from database " + bidDetails);
		return bidDetails;
	}
}
