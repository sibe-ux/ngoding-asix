package com.javaoop.programmer_zaman_now.java_oop.error;

public class BlankException extends RuntimeException {

  public BlankException(String message) {
    super(message);
  }

  @Override
  public String getMessage() {
    return super.getMessage();
  }
}
