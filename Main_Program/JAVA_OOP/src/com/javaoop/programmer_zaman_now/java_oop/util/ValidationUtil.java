package com.javaoop.programmer_zaman_now.java_oop.util;

import java.lang.reflect.Field;

import com.javaoop.programmer_zaman_now.java_oop.annotation.NotBlank;
import com.javaoop.programmer_zaman_now.java_oop.data.LoginRequest;
import com.javaoop.programmer_zaman_now.java_oop.error.BlankException;
import com.javaoop.programmer_zaman_now.java_oop.error.ValidationException;

public class ValidationUtil {

  public static void validate(LoginRequest loginRequest) throws ValidationException, NullPointerException {
    if (loginRequest.getUsername() == null) {
      throw new NullPointerException("Username is null");
    } else if (loginRequest.getUsername().isBlank()) {
      throw new ValidationException("Username is blank");
    } else if (loginRequest.getPassword() == null) {
      throw new NullPointerException("Password is null");
    } else if (loginRequest.getPassword().isBlank()) {
      throw new ValidationException("Password is blank");
    }
  }

  public static void validateRuntime(LoginRequest loginRequest) {
    if (loginRequest.getUsername() == null) {
      throw new NullPointerException("Username is null");
    } else if (loginRequest.getUsername().isBlank()) {
      throw new BlankException("Username is blank");
    } else if (loginRequest.getPassword() == null) {
      throw new NullPointerException("Password is null");
    } else if (loginRequest.getPassword().isBlank()) {
      throw new BlankException("Password is blank");
    }
  }

  public static void validationReflection(Object object) {
    Class aClass = object.getClass();
    Field[] fields = aClass.getDeclaredFields();

    for (var field : fields) {
      field.setAccessible(true);

      if (field.getAnnotation(NotBlank.class) != null) {
        // validated
        try {
          String value = (String) field.get(object);

          if (value == null || value.isBlank()) {
            throw new BlankException("Field " + field.getName() + " is blank ");
          }

        } catch (IllegalAccessException exception) {
          System.out.println("Tidak bisa mengakses field " + field.getName());
        }
      }

    }
  }

}
