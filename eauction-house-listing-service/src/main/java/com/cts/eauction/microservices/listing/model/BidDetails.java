package com.cts.eauction.microservices.listing.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "BID")
public class BidDetails {

	@Id
	private Integer id;
	@Field("productId")
	private Integer productId;
	@Field("bidAmount")
	private Integer bidAmount;
	@Field("buyerId")
	private Integer buyerId;
	@Field("buyerName")
	private String buyerName;
	@Field("buyerPhone")
	private String buyerPhone;
	@Field("buyerEmail")
	private String buyerEmail;

	public BidDetails() {

	}

	public BidDetails(Integer id, Integer productId, Integer bidAmount, Integer buyerId, String buyerName,
			String buyerPhone, String buyerEmail) {
		super();
		this.id = id;
		this.productId = productId;
		this.bidAmount = bidAmount;
		this.buyerId = buyerId;
		this.buyerName = buyerName;
		this.buyerPhone = buyerPhone;
		this.buyerEmail = buyerEmail;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Integer getBidAmount() {
		return bidAmount;
	}

	public void setBidAmount(Integer bidAmount) {
		this.bidAmount = bidAmount;
	}

	public Integer getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(Integer buyerId) {
		this.buyerId = buyerId;
	}
	
	public String getBuyerName() {
		return buyerName;
	}

	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}

	public String getBuyerPhone() {
		return buyerPhone;
	}

	public void setBuyerPhone(String buyerPhone) {
		this.buyerPhone = buyerPhone;
	}

	public String getBuyerEmail() {
		return buyerEmail;
	}

	public void setBuyerEmail(String buyerEmail) {
		this.buyerEmail = buyerEmail;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bidAmount == null) ? 0 : bidAmount.hashCode());
		result = prime * result + ((buyerEmail == null) ? 0 : buyerEmail.hashCode());
		result = prime * result + ((buyerId == null) ? 0 : buyerId.hashCode());
		result = prime * result + ((buyerName == null) ? 0 : buyerName.hashCode());
		result = prime * result + ((buyerPhone == null) ? 0 : buyerPhone.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((productId == null) ? 0 : productId.hashCode());
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
		BidDetails other = (BidDetails) obj;
		if (bidAmount == null) {
			if (other.bidAmount != null)
				return false;
		} else if (!bidAmount.equals(other.bidAmount))
			return false;
		if (buyerEmail == null) {
			if (other.buyerEmail != null)
				return false;
		} else if (!buyerEmail.equals(other.buyerEmail))
			return false;
		if (buyerId == null) {
			if (other.buyerId != null)
				return false;
		} else if (!buyerId.equals(other.buyerId))
			return false;
		if (buyerName == null) {
			if (other.buyerName != null)
				return false;
		} else if (!buyerName.equals(other.buyerName))
			return false;
		if (buyerPhone == null) {
			if (other.buyerPhone != null)
				return false;
		} else if (!buyerPhone.equals(other.buyerPhone))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (productId == null) {
			if (other.productId != null)
				return false;
		} else if (!productId.equals(other.productId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BidDetails [id=" + id + ", productId=" + productId + ", bidAmount=" + bidAmount + ", buyerId=" + buyerId
				+ ", buyerName=" + buyerName + ", buyerPhone=" + buyerPhone + ", buyerEmail=" + buyerEmail + "]";
	}
}
