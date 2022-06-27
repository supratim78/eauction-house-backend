package com.cts.eauction.microservices.seller.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Seller {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO,generator="native")
	@GenericGenerator(name = "native",strategy = "native")
	private Integer id;
	private String firstName;
	private String lastName;
	private String Address;
	private String City;
	private String State;
	private String Pin;
	private String Phone;
	private String Email;
	
	public Seller() {
	}

	public Seller(String firstName, String lastName, String address, String city, String state, String pin,
			String phone, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		Address = address;
		City = city;
		State = state;
		Pin = pin;
		Phone = phone;
		Email = email;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
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
		Seller other = (Seller) obj;
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
		return true;
	}

	@Override
	public String toString() {
		return "Seller [firstName=" + firstName + ", lastName=" + lastName + ", Address=" + Address + ", City=" + City
				+ ", State=" + State + ", Pin=" + Pin + ", Phone=" + Phone + ", Email=" + Email + "]";
	}
	
}
