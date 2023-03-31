package com.wallpaperadmin.mapper;

import com.wallpaperadmin.entity.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

@Mapper
public interface AdminMapper {
   Admin selectOne(@Param("username") String username, @Param("openId") String openId);

   int updataAdmin(@Param("iocn") String iocn, @Param("username") String username);

   //int insterAdmin(@Param("admin") Admin admin);

   Admin selectAdmin(@Param("username") String username);

   void insterAdmin(@Param("username") String username,
                    @Param("iocn") String iocn,
                    @Param("openid")String openid,
                    @Param("addtime") Date addtime);
}
