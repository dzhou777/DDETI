package com.example.demo.jwtutils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
@Component
public class TokenManager implements Serializable {

    private static final long serialVersionUID = 7008375124389347049L;

    public static final long TOKEN_VALIDITY = 10 * 60 * 60; @Value("${secret}")

    private String jwtSecret;

    public String generateJwtToken(UserDetails userDetails) {
        var claims = new HashMap<String, Object>();
        return Jwts.builder()
            .setClaims(claims)
            .setSubject(userDetails.getUsername())
            .setIssuedAt(new Date(System.currentTimeMillis()))
            .setExpiration(new Date(System.currentTimeMillis() + TOKEN_VALIDITY * 1000))
            .signWith(SignatureAlgorithm.HS512, jwtSecret).compact();
    }
    public Boolean validateJwtToken(String token, UserDetails userDetails) {
        var username = getUsernameFromToken(token);
        var claims = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();
        var isTokenExpired = claims.getExpiration().before(new Date());
        return (username.equals(userDetails.getUsername()) && !isTokenExpired);
    }
    public String getUsernameFromToken(String token) {
        final var claims = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();
        return claims.getSubject();
    }

}