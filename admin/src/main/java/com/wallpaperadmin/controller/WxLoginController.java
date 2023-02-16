package com.wallpaperadmin.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.wallpaperadmin.entity.Admin;
import com.wallpaperadmin.service.AdminService;
import com.wallpaperadmin.service.IOssService;
import com.wallpaperadmin.utlis.JwtUtil;
import com.wallpaperadmin.vo.R;
import com.wallpaperadmin.vo.SysUserVO;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping({"/wx"})
@CrossOrigin
public class WxLoginController {
   private static final Logger log = LoggerFactory.getLogger(WxLoginController.class);
   @Autowired
   private AdminService adminService;
   @Autowired
   private IOssService ossService;
   @Autowired
   private StringRedisTemplate stringRedisTemplate;

   @PostMapping({"/login"})
   public Object wxLogin(HttpServletResponse response, @RequestParam("code") String code, @RequestParam("iocn") String iocn, @RequestParam("username") String username) {
      log.info("wxlogin - code: " + code);
      log.info("username" + username);
      log.info("iocn: " + iocn);
      this.stringRedisTemplate.opsForValue().set("username", username, 60L, TimeUnit.MINUTES);
      String username1 = (String)this.stringRedisTemplate.opsForValue().get("username");
      System.out.println("现在登录的用户是" + username1);
      String s = "";
      SysUserVO sysUserVO = null;

      try {
         CloseableHttpClient httpClient = HttpClients.createDefault();
         RequestConfig defaultRequestConfig = RequestConfig.custom().build();
         URIBuilder uriBuilder = new URIBuilder("https://api.weixin.qq.com/sns/jscode2session");
         uriBuilder.setParameter("appid", "wx12df3dba6fe14a4e");
         uriBuilder.setParameter("secret", "54fc4d0784f9e572bcba2da88807ae14");
         uriBuilder.setParameter("js_code", code);
         uriBuilder.setParameter("grant_type", "authorization_code");
         HttpPost httpPost = new HttpPost(uriBuilder.build());
         httpPost.addHeader("accept", "application/json");
         httpPost.setConfig(defaultRequestConfig);
         CloseableHttpResponse execute = httpClient.execute(httpPost);
         s = EntityUtils.toString(execute.getEntity());
         System.out.println("22222222222222" + s);
         JSONObject jsonObject = JSON.parseObject(s);
         String openid = jsonObject.getString("openid");
         String sessionkey = jsonObject.getString("session_key");
         Admin admin = new Admin();
         admin.setUsername(username);
         admin.setOpenid(openid);
         admin.setAddtime(new Date());
         this.adminService.login(admin);
         log.info("返回的信息" + openid);
         Map<String, Object> map = new HashMap();
         map.put("username", username);
         map.put("openid", openid);
         String jwt = JwtUtil.createJWT(UUID.randomUUID().toString(), JSON.toJSONString(map), (Long)null);
         log.info("1111111111111111" + jwt);
         sysUserVO = new SysUserVO();
         sysUserVO.setToken(jwt);
         sysUserVO.setUsername(username);
         sysUserVO.setSessionkey(sessionkey);
         Cookie cookie = new Cookie("token", jwt);
         log.info("222222222" + cookie);
         response.addCookie(cookie);
         response.setHeader("token", jwt);
         System.out.println("111111111111" + openid);
         if (openid.equals("o-thD482nDVtz9dfExJY1Gxvs_4I")) {
            sysUserVO.setCode(200);
         }
      } catch (Exception var21) {
         var21.printStackTrace();
      }

      return R.susscer(sysUserVO);
   }

   @PostMapping(
      value = {"test"},
      produces = {"application/json"}
   )
   public Object download(HttpServletRequest request, @RequestParam("file") MultipartFile files, @RequestParam("username") String username) {
      System.out.println("yyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy");
      Admin admin = this.adminService.usernameGet(username);
      return admin.getIocn() == null ? this.ossService.upload(files, username) : "头像保存成功";
   }

   @GetMapping({"/iocn"})
   public Object iocnFind(@RequestParam("username") String username) {
      return R.susscer(this.adminService.usernameGet(username));
   }
}
