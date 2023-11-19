package com.naovis.salaryviewer.services;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    private String SECRET_KEY = "Welcome2DevelopmentXXXXWelcome2DevelopmentX";

    @Override
    public String generateJwt(String subject) {

        long nowMills = System.currentTimeMillis();
        Date now = new Date(nowMills);

        JwtBuilder builder = Jwts.builder()
                .setIssuedAt(now)
                .setSubject(subject)
                .signWith(Keys.hmacShaKeyFor(SECRET_KEY.getBytes()))
                .setExpiration(new Date(nowMills + 15 * 60 * 1000));
        return builder.compact();

    }

    @Override
    public Jws<Claims> getClaims(String authorizationHeader) {
        String jwt = authorizationHeader.substring(6);
        return Jwts.parserBuilder().setSigningKey(Keys.hmacShaKeyFor(SECRET_KEY.getBytes())).build().parseClaimsJws(jwt);
    }

    @Override
    public String getSubject(String authorizationHeader) {
        Jws<Claims> claims = getClaims(authorizationHeader);
        return claims.getBody().getSubject();

    }
}
