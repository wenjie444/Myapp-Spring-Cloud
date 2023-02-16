package com.wallpaper.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class IconMultipartFile implements Serializable {
   private static final long serialVersionUID = 2L;
   private String name;
   private String bytes;


}
