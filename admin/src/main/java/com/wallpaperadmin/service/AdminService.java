package com.wallpaperadmin.service;

import com.wallpaperadmin.entity.Admin;

public interface AdminService {
   Admin login(Admin admin);

   Object wxmYiocnGet(String username);

   Admin usernameGet(String username);
}
