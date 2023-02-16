package com.wallpaper.service;

import com.wallpaper.entity.WallChang;

public interface WallChangService {
   Object wallChangGet(int pageNum, int pageSize);

   Object wallChangIdGet(int id);

   Object wallChangAdd(WallChang wallChang);
}
