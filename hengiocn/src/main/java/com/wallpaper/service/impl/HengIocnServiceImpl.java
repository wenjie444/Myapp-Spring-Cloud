package com.wallpaper.service.impl;

import com.wallpaper.entity.HengIocn;
import com.wallpaper.mapper.HengIocnMapper;
import com.wallpaper.service.HengIocnService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class HengIocnServiceImpl implements HengIocnService {
   @Autowired
   private HengIocnMapper hengIocnMapper;
   @Autowired
   private RedisTemplate redisTemplate;

   public Object test() {
      List wallpapers;
      if (this.redisTemplate.hasKey("hengiocn")) {
         wallpapers = this.redisTemplate.opsForList().range("hengiocn", 0L, -1L);
         System.out.println(wallpapers.toString());
         return wallpapers;
      } else {
         wallpapers = this.hengIocnMapper.select();
         this.redisTemplate.opsForList().leftPushAll("hengiocn", wallpapers);
         return wallpapers;
      }
   }

   public Object daIocnIdFind(int id) {
      HengIocn id1 = this.hengIocnMapper.selectOne(id);
      return id1;
   }

   public int add(HengIocn hengIocn) {
      return this.hengIocnMapper.insertHengIocn(hengIocn);
   }
}
