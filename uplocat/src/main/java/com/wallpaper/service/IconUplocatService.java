package com.wallpaper.service;

import org.springframework.web.multipart.MultipartFile;

public interface IconUplocatService {
   Object changIconUplocat(MultipartFile file);

   Object hengIconUplocat(MultipartFile file);
}
