package com.wallpaper.mapper;

import com.wallpaper.entity.WallChang;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface WallChangMapper {
   int insertWallChang(WallChang wallChang);
}
