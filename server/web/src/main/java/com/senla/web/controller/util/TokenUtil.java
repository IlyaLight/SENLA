package com.senla.web.controller.util;

import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import com.senla.api.model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

public class TokenUtil {
    private static final Integer EXPIRATION = 100;
    private static final String KEY = "6FD3AD557E758A8B54BE1A676A5D66A5D6";
    private static final String SECURITY = "security";
    private static final String ID = "id";

    private static final Logger LOGGER = LoggerFactory.getLogger(TokenUtil.class);

    public static String  getToken(Person person){
        try {
            JWSSigner signer  = new MACSigner(KEY);
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.HOUR, EXPIRATION);
            JWTClaimsSet claimsSet = new JWTClaimsSet.Builder()
                .subject(SECURITY)
                .expirationTime(calendar.getTime())
                .claim(ID, person.getId())
                .build();
            SignedJWT signedJWT = new SignedJWT(new JWSHeader(JWSAlgorithm.HS256), claimsSet);
            signedJWT.sign(signer);
            String token = signedJWT.serialize();
            return token;
        } catch (JOSEException e) {
            LOGGER.error(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public static Long checkToken(String token) {
        try {
            SignedJWT signedJWT = SignedJWT.parse(token);
            JWSVerifier verifier = new MACVerifier(KEY);
            Boolean verify = signedJWT.verify(verifier);
            Date date = (Date)signedJWT.getJWTClaimsSet().getExpirationTime();
            if (date.after(new Date()) && verify.equals(true)) {
                return (Long)signedJWT.getJWTClaimsSet().getClaim(ID);
            }
        } catch (ParseException|JOSEException e) {
            LOGGER.error(e.getMessage());
        }
        return null;
    }
}
