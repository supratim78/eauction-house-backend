package com.cts.eauction.microservices.gateway.model;

public class UserTokens {
	
	private final String accessToken;
	private final String refreshToken;
	
	public UserTokens(String accessToken, String refreshToken) {
		super();
		this.accessToken = accessToken;
		this.refreshToken = refreshToken;
	}
	
	public String getAccessToken() {
		return accessToken;
	}
	public String getRefreshToken() {
		return refreshToken;
	}
}
