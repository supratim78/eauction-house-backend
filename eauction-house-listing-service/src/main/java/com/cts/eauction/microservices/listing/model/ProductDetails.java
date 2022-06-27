package com.cts.eauction.microservices.listing.model;

import java.time.LocalDate;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "PRODUCT")
public class ProductDetails {

	private Integer productId;
	private String productName;
	private String shortDescription;
	private String detailedDescription;
	private String category;
	private Integer startingPrice;
	private LocalDate bidEndDate;
	private Integer sellerId;
	
	public ProductDetails() {
		
	}

	public ProductDetails(Integer productId, String productName, String shortDescription, String detailedDescription, String category, Integer startingPrice,
			LocalDate bidEndDate, Integer sellerId) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.shortDescription = shortDescription;
		this.detailedDescription = detailedDescription;
		this.category = category;
		this.startingPrice = startingPrice;
		this.bidEndDate = bidEndDate;
		this.sellerId = sellerId;
	}
	
	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	
	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getDetailedDescription() {
		return detailedDescription;
	}

	public void setDetailedDescription(String detailedDescription) {
		this.detailedDescription = detailedDescription;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Integer getStartingPrice() {
		return startingPrice;
	}

	public void setStartingPrice(Integer startingPrice) {
		this.startingPrice = startingPrice;
	}

	public LocalDate getBidEndDate() {
		return bidEndDate;
	}

	public void setBidEndDate(LocalDate bidEndDate) {
		this.bidEndDate = bidEndDate;
	}

	public Integer getSellerId() {
		return sellerId;
	}

	public void setSellerId(Integer sellerId) {
		this.sellerId = sellerId;
	}
}
