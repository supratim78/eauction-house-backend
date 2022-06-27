package com.cts.eauction.microservices.listing.model;

public class BidsPlacedForAProductQuery {

	private Integer productId;
	
	public BidsPlacedForAProductQuery() {
		
	}

	public BidsPlacedForAProductQuery(Integer productId) {
		super();
		this.productId = productId;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}
}
