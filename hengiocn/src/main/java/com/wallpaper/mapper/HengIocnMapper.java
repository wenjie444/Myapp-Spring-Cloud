package com.wallpaper.mapper;

import com.wallpaper.entity.HengIocn;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface HengIocnMapper {
   List<HengIocn> select();

   HengIocn selectOne(@Param("id") int id);

   int insertHengIocn(HengIocn hengIocn);
}
