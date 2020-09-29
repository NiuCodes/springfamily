package com.nkx.springcloudribbon.controller;

import java.util.Random;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

  @RequestMapping("queryOrder")
  public int queryOrder() {
    Random random = new Random();
    return random.nextInt(10);

  }
}
