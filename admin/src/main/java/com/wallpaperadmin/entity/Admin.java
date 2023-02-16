package com.wallpaperadmin.entity;

import lombok.Data;

import java.util.Date;
@Data
public class Admin {
   private int id;
   private String username;
   private String nickname;
   private String password;
   private String iocn;
   private String xiocn;
   private String openid;
   private Date addtime;


   public String toString() {
      return "Admin(id=" + this.getId() + ", username=" + this.getUsername() + ", nickname=" + this.getNickname() + ", password=" + this.getPassword() + ", iocn=" + this.getIocn() + ", xiocn=" + this.getXiocn() + ", openid=" + this.getOpenid() + ", addtime=" + this.getAddtime() + ")";
   }
}
