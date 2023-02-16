package com.wallpaper.ss;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/test"})
@RefreshScope
public class test {
   @Value("${data}")
   private String data;
   @Autowired
   private changClient changclient;

   @GetMapping({"/s"})
   public String test() {
      String ss = this.changclient.ss(1);
      return ss;
   }
}
