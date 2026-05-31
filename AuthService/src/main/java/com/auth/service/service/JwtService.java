package com.auth.service.service;



import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Service;
import com.auth.service.AuthServiceApplication;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;


@Service
public class JwtService {

    private final AuthServiceApplication authServiceApplication;
          
	private static final String SECRET = "khuljaasimsimkhuljaasimsimkhuljaasimsimkhuljaasimsim";
	
	private final SecretKey key = Keys.hmacShaKeyFor(SECRET.getBytes());

    JwtService(AuthServiceApplication authServiceApplication) {
        this.authServiceApplication = authServiceApplication;
    }
	
	public String generateToken(String username) {
		return Jwts.builder()
				.subject(username)
				.issuedAt(new Date())
				.expiration(new Date(System.currentTimeMillis() + 3600000))
				.signWith(key)
				.compact();
	}
	
	public boolean validateToken(String token) {

	    try {
	    	Jwts.parser()
	    	.verifyWith(key)
            .build()
            .parseSignedClaims(token);

	        return true;

	    } catch (Exception e) {
	        return false;
	    }
	}
	
	public String extractUsername(String token) {

	    return Jwts.parser()
	            .verifyWith(key)
	            .build()
	            .parseSignedClaims(token)
	            .getPayload()
	            .getSubject();
	}
	
}
