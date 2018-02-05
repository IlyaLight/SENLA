package com.senla.back.controller.util;

import com.senla.api.model.User;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class TokenUtil {
    private static final Integer EXPIRATION = 100;
    private static final String KEY = "abc123";

    public static String  getToken(User user){
        Map<String, Object> tokenData = new HashMap<>();
        tokenData.put("userID", user.getId().toString());
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.HOUR, EXPIRATION);
        JwtBuilder jwtBuilder = Jwts.builder();
        jwtBuilder.setExpiration(calendar.getTime());
        jwtBuilder.setClaims(tokenData);
        return jwtBuilder.signWith(SignatureAlgorithm.HS512, KEY).compact();

    }
}
