package com.gateway.config;

import com.gateway.utils.JwtUtil;
import io.jsonwebtoken.Claims;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

public class AuthorizeFilter implements GlobalFilter, Ordered {
   private static final Logger log = LoggerFactory.getLogger(AuthorizeFilter.class);
   private static final String AUTHORIZE_TOKEN = "token";

   public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
      ServerHttpRequest request = exchange.getRequest();
      ServerHttpResponse response = exchange.getResponse();
      String path = request.getURI().getPath();
      log.info("获取请求的url" + path);
      if (!path.startsWith("/admin/wallparper/wx/login") && !path.startsWith("/admin/wallparper/wx/test") && !path.startsWith("/heng/wallparper/heng/iocn") && !path.startsWith("/chang/wallparper/wallchang/iocn") && !path.startsWith("/chang/wallparper/wallchang/iocnid") && !path.startsWith("/heng/wallparper/heng/daiocn")) {
         String token = request.getHeaders().getFirst("token");
         log.info("头文件令牌信息" + token);
         boolean hasToken = true;
         if (StringUtils.isEmpty(token)) {
            token = (String)request.getQueryParams().getFirst("token");
            hasToken = false;
         }

         if (StringUtils.isEmpty(token)) {
            response.setStatusCode(HttpStatus.METHOD_NOT_ALLOWED);
            log.info("错误参数" + response.setComplete());
            return response.setComplete();
         } else {
            try {
               Claims var8 = JwtUtil.parseJWT(token);
            } catch (Exception var9) {
               var9.printStackTrace();
               response.setStatusCode(HttpStatus.UNAUTHORIZED);
               return response.setComplete();
            }

            request.mutate().header("token", new String[]{token});
            return chain.filter(exchange);
         }
      } else {
         Mono<Void> filter = chain.filter(exchange);
         return filter;
      }
   }

   public int getOrder() {
      return 0;
   }
}
