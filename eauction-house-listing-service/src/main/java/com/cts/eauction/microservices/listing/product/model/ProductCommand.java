package com.cts.eauction.microservices.listing.product.model;


import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "PRODUCT")
public class ProductCommand {
	
	@Field("productId")
	private Integer productId;
	@Field("productName")
	private String productName;
	@Field("shortDescription")
	private String shortDescription;
	@Field("detailedDescription")
	private String detailedDescription;
	@Field("category")
	private String category;
	@Field("startingPrice")
	private Integer startingPrice;
	@Field("bidEndDate")
	private LocalDate bidEndDate;
	@Field("sellerId")
	private Integer sellerId;

	public ProductCommand() {
	}

	public ProductCommand(Integer productId, String productName, String shortDescription, String detailedDescription, String category,
			Integer startingPrice, LocalDate bidEndDate, Integer sellerId) {
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
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bidEndDate == null) ? 0 : bidEndDate.hashCode());
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((detailedDescription == null) ? 0 : detailedDescription.hashCode());
		result = prime * result + ((productName == null) ? 0 : productName.hashCode());
		result = prime * result + ((sellerId == null) ? 0 : sellerId.hashCode());
		result = prime * result + ((shortDescription == null) ? 0 : shortDescription.hashCode());
		result = prime * result + ((startingPrice == null) ? 0 : startingPrice.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductCommand other = (ProductCommand) obj;
		if (bidEndDate == null) {
			if (other.bidEndDate != null)
				return false;
		} else if (!bidEndDate.equals(other.bidEndDate))
			return false;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (detailedDescription == null) {
			if (other.detailedDescription != null)
				return false;
		} else if (!detailedDescription.equals(other.detailedDescription))
			return false;
		if (productName == null) {
			if (other.productName != null)
				return false;
		} else if (!productName.equals(other.productName))
			return false;
		if (sellerId == null) {
			if (other.sellerId != null)
				return false;
		} else if (!sellerId.equals(other.sellerId))
			return false;
		if (shortDescription == null) {
			if (other.shortDescription != null)
				return false;
		} else if (!shortDescription.equals(other.shortDescription))
			return false;
		if (startingPrice == null) {
			if (other.startingPrice != null)
				return false;
		} else if (!startingPrice.equals(other.startingPrice))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ProductCommand [productId=" + productId + ", productName=" + productName + ", shortDescription="
				+ shortDescription + ", detailedDescription=" + detailedDescription + ", category=" + category
				+ ", startingPrice=" + startingPrice + ", bidEndDate=" + bidEndDate + ", sellerId=" + sellerId + "]";
	}

	
}
