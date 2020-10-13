package com.nkx.springcloudfeign.client.impl;

import com.nkx.springcloudfeign.client.OrderClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

@Component
public class OrderClientImpl implements OrderClient {
  @Override
  public Long creatOrderNum(Boolean flag) {
    System.out.println("server demotion");
    return null;
  }
}
