package com.wallpaper.ss;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("hengiocn")
public interface changClient {
   @GetMapping({"/wallparper/test/{id}"})
   String ss(@PathVariable("id") int id);
}
