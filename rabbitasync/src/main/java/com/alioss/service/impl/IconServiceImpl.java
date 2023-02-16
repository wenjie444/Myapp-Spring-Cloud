package com.alioss.service.impl;

import com.alibaba.fastjson.JSON;
import com.alioss.entity.IconMultipartFile;
import com.alioss.service.IconService;
import com.aliyun.oss.OSSClient;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class IconServiceImpl implements IconService {
   @Autowired
   private OSSClient ossClient;
   @Value("${aliyun.oss.bucketName}")
   private String bucketName;

   public void changIconUplocat(String messages) {
      IconMultipartFile iconMultipartFile = (IconMultipartFile)JSON.parseObject(messages, IconMultipartFile.class);
      System.out.println(iconMultipartFile);
      byte[] bytes = Base64.decodeBase64(iconMultipartFile.getBytes());
      InputStream inputStream = new ByteArrayInputStream(bytes);
      this.ossClient.putObject(this.bucketName, iconMultipartFile.getName(), inputStream);
   }

   public void hengIconUplocat(String messages) {
      IconMultipartFile iconMultipartFile = (IconMultipartFile)JSON.parseObject(messages, IconMultipartFile.class);
      System.out.println(iconMultipartFile);
      byte[] bytes = Base64.decodeBase64(iconMultipartFile.getBytes());
      InputStream inputStream = new ByteArrayInputStream(bytes);
      this.ossClient.putObject(this.bucketName, iconMultipartFile.getName(), inputStream);
   }
}
