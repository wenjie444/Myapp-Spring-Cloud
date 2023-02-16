package com.wallpaper.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
public class WallChang implements Serializable {
   private static final long serialVersionUID = 10L;
   private int id;
   private String iocn;
   private String classify;
   private Date addtime;
   private int collect;


}
