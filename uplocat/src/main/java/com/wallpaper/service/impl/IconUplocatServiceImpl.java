package com.wallpaper.service.impl;

import com.aliyun.oss.OSSClient;
import com.wallpaper.entity.HengIocn;
import com.wallpaper.entity.IconMultipartFile;
import com.wallpaper.entity.WallChang;
import com.wallpaper.mapper.HengIocnMapper;
import com.wallpaper.mapper.WallChangMapper;
import com.wallpaper.service.IconUplocatService;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Set;
import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class IconUplocatServiceImpl implements IconUplocatService {
   private static final Logger log = LoggerFactory.getLogger(IconUplocatServiceImpl.class);
   @Autowired
   private OSSClient ossClient;
   @Value("${aliyun.oss.bucketName}")
   private String bucketName;
   @Autowired
   private RedisTemplate redisTemplate;
   @Autowired
   private WallChangMapper wallChangMapper;
   @Autowired
   private RabbitTemplate rabbitTemplate;
   @Autowired
   private HengIocnMapper hengIocnMapper;

   public Object changIconUplocat(MultipartFile file) {
      Set<String> keys = this.redisTemplate.keys("chang*");
      this.redisTemplate.delete(keys);
      String originalFilename = file.getOriginalFilename();
      String substring = originalFilename.substring(originalFilename.lastIndexOf("."));
      UUID uuid = UUID.randomUUID();
      String s = "changimages/";
      String name = s + uuid + substring;
      InputStream inputStream = null;

      try {
         inputStream = file.getInputStream();
         (new Thread(() -> {
            this.ossClient.putObject(this.bucketName, name, inputStream);
         })).start();
      } catch (IOException var10) {
         var10.printStackTrace();
      }

      WallChang wallChang = new WallChang();
      wallChang.setIocn("https://liuwen666.xyz/" + name);
      wallChang.setAddtime(new Date());
      this.wallChangMapper.insertWallChang(wallChang);
      return 200;
   }

   public Object hengIconUplocat(MultipartFile file) {
      Set<String> keys = this.redisTemplate.keys("heng*");
      this.redisTemplate.delete(keys);
      String originalFilename = file.getOriginalFilename();
      String substring = originalFilename.substring(originalFilename.lastIndexOf("."));
      UUID uuid = UUID.randomUUID();
      String s = "hengimages/";
      String name = s + uuid + substring;
      IconMultipartFile iconMultipartFile = new IconMultipartFile();
      iconMultipartFile.setName(name);
      InputStream inputStream = null;

      try {
         inputStream = file.getInputStream();
         (new Thread(() -> {
            this.ossClient.putObject(this.bucketName, name, inputStream);
         })).start();
      } catch (IOException var11) {
         var11.printStackTrace();
      }

      HengIocn hengIocn = new HengIocn();
      hengIocn.setIocn("https://liuwen666.xyz/" + name);
      hengIocn.setAddtime(new Date());
      this.hengIocnMapper.insertHengIocn(hengIocn);
      return 200;
   }
}
