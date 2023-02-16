package com.wallpaperadmin.vo;

import lombok.Data;

import java.io.Serializable;
@Data
public class SysUserVO implements Serializable {
   private String token;
   private String username;
   private int code;
   private String sessionkey;

   public String getToken() {
      return this.token;
   }

   public String getUsername() {
      return this.username;
   }

   public int getCode() {
      return this.code;
   }

   public String getSessionkey() {
      return this.sessionkey;
   }

   public void setToken(final String token) {
      this.token = token;
   }

   public void setUsername(final String username) {
      this.username = username;
   }

   public void setCode(final int code) {
      this.code = code;
   }

   public void setSessionkey(final String sessionkey) {
      this.sessionkey = sessionkey;
   }

   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof SysUserVO)) {
         return false;
      } else {
         SysUserVO other = (SysUserVO)o;
         if (!other.canEqual(this)) {
            return false;
         } else if (this.getCode() != other.getCode()) {
            return false;
         } else {
            label49: {
               Object this$token = this.getToken();
               Object other$token = other.getToken();
               if (this$token == null) {
                  if (other$token == null) {
                     break label49;
                  }
               } else if (this$token.equals(other$token)) {
                  break label49;
               }

               return false;
            }

            Object this$username = this.getUsername();
            Object other$username = other.getUsername();
            if (this$username == null) {
               if (other$username != null) {
                  return false;
               }
            } else if (!this$username.equals(other$username)) {
               return false;
            }

            Object this$sessionkey = this.getSessionkey();
            Object other$sessionkey = other.getSessionkey();
            if (this$sessionkey == null) {
               if (other$sessionkey != null) {
                  return false;
               }
            } else if (!this$sessionkey.equals(other$sessionkey)) {
               return false;
            }

            return true;
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof SysUserVO;
   }

   public String toString() {
      return "SysUserVO(token=" + this.getToken() + ", username=" + this.getUsername() + ", code=" + this.getCode() + ", sessionkey=" + this.getSessionkey() + ")";
   }
}
