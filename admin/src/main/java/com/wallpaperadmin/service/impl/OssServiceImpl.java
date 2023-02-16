package com.wallpaperadmin.service.impl;

import com.aliyun.oss.OSSClient;
import com.wallpaperadmin.mapper.AdminMapper;
import com.wallpaperadmin.service.IOssService;
import java.io.IOException;
import java.io.InputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class OssServiceImpl implements IOssService {
   private static final Logger log = LoggerFactory.getLogger(OssServiceImpl.class);
   @Value("${aliyun.oss.maxSize}")
   private int maxSize;
   @Value("${aliyun.oss.bucketName}")
   private String bucketName;
   @Value("${aliyun.oss.dir.prefix}")
   private String dirPrefix;
   @Autowired
   private OSSClient ossClient;
   @Autowired
   private AdminMapper adminMapper;

   public String upload(MultipartFile file, String username) {
      try {
         this.upload(file.getInputStream(), file.getOriginalFilename(), username);
      } catch (IOException var4) {
         log.error(var4.getMessage());
      }

      return null;
   }

   public String upload(InputStream inputStream, String name, String username) {
      String objectName = this.getBucketName(name, username);
      this.ossClient.putObject(this.bucketName, objectName, inputStream);
      return this.formatPath(objectName);
   }

   private String getBucketName(String url, String username) {
      String extensionName = "";
      if (url != null && url.length() > 0) {
         int dot = url.lastIndexOf(46);
         if (dot > -1 && dot < url.length() - 1) {
            extensionName = url.substring(dot);
         }
      }

      String fileName = System.currentTimeMillis() + "_" + System.nanoTime() + extensionName;
      String filePath = "touxiang/" + fileName;
      String iocn = "https://liuwen666.xyz/" + filePath;
      this.adminMapper.updataAdmin(iocn, username);
      System.out.println("图片名称" + filePath);
      return filePath;
   }

   private String formatPath(String objectName) {
      return "https://" + this.bucketName + "." + this.ossClient.getEndpoint().getHost() + "/" + objectName;
   }
}
