package com.cts.eauction.microservices.seller.model;

import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import java.time.LocalDate;

import javax.validation.constraints.Email;

public class AddNewProductRequest {

	@NotNull(message = "Product name cannot be null") 
	@NotBlank(message = "Product name cannot be left blank")
	@Size(min = 5,max = 30, message = "Product name should be anything between 5 to 30 charachters")
	private String productName; 
	private String shortDescription;
	private String detailedDescription;
	private String category;
	
	@Positive(message = "Starting Positive should be a positive number")
	private Integer startingPrice;
	//@Future(message = "Bid End Date can only be a future date")
	private String bidEndDate;
	@Size(min = 5,max = 30, message = "First name should be anything between 5 to 30 charachters")
	private String firstName;
	@Size(min = 3,max = 25, message = "Last name should be anything between 3 to 25 charachters")
	private String lastName;
	private String Address;
	private String City;
	private String State;
	private String Pin;
	@NotNull(message = "Phone name cannot be null")
	@Size(min = 10, max = 10, message = "Phone should have only 10 numbers")
	//@Pattern(regexp = "^\\\\d{10}$", message = "Phone number should have only 10 numbers")
	private String Phone;
	@NotNull(message = "Email name cannot be null") 
	@Email(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$", message = "Email address should be a valid email address")
	private String Email;
	
	public AddNewProductRequest() {
	}

	public AddNewProductRequest(String productName, String shortDescription, String detailedDescription,
			String category, Integer startingPrice, String bidEndDate, String firstName, String lastName, String address,
			String city, String state, String pin, String phone, String email) {
		super();
		this.productName = productName;
		this.shortDescription = shortDescription;
		this.detailedDescription = detailedDescription;
		this.category = category;
		this.startingPrice = startingPrice;
		this.bidEndDate = bidEndDate;
		this.firstName = firstName;
		this.lastName = lastName;
		Address = address;
		City = city;
		State = state;
		Pin = pin;
		Phone = phone;
		Email = email;
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

	public String getBidEndDate() {
		return bidEndDate;
	}

	public void setBidEndDate(String bidEndDate) {
		this.bidEndDate = bidEndDate;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}

	public String getState() {
		return State;
	}

	public void setState(String state) {
		State = state;
	}

	public String getPin() {
		return Pin;
	}

	public void setPin(String pin) {
		Pin = pin;
	}

	public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		Phone = phone;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Address == null) ? 0 : Address.hashCode());
		result = prime * result + ((City == null) ? 0 : City.hashCode());
		result = prime * result + ((Email == null) ? 0 : Email.hashCode());
		result = prime * result + ((Phone == null) ? 0 : Phone.hashCode());
		result = prime * result + ((Pin == null) ? 0 : Pin.hashCode());
		result = prime * result + ((State == null) ? 0 : State.hashCode());
		result = prime * result + ((bidEndDate == null) ? 0 : bidEndDate.hashCode());
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((detailedDescription == null) ? 0 : detailedDescription.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((productName == null) ? 0 : productName.hashCode());
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
		AddNewProductRequest other = (AddNewProductRequest) obj;
		if (Address == null) {
			if (other.Address != null)
				return false;
		} else if (!Address.equals(other.Address))
			return false;
		if (City == null) {
			if (other.City != null)
				return false;
		} else if (!City.equals(other.City))
			return false;
		if (Email == null) {
			if (other.Email != null)
				return false;
		} else if (!Email.equals(other.Email))
			return false;
		if (Phone == null) {
			if (other.Phone != null)
				return false;
		} else if (!Phone.equals(other.Phone))
			return false;
		if (Pin == null) {
			if (other.Pin != null)
				return false;
		} else if (!Pin.equals(other.Pin))
			return false;
		if (State == null) {
			if (other.State != null)
				return false;
		} else if (!State.equals(other.State))
			return false;
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
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (productName == null) {
			if (other.productName != null)
				return false;
		} else if (!productName.equals(other.productName))
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
		return "AddNewProductRequest [productName=" + productName + ", shortDescription=" + shortDescription
				+ ", detailedDescription=" + detailedDescription + ", category=" + category + ", startingPrice="
				+ startingPrice + ", bidEndDate=" + bidEndDate + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", Address=" + Address + ", City=" + City + ", State=" + State + ", Pin=" + Pin + ", Phone=" + Phone
				+ ", Email=" + Email + "]";
	}
	
}
