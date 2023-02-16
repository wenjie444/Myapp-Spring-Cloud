package com.wallpaperadmin.utlis;

import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;

public class JWTInterceptor implements HandlerInterceptor {
   public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
      String token = request.getHeader("token");
      HashMap map = new HashMap();

      try {
         JWTUtils.verify(token);
         return true;
      } catch (TokenExpiredException var7) {
         map.put("state", false);
         map.put("msg", "Token已经过期!!!");
      } catch (SignatureVerificationException var8) {
         map.put("state", false);
         map.put("msg", "签名错误!!!");
      } catch (AlgorithmMismatchException var9) {
         map.put("state", false);
         map.put("msg", "加密算法不匹配!!!");
      } catch (Exception var10) {
         var10.printStackTrace();
         map.put("state", false);
         map.put("msg", "无效token~~");
      }

      String json = (new ObjectMapper()).writeValueAsString(map);
      response.setContentType("application/json;charset=UTF-8");
      response.getWriter().println(json);
      return false;
   }
}
