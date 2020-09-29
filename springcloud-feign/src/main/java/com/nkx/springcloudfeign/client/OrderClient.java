package com.nkx.springcloudfeign.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;


@FeignClient(value = "SPRINGCLOUD-ORDER", path = "order")
public interface OrderClient {

  @RequestMapping("creatOrderNum")
  public Long creatOrderNum();

}
