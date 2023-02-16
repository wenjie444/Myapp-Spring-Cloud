package com.wallpaper.mapper;

import com.wallpaper.entity.HengIocn;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface HengIocnMapper {
   int insertHengIocn(HengIocn hengIocn);
}
