package com.javaoop.programmer_zaman_now.java_oop.data;

public class LoginRequest {

  private String username;
  private String password;

  public LoginRequest(String username, String password) {
    this.username = username;
    this.password = password;
    System.out.println("Membuat object LoginRequest");
  }
  
  public LoginRequest(String username) {
    this(username, "");
  }

  public String getUsername() {
    return username;
  }

  public String getPassword() {
    return password;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
