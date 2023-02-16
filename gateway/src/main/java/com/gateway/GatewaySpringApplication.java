package com.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import reactor.core.publisher.Mono;

@SpringBootApplication
public class GatewaySpringApplication {
   public static void main(String[] args) {
      SpringApplication.run(GatewaySpringApplication.class, args);
   }

   public KeyResolver userKeyResolver() {
      return (exchange) -> {
         String hostName = exchange.getRequest().getRemoteAddress().getAddress().getHostAddress();
         System.out.println("hostName:" + hostName);
         return Mono.just(hostName);
      };
   }
}
