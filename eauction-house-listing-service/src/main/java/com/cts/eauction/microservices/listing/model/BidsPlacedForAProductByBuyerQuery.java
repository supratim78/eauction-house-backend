package com.cts.eauction.microservices.listing.model;

public class BidsPlacedForAProductByBuyerQuery {

	private Integer productId;
	
	private Integer buyerId;
	
	
	public BidsPlacedForAProductByBuyerQuery() {
		
	}

	public BidsPlacedForAProductByBuyerQuery(Integer productId, Integer buyerId) {
		super();
		this.productId = productId;
		this.buyerId = buyerId;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	
	public Integer getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(Integer buyerId) {
		this.buyerId = buyerId;
	}
}
