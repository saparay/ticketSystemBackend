package com.demo.api.jwt;

import java.security.Key;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.demo.api.entity.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtTokenProvider {
	@Value("${app.jwt-secret}")
	private String jwtSecret;
	@Value("${app-jwt-expiration-milliseconds}")
	private long jwtExpirationDate;
	
	public String generateToken(Authentication authentication) {
		String username = authentication.getName();
		Date currentDate = new Date();
		Date expireDate = new Date(currentDate.getTime()+jwtExpirationDate);
		String token = Jwts.builder().setSubject(username)
						.setIssuedAt(new Date())
						.setExpiration(expireDate)
						.claim(username, authentication.getAuthorities())
						.signWith(key())
						.compact();
		//System.out.println(getRole(authentication));
		return token;
	}

	private Key key() {
		return Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecret));
	}
	
	public String getUsername(String token) {
		Claims claims = Jwts.parserBuilder()
						.setSigningKey(key())
						.build()
						.parseClaimsJws(token)
						.getBody();
		
		String username = claims.getSubject();
		return username;
	}
	
	public String getRole(Authentication authentication) {
		return authentication.getAuthorities().toString();
	}
	
	public boolean validateToken(String token) {
		Jwts.parserBuilder()
			.setSigningKey(key())
			.build()
			.parse(token);
		return true;
	}
}
