package com.wallpaper.controller;

import com.wallpaper.entity.WallChang;
import com.wallpaper.service.WallChangService;
import com.wallpaper.utils.R;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/wallchang"})
public class WallChangController {
   private static final Logger log = LoggerFactory.getLogger(WallChangController.class);
   @Resource
   private WallChangService wallChangService;

   @GetMapping({"/iocn"})
   private Object wallChangFind(@RequestParam("pageNum") int pageNum, @RequestParam("pageSize") int pageSize) {
      return R.susscer(this.wallChangService.wallChangGet(pageNum, pageSize));
   }

   @GetMapping({"/iocnid"})
   private Object wallChangIdFind(@RequestParam("id") int id) {
      return R.susscer(this.wallChangService.wallChangIdGet(id));
   }

   @PostMapping({"/add"})
   private Object wallChangAdd(@RequestBody WallChang wallChang) {
      return this.wallChangService.wallChangAdd(wallChang);
   }
}
