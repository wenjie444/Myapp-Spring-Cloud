package com.wallpaper.entity;

import lombok.Data;

@Data
public class R<T> {
   private int code;
   private T data;

   public static <T> R susscer(T data) {
      R r = new R();
      r.code = 200;
      r.data = data;
      return r;
   }


}
