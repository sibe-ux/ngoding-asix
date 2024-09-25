package com.javaoop.programmer_zaman_now.java_oop.application;

import com.javaoop.programmer_zaman_now.java_oop.data.CreateUserRequest;
import com.javaoop.programmer_zaman_now.java_oop.util.ValidationUtil;

public class ReflectionApp {
  public static void main(String[] args) {

    CreateUserRequest request = new CreateUserRequest();
    request.setUsername("eko");
    request.setPassword("eko");
    request.setName(""); // ini error

    ValidationUtil.validationReflection(request);

  }
}
