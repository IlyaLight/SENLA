package com.senla.back.controller.util;

import com.nimbusds.jose.JWSSigner;
import com.nimbusds.jose.KeyLengthException;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jwt.JWTClaimsSet;
import com.senla.api.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class TokenUtil {
    private static final Integer EXPIRATION = 100;
    private static final String KEY = "6FD3AD557E758A8B54BE1A676A5D6";
    private static final Logger LOGGER = LoggerFactory.getLogger(TokenUtil.class);


    public static String  getToken(User user){
        try {
            JWSSigner signer = new MACSigner(KEY);
        } catch (KeyLengthException e) {
            LOGGER.error(e.getMessage());
        }
        JWTClaimsSet claimsSet = new JWTClaimsSet.Builder()

//        Map<String, Object> tokenData = new HashMap<>();
//        tokenData.put("userID", user.getId().toString());
//        Calendar calendar = Calendar.getInstance();
//        calendar.add(Calendar.HOUR, EXPIRATION);
//        JwtBuilder jwtBuilder = Jwts.builder();
//        jwtBuilder.setExpiration(calendar.getTime());
//        jwtBuilder.setClaims(tokenData);
//        return jwtBuilder.signWith(SignatureAlgorithm.HS512, KEY).compact();

        return null;

    }
}
