package com.cts.eauction.microservices.seller.exception;

public class RequestNotValidException extends EauctionHouseException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RequestNotValidException(String message) {
		super(message);
	}

	public RequestNotValidException(String message, Throwable cause) {
		super(message, cause);
	}
	
	

}
