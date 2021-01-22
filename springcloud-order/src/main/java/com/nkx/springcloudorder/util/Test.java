package com.nkx.springcloudorder.util;

public class Test {
  public static void main(String[] args) {
    String aa = "English US (English US)";
    String replace = aa.replaceAll("\\s*", "");
    System.out.println(replace);
  }
}
