package com.nkx.springcloudorder.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/tpl")
public class ThymeleafController {
  @RequestMapping("/WebsocketDanMu")
  public String testThymeleaf(ModelMap map) {
    // 设置属性
    map.addAttribute("name", "enjoy");
    // testThymeleaf：为模板文件的名称
    // 对应src/main/resources/templates/testThymeleaf.html
    return "WebsocketDanMu";
  }
}

