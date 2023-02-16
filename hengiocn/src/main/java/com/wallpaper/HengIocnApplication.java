package com.wallpaper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class HengIocnApplication {
   public static void main(String[] args) {
      SpringApplication.run(HengIocnApplication.class, args);
   }
}
