package com.wallpaper.controller;

import com.wallpaper.entity.HengIocn;
import com.wallpaper.entity.R;
import com.wallpaper.service.HengIocnService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping({"/heng"})
@RestController
public class HengIocnController {
   private static final Logger log = LoggerFactory.getLogger(HengIocnController.class);
   @Autowired
   private HengIocnService hengIocnService;

   @GetMapping({"/iocn"})
   public Object test() {
      return R.susscer(this.hengIocnService.test());
   }

   @GetMapping({"/daiocn"})
   public Object daIocnIdFind(int id) {
      return R.susscer(this.hengIocnService.daIocnIdFind(id));
   }

   @PostMapping({"/insert"})
   public Object hengIocnInsert(@RequestBody HengIocn hengIocn) {
      return this.hengIocnService.add(hengIocn);
   }
}
