package com.cts.eauction.events;

public class BidEvent extends Event{
	
	private Integer bidId;
	private Integer productId;
	private Integer bidAmount;
	private Integer buyerId;
	private String buyerName;
	private String buyerPhone;
	private String buyerEmail;

	public BidEvent() {

	}
	
	public BidEvent(Integer bidId, Integer productId, Integer bidAmount, Integer buyerId, String eventType, String buyerName,
			String buyerPhone, String buyerEmail) {
		
		super(eventType);
		this.bidId = bidId;
		this.productId = productId;
		this.bidAmount = bidAmount;
		this.buyerId = buyerId;
		this.buyerName = buyerName;
		this.buyerPhone = buyerPhone;
		this.buyerEmail = buyerEmail;
	}
	
	public Integer getBidId() {
		return bidId;
	}

	public void setBidId(Integer bidId) {
		this.bidId = bidId;
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
		result = prime * result + ((bidId == null) ? 0 : bidId.hashCode());
		result = prime * result + ((buyerId == null) ? 0 : buyerId.hashCode());
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
		BidEvent other = (BidEvent) obj;
		if (bidAmount == null) {
			if (other.bidAmount != null)
				return false;
		} else if (!bidAmount.equals(other.bidAmount))
			return false;
		if (bidId == null) {
			if (other.bidId != null)
				return false;
		} else if (!bidId.equals(other.bidId))
			return false;
		if (buyerId == null) {
			if (other.buyerId != null)
				return false;
		} else if (!buyerId.equals(other.buyerId))
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
		return "BidEvent [bidId=" + bidId + ", productId=" + productId + ", bidAmount=" + bidAmount + ", buyerId="
				+ buyerId + ", buyerName=" + buyerName + ", buyerPhone=" + buyerPhone + ", buyerEmail=" + buyerEmail
				+ "]";
	}
}
