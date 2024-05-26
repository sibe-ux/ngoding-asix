package com.javaoop.programmer_zaman_now.java_oop.data;

public record LoginRequest(String username, String password) {

  public LoginRequest {
    System.out.println("Membuat object LoginRequest");
  }
  
  public LoginRequest(String username) {
    this(username, "");
  }

  @Override
  public String username(){return null;}
  
  public LoginRequest() {
    this("", "");
  }
}
