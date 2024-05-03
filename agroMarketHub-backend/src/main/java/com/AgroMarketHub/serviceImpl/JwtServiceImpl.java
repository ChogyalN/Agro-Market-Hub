package com.AgroMarketHub.serviceImpl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtServiceImpl {

	@Value("${jwt.secret}")
	private String SECRET;

	public String generateToke(String userName) {
		Map<String, Object> claims = new HashMap<>();
		return createToken(claims, userName);
	}

	private String createToken(Map<String, Object> claims, String userName) {
		// TODO Auto-generated method stub
		return Jwts.builder().setClaims(claims).setSubject(userName).setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 30)) // 30 minutes
				.signWith(SignatureAlgorithm.HS256, SECRET).compact();
	}

	private Object getSignKey() {
		byte[] keyByte = Decoders.BASE64.decode(SECRET);
		return Keys.hmacShaKeyFor(keyByte);
	}

	public String extractUsername(String token) {
        return extractClaims(token).getSubject();
    }


	public boolean validateToken(String token) {
		return !extractClaims(token).getExpiration().before(new Date());
	}

	private Claims extractClaims(String token) {
		try {
			if (StringUtils.hasText(token)) {
				return Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token).getBody();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
