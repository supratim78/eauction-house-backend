package com.cts.eauction.microservices.listing.model;

public class BidsReceivedOnProductQuery {

	private Integer productId;
	
	
	public BidsReceivedOnProductQuery() {
		
	}

	public BidsReceivedOnProductQuery(Integer productId) {
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
