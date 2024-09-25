package com.javaoop.programmer_zaman_now.java_oop.application;

import com.javaoop.programmer_zaman_now.java_oop.data.LoginRequest;

public class RecordApp {
  public static void main(String[] args) {

    LoginRequest loginRequest = new LoginRequest("eko", "rahasia");

    System.out.println(loginRequest.getUsername());
    System.out.println(loginRequest.getPassword());
    System.out.println(loginRequest);

    System.out.println(new LoginRequest("sibe"));
    System.out.println(new LoginRequest("eko"));
    System.out.println(new LoginRequest("eko", "rahasia"));

  }
}
