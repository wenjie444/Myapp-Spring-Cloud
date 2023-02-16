package com.wallpaper.openfeign;

import com.wallpaper.entity.HengIocn;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("hengiocn")
public interface HengIocnOpenFeign {
   @PostMapping({"/wallparper/heng/insert"})
   Object hengIocnAdd(@RequestBody HengIocn hengIocn);
}
