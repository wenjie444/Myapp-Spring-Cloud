package com.wallpaper.mapper;

import com.wallpaper.entity.WallChang;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface WallChangMapper {
   List<WallChang> selectChang();

   WallChang selectOne(@Param("id") int id);

   int insertWallChang(WallChang wallChang);
}
