package com.wallpaper.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
public class HengIocn implements Serializable {
   private static final long serialVersionUID = 1L;
   private int id;
   private String iocn;
   private String classify;
   private Date addtime;
   private int collect;


}
