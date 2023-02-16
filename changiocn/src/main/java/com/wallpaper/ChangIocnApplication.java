package com.wallpaper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ChangIocnApplication {
   public static void main(String[] args) {
      SpringApplication.run(ChangIocnApplication.class, args);
   }
}
