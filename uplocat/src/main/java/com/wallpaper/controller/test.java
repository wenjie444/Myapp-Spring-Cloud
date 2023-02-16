package com.wallpaper.controller;

import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/test"})
public class test {
   @Autowired
   RedisTemplate redisTemplate;

   @GetMapping({"/s"})
   public Object ss() {
      Set<String> keys = this.redisTemplate.keys("1*");
      Long delete = this.redisTemplate.delete(keys);
      return delete;
   }
}
