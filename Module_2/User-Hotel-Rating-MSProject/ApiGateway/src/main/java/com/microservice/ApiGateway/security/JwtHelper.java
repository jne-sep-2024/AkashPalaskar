package com.microservice.ApiGateway.security;


import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.function.Function;

@Component
public class JwtHelper {

    //requirement :
    public static final long JWT_TOKEN_VALIDITY = 20 * 60;  //token will expire in 20 min

    //public static final long JWT_TOKEN_VALIDITY =  60;
    @Value("${jwt.secret}")
    private String secret ;


    //for retrieveing any information from token we will need the secret key
    public Claims getAllClaimsFromToken(String token) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
    }


    public Key getSignKey() {
        byte[] keyBytes = Decoders.BASE64.decode(secret);
        return Keys.hmacShaKeyFor(keyBytes);
    }


    public Jws<Claims> valiDateToken(final String token) {
        try {
            return Jwts.parserBuilder()
                    .setSigningKey(getSignKey())
                    .build()
                    .parseClaimsJws(token);
        } catch (ExpiredJwtException e) {
            System.out.println("Token is expired");
            throw e; // Re-throw or handle the expired token case
        } catch (MalformedJwtException e) {
            System.out.println("Token is malformed");
            throw e; // Re-throw or handle the malformed token case
        } catch (Exception e) {
            System.out.println("Token validation error: " + e.getMessage());
            throw e; // Re-throw or handle the generic validation error case
        }
    }
}