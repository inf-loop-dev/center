package com.inf_loop_dev.center.config.auth;

import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtProvider {
	private static String jwtSecret = "wsdfhue918@#@!wwwew";
									  
	private static final Logger logger = LoggerFactory.getLogger(JwtProvider.class);
	private static int jwtExpirationMs = 0*(60*60*1000)+10*(60*1000);//시간, 분

	public String generateJwtToken(Authentication authentication) {
		String name = authentication.getName();
		return Jwts.builder()
				.setSubject(name)
				.setIssuedAt(new Date())
				.setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
				.signWith(SignatureAlgorithm.HS512, jwtSecret).compact();
	}

	public String getUserNameFromJwtToken(String token) {
		return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
	}
	public Date getExpirationaFromJwtToken(String token){ //add 2021-11-16
		return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getExpiration();
	}

	public String getRefreshJwtToken(String token) { //add 2021-11-17
		Claims jwt = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();
		return Jwts.builder()
				.setSubject(jwt.getSubject())
				.setIssuedAt(new Date())
				.setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
				.signWith(SignatureAlgorithm.HS512, jwtSecret).compact();
	}
	
	
	public boolean validateJwtToken(String authToken) {
		try {
			Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
			return true;
		}
		catch (SignatureException e) {
			logger.error("Invalid JWT signature: {}", e.getMessage());
		}
		catch (MalformedJwtException e) {
			logger.error("Invalid JWT token: {}", e.getMessage());
		} catch (ExpiredJwtException e) {
			logger.error("JWT token is expired: {}", e.getMessage());
		} catch (UnsupportedJwtException e) {
			logger.error("JWT token is unsupported: {}", e.getMessage());
		} catch (IllegalArgumentException e) {
			logger.error("JWT claims string is empty: {}", e.getMessage());
		}
		return false;
	}
}
