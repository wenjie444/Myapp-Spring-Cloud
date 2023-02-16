package com.wallpaperadmin.utlis;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Base64;
import java.util.Date;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class JwtUtil {
   public static final Long JWT_TTL = 3600000L;
   public static final String JWT_KEY = "itcast";

   public static String createJWT(String id, String subject, Long ttlMillis) {
      SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
      long nowMillis = System.currentTimeMillis();
      Date now = new Date(nowMillis);
      if (ttlMillis == null) {
         ttlMillis = JWT_TTL;
      }

      long expMillis = nowMillis + ttlMillis;
      Date expDate = new Date(expMillis);
      SecretKey secretKey = generalKey();
      JwtBuilder builder = Jwts.builder().setId(id).setSubject(subject).setIssuer("admin").setIssuedAt(now).signWith(signatureAlgorithm, secretKey).setExpiration(expDate);
      return builder.compact();
   }

   public static SecretKey generalKey() {
      byte[] encodedKey = Base64.getEncoder().encode("itcast".getBytes());
      SecretKey key = new SecretKeySpec(encodedKey, 0, encodedKey.length, "AES");
      return key;
   }

   public static Claims parseJWT(String jwt) throws Exception {
      SecretKey secretKey = generalKey();
      return (Claims)Jwts.parser().setSigningKey(secretKey).parseClaimsJws(jwt).getBody();
   }
}
