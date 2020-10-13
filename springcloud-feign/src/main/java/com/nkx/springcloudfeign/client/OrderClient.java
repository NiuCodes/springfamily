package com.nkx.springcloudfeign.client;

import com.nkx.springcloudfeign.client.impl.OrderClientImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "SPRINGCLOUD-ORDER",fallback = OrderClientImpl.class, path = "order")
public interface OrderClient {

  @RequestMapping("creatOrderNum/{flag}")
  public Long creatOrderNum(@PathVariable(value = "flag") Boolean flag);

}
