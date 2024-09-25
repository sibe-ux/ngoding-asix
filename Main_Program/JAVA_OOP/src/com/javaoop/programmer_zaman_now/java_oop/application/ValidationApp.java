package com.javaoop.programmer_zaman_now.java_oop.application;

import com.javaoop.programmer_zaman_now.java_oop.annotation.Fancy;
import com.javaoop.programmer_zaman_now.java_oop.data.LoginRequest;
import com.javaoop.programmer_zaman_now.java_oop.error.ValidationException;
import com.javaoop.programmer_zaman_now.java_oop.util.ValidationUtil;

public class ValidationApp {

  @Fancy(name = "AnimalApp", tags = {"application", "java"})
  public static void main(String[] args) {

    LoginRequest loginRequest = new LoginRequest("eko", "rahasia");

    try {
      ValidationUtil.validate(loginRequest);
      System.out.println("Data valid");
    } catch (ValidationException | NullPointerException exception) {
      System.out.println("Data tidak valid : " + exception.getMessage());
    } finally {
      System.out.println("Selalu di eksekusi");
    }


    LoginRequest loginRequest2 = new LoginRequest(null, null);
    ValidationUtil.validateRuntime(loginRequest2);
    System.out.println("Sukses");

  }
}
