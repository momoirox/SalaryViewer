package com.naovis.salaryviewer.services;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;

public interface AuthenticationService {

    /**
     * Method that builds JWT and serializes it to a compact, URL-safe string
     *
     * @param subject User identity
     * @return JWT string
     */
    String generateJwt(String subject);

    /**
     * Method that parses the claims from Authorization header
     *
     * @param authorizationHeader Bearer + jwt
     * @return claims form jwt
     */
    Jws<Claims> getClaims(String authorizationHeader);

    /**
     * Method that parses the Subject from Authorization header
     *
     * @param authorizationHeader Bearer + jwt
     * @return Suubject from jwt
     */
    String getSubject(String authorizationHeader);
}
