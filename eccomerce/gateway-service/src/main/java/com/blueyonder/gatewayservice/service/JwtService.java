package com.blueyonder.gatewayservice.service;

import java.security.Key;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtService {
	 public static final String SECRET = "5367566B59703373367639792F423F4528482B4D6251655468576D5A71347437";


	  
		public void validateToken(final String token) {
	        Jwts.parser().verifyWith(getSignKey()).build().parseSignedClaims(token).getPayload();
	        
	    }



	    private SecretKey getSignKey() {
	        byte[] keyBytes = Decoders.BASE64.decode(SECRET);
	        return Keys.hmacShaKeyFor(keyBytes);
	    }
}
