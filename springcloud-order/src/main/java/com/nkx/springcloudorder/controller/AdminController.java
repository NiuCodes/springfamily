package com.nkx.springcloudorder.controller;

import java.util.HashMap;
import java.util.Map;

import com.nkx.springcloudorder.common.Result;
import com.nkx.springcloudorder.config.properties.JwtProperties;
import com.nkx.springcloudorder.domain.UmsMember;
import com.nkx.springcloudorder.util.JwtKit;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("sso")
public class AdminController {

  @Autowired
  private JwtKit jwtKit;

  @Autowired
  private JwtProperties jwtProperties;

  @GetMapping("login")
  public Result login(String userName, String passWord) {
    if (StringUtils.isNotEmpty(passWord)) {
      UmsMember user = new UmsMember();
      user.setId(1L);
      user.setMemberLevelId(1000L);
      user.setUsername("Casey");
      Map<String, String> map = new HashMap<>();
      String token = jwtKit.generateJwtToken(user);
      map.put("tokenHead", jwtProperties.getTokenHead());
      map.put("token", token);
      return Result.success(map,"login successful");
    }
    return null;

  }
}
