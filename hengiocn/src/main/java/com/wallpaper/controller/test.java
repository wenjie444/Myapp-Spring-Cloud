package com.wallpaper.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/test"})
public class test {
   private static final Logger log = LoggerFactory.getLogger(test.class);

   @GetMapping({"/{id}"})
   public String test(@PathVariable("id") int id) {
      return "shfaioh";
   }
}
