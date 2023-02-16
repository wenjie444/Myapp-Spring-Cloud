package com.wallpaper.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wallpaper.entity.WallChang;
import com.wallpaper.mapper.WallChangMapper;
import com.wallpaper.service.WallChangService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class WallChangServiceImpl implements WallChangService {
   @Autowired
   private WallChangMapper wallChangMapper;
   @Autowired
   private RedisTemplate redisTemplate;

   public Object wallChangGet(int pageNum, int pageSize) {
      String s = pageNum + "";
      String key = "chang" + s;
      if (this.redisTemplate.hasKey(key)) {
         return this.redisTemplate.opsForValue().get(key);
      } else {
         PageHelper.startPage(pageNum, pageSize);
         List<WallChang> wallChangs = this.wallChangMapper.selectChang();
         PageInfo<WallChang> wallChangPageInfo = new PageInfo(wallChangs);
         this.redisTemplate.opsForValue().set(key, wallChangPageInfo);
         return wallChangPageInfo;
      }
   }

   public Object wallChangIdGet(int id) {
      return this.wallChangMapper.selectOne(id);
   }

   public Object wallChangAdd(WallChang wallChang) {
      return this.wallChangMapper.insertWallChang(wallChang);
   }
}
