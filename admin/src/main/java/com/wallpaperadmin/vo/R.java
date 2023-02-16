package com.wallpaperadmin.vo;

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


   public String toString() {
      return "R(code=" + this.getCode() + ", data=" + this.getData() + ")";
   }
}
