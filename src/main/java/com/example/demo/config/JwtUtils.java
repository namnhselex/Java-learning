package com.example.demo.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtils {
    private final String SECRET_KEY = "secret";
    private final long EXPIRATION = 1000 * 60 * 60 * 10; //expiration in 10 hours
    public Long getUserIdFromJwtToken(String token) {
        Claims claims = extractAllClaims(token);
        return Long.parseLong(claims.getSubject());
    }

    public Date getExpirationDateFromJwtToken(String token) {
        return extractAllClaims(token).getExpiration();
    }


    private Claims extractAllClaims(String token) {
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
    }

    private Boolean isTokenExpired(String token) {
        final Date expiration = getExpirationDateFromJwtToken(token);
        return expiration.before(new Date());
    }

    public String generateToken(Long id) {
        return Jwts.builder()
                .setSubject(id.toString())
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + EXPIRATION))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }

    public boolean validateToken(String token, Long id) {
        final Long userId = getUserIdFromJwtToken(token);
        return (userId.equals(id) && !isTokenExpired(token));
    }

}
