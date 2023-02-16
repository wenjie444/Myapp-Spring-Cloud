package com.wallpaperadmin.service.impl;

import com.wallpaperadmin.entity.Admin;
import com.wallpaperadmin.mapper.AdminMapper;
import com.wallpaperadmin.service.AdminService;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {
   @Resource
   private AdminMapper adminMapper;

   public Admin login(Admin admin) {
      Admin a = this.adminMapper.selectOne(admin.getUsername(), admin.getOpenid());
      if (a == null) {
         this.adminMapper.insterAdmin(admin);
      }

      return admin;
   }

   public Object wxmYiocnGet(String username) {
      return this.adminMapper.selectAdmin(username);
   }

   public Admin usernameGet(String username) {
      return this.adminMapper.selectAdmin(username);
   }
}
