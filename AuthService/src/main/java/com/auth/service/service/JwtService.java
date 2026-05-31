package com.auth.service.service;

import java.security.Key;
import java.util.Date;

import org.springframework.stereotype.Service;
import com.auth.service.AuthServiceApplication;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;


@Service
public class JwtService {

    private final AuthServiceApplication authServiceApplication;
          
	private static final String SECRET = "khuljaasimsimkhuljaasimsimkhuljaasimsimkhuljaasimsim";
	
	private final Key key = Keys.hmacShaKeyFor(SECRET.getBytes());

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
}
