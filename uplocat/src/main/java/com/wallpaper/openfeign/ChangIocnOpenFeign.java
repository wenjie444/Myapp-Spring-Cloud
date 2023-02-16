package com.wallpaper.openfeign;

import com.wallpaper.entity.WallChang;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("changiocn")
public interface ChangIocnOpenFeign {
   @PostMapping({"/wallparper/wallchang/add"})
   Object insetChangiocn(@RequestBody WallChang wallChang);
}
