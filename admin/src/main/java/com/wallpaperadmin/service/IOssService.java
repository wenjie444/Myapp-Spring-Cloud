package com.wallpaperadmin.service;

import java.io.InputStream;
import org.springframework.web.multipart.MultipartFile;

public interface IOssService {
   Object upload(MultipartFile file, String username);

   String upload(InputStream inputStream, String name, String username);
}
