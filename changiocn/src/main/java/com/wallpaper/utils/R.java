package com.wallpaper.utils;

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

   public int getCode() {
      return this.code;
   }

   public T getData() {
      return this.data;
   }



   public String toString() {
      return "R(code=" + this.getCode() + ", data=" + this.getData() + ")";
   }
}
