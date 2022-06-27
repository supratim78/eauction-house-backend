package com.cts.eauction.microservices.auth.execption;

public class EauctionHouseException extends RuntimeException {

	public EauctionHouseException(String message, Throwable cause) {
		super(message, cause);
	}

	public EauctionHouseException(String message) {
		super(message);
	}

	

}
