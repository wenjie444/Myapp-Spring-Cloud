package com.wallpaperadmin.utlis;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator.Builder;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JWTUtils {
   private static final String SIGN = "123";

   public static void main(String[] args) {
      HashMap<String, String> map = new HashMap();
      map.put("username", "张三");
      String token1 = getToken(map);
      System.out.println("name = " + token1);
   }

   public static String getToken(Map<String, String> map) {
      Calendar instance = Calendar.getInstance();
      instance.add(5, 7);
      Builder builder = JWT.create();
      map.forEach((k, v) -> {
         builder.withClaim(k, v);
      });
      String token = builder.withExpiresAt(instance.getTime()).sign(Algorithm.HMAC256("123"));
      return token;
   }

   public static void verify(String token) {
      JWT.require(Algorithm.HMAC256("123")).build().verify(token);
   }

   public static DecodedJWT getTokenInfo(String token) {
      DecodedJWT verify = JWT.require(Algorithm.HMAC256("123")).build().verify(token);
      return verify;
   }

   public boolean isTokenExpired(Date expiration) {
      return expiration.before(new Date());
   }
}
