package com.alioss.entity;

import lombok.Data;

import java.io.Serializable;
@Data
public class IconMultipartFile implements Serializable {
   private static final long serialVersion = 23L;
   private String name;
   private String bytes;

}
