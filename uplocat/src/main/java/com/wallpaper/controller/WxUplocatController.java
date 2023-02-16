package com.wallpaper.controller;

import com.wallpaper.service.IconUplocatService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping({"/uplocad"})
public class WxUplocatController {
   private static final Logger log = LoggerFactory.getLogger(WxUplocatController.class);
   @Autowired
   private IconUplocatService iconUplocatService;
   @Value("${aliyun.oss.bucketName}")
   private String bucketName;

   @RequestMapping({"/chang"})
   public Object wxUplocadAddChang(@RequestParam("file") MultipartFile file) {
      return this.iconUplocatService.changIconUplocat(file);
   }

   @RequestMapping({"/heng"})
   public Object wxUplocadAddHeng(@RequestParam("file") MultipartFile file) {
      return this.iconUplocatService.hengIconUplocat(file);
   }
}
