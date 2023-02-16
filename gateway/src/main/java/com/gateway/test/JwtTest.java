package com.gateway.test;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

public class JwtTest {
   @Test
   public void testCreateJwt() {
      JwtBuilder builder = Jwts.builder().setId("8989").setIssuer("csp1999").setSubject("JWT加密测试").setIssuedAt(new Date()).setExpiration(new Date(System.currentTimeMillis() + 180000L));
      Map<String, Object> userInfo = new HashMap();
      userInfo.put("username", "csp");
      userInfo.put("password", "123456");
      userInfo.put("school", "河南科技大学");
      userInfo.put("age", "22");
      builder.addClaims(userInfo);
      builder.signWith(SignatureAlgorithm.HS256, "haust");
      String jwtStr = builder.compact();
      System.out.println(jwtStr);
   }

   @Test
   public void testParseJwt() {
      String jwtStr = "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiI4OTg5IiwiaXNzIjoiY3NwMTk5OSIsInN1YiI6IkpXVOWKoOWvhua1i-ivlSIsImlhdCI6MTYxMTQ4ODc1MSwiZXhwIjoxNjExNDg4OTMxLCJwYXNzd29yZCI6IjEyMzQ1NiIsInNjaG9vbCI6Iuays-WNl-enkeaKgOWkp-WtpiIsImFnZSI6IjIyIiwidXNlcm5hbWUiOiJjc3AifQ.uH28G9MSHfzaKBAOyr8AdksYLVvy8O5P8g7TORZIUFY";
      Claims claims = (Claims)Jwts.parser().setSigningKey("haust").parseClaimsJws(jwtStr).getBody();
      System.out.println(claims);
   }
}
