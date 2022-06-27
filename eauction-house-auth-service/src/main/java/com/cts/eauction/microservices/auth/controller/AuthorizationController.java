package com.cts.eauction.microservices.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cts.eauction.microservices.auth.execption.InvalidLoginCredentialException;
import com.cts.eauction.microservices.auth.execption.UserAlreadyExistWithThisEmail;
import com.cts.eauction.microservices.auth.model.User;
import com.cts.eauction.microservices.auth.model.UserTokens;
import com.cts.eauction.microservices.auth.service.UserService;
import com.cts.eauction.microservices.auth.util.JwtUtil;

@RestController
@RequestMapping("/e-auction/api/v1/user")
public class AuthorizationController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private JwtUtil jwtUtil;
	
	@PostMapping(path = "/register-user", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody UserTokens registerUser(@RequestBody User user) throws UserAlreadyExistWithThisEmail {
		
		User userWithSameEmail = null;
		
		userWithSameEmail = userService.findByEmail(user);
		
		if(userWithSameEmail != null) {
			throw new UserAlreadyExistWithThisEmail("User is already registered with same email");
		}
		
		user = userService.registerUser(user);
		final String accessToken = jwtUtil.generateAccessToken(user);
		final String refreshToken = jwtUtil.generateRefreshToken(user);
		
		UserTokens tokens = new UserTokens(accessToken, refreshToken);
		
		return tokens;
		
	}
	
	@PostMapping(path = "/login", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody UserTokens login(@RequestBody User user) throws InvalidLoginCredentialException {
		user = userService.login(user);
		
		if(user == null) {
			throw new InvalidLoginCredentialException("User name or password is not valid");
		}
		
		final String accessToken = jwtUtil.generateAccessToken(user);
		final String refreshToken = jwtUtil.generateRefreshToken(user);
		
		UserTokens tokens = new UserTokens(accessToken, refreshToken);
		
		return tokens;
		
	}
	
	

}
