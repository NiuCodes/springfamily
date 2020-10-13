package com.nkx.springcloudorder.controller;

import java.util.Random;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("order")
public class OrderController {

  @RequestMapping("creatOrderNum/{flag}")
  public Long creatOrderNum(@PathVariable(value = "flag") Boolean flag){
    System.out.println("=============order========" + flag);
    if (flag){
      throw new RuntimeException("provider exception");
    }
    return new Random().nextLong();
  }
}
