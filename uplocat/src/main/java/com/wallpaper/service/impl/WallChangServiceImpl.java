package com.wallpaper.service.impl;

import com.wallpaper.entity.WallChang;
import com.wallpaper.mapper.WallChangMapper;
import com.wallpaper.service.WallChangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class WallChangServiceImpl implements WallChangService {
   @Autowired
   private WallChangMapper wallChangMapper;
   @Autowired
   private RedisTemplate redisTemplate;

   public Object wallChangAdd(WallChang wallChang) {
      return this.wallChangMapper.insertWallChang(wallChang);
   }
}
