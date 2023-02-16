package com.wallpaper.service.impl;

import com.wallpaper.entity.HengIocn;
import com.wallpaper.mapper.HengIocnMapper;
import com.wallpaper.service.HengIocnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class HengIocnServiceImpl implements HengIocnService {
   @Autowired
   private HengIocnMapper hengIocnMapper;
   @Autowired
   private RedisTemplate redisTemplate;

   public int add(HengIocn hengIocn) {
      return this.hengIocnMapper.insertHengIocn(hengIocn);
   }
}
