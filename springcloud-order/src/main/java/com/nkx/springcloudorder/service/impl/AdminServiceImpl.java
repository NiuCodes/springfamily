package com.nkx.springcloudorder.service.impl;

import com.nkx.springcloudorder.common.TokenInfo;
import com.nkx.springcloudorder.service.IadminService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements IadminService {
  @Override
  public TokenInfo login(String userName, String passWord) {
      if (StringUtils.isNotEmpty(userName)){
        return null;
      }
    return null;
  }
}
