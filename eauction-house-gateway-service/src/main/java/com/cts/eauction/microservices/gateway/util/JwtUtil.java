package com.cts.eauction.microservices.gateway.util;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.cts.eauction.microservices.gateway.exception.JwtTokenMalformedException;
import com.cts.eauction.microservices.gateway.exception.JwtTokenMissingException;
import com.cts.eauction.microservices.gateway.model.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.ExpiredJwtException;

@Component
public class JwtUtil {

	@Value("${jwt.secret}")
	private String jwtSecret;

	@Value("${jwt.token.accessToken.validity}")
	private long accessTokenValidity;

	@Value("${jwt.token.refreshToken.validity}")
	private long refreshTokenValidity;

	public Claims getClaims(final String token) {
		try {
			Claims body = Jwts.parser()
					.setSigningKey(jwtSecret)
					.parseClaimsJws(token)
					.getBody();
			return body;
		} catch (Exception e) {
			System.out.println(e.getMessage() + " => " + e);
		}
		return null;
	}

	public String generateAccessToken(User user) {

		/*
		 * accessTokenValidity = 5 * 60 * 1000; refreshTokenValidity = 30 * 24 * 60 * 60
		 * * 1000;
		 */

		Claims claims = Jwts.claims().setSubject(user.getType());
		long nowMillis = System.currentTimeMillis();
		long expMillis = nowMillis + accessTokenValidity;
		Date accessTokenExp = new Date(expMillis);
		return Jwts.builder().setSubject(user.getEmail())
				.setIssuer("Eauction-Auth-Service")
				.setClaims(claims)
				.setIssuedAt(new Date(nowMillis))
				.setExpiration(accessTokenExp)
				.signWith(SignatureAlgorithm.HS512, jwtSecret)
				.compact();
	}

	public String generateRefreshToken(User user) {

		/* refreshTokenValidity = 30 * 24 * 60 * 60 * 1000; */
		long nowMillis = System.currentTimeMillis();
		long expMillis = nowMillis + refreshTokenValidity;
		Date refreshTokenExp = new Date(expMillis);
		return Jwts.builder().setSubject(user.getEmail())
				.setIssuer("Eauction-Auth-Service")
				.setIssuedAt(new Date(nowMillis))
				.setExpiration(refreshTokenExp)
				.signWith(SignatureAlgorithm.HS512, jwtSecret)
				.compact();
	}

	public void validateToken(final String token) throws JwtTokenMalformedException, JwtTokenMissingException {
		try {
			Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token);
		} catch (SignatureException ex) {
			throw new JwtTokenMalformedException("Invalid JWT signature");
		} catch (MalformedJwtException ex) {
			throw new JwtTokenMalformedException("Invalid JWT token");
		} catch (ExpiredJwtException ex) {
			throw new JwtTokenMalformedException("Expired JWT token");
		} catch (UnsupportedJwtException ex) {
			throw new JwtTokenMalformedException("Unsupported JWT token");
		} catch (IllegalArgumentException ex) {
			throw new JwtTokenMissingException("JWT claims string is empty.");
		}
	}

}
