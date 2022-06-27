package com.cts.eauction.microservices.listing.model;

public class ProductDetailsByProductIdQuery {

	private Integer productId;

	public ProductDetailsByProductIdQuery() {
		
	}

	public ProductDetailsByProductIdQuery(Integer productId) {
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
