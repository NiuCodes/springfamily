package com.nkx.springcloudorder.service;

import com.nkx.springcloudorder.common.TokenInfo;

public interface IadminService {

  public TokenInfo login(String userName,String passWord);
}
