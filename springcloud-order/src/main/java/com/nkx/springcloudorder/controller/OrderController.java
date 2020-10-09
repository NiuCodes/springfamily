package com.nkx.springcloudorder.controller;

import java.util.Random;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("order")
public class OrderController {

  @RequestMapping("creatOrderNum")
  public Long creatOrderNum(Boolean flag){
    if (flag){
      new RuntimeException("provider exception");
    }
    return new Random().nextLong();
  }
}
