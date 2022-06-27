package com.cts.eauction.microservices.auth.execption;

public class UserAlreadyExistWithThisEmail extends EauctionHouseException {

	public UserAlreadyExistWithThisEmail(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public UserAlreadyExistWithThisEmail(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

}
