package com.nkx.springcloudorder.controller;

import java.util.Random;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("order")
public class OrderController {

  @RequestMapping("creatOrderNum")
  public Long creatOrderNum(){
    return new Random().nextLong();

  }
}
