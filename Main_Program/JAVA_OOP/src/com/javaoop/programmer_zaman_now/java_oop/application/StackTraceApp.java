package com.javaoop.programmer_zaman_now.java_oop.application;

public class StackTraceApp {
  public static void main(String[] args) {

    try {
      sampleError(); // INI JUGA ERROR
    } catch (RuntimeException exception) {
      exception.printStackTrace();
    }

  }

  public static void sampleError() {
    try {
      String[] names = {
          "Eko", "Kurniawan", "Khannedy"
      };

      System.out.println(names[100]); // INI AKAN ERROR
    } catch (Throwable throwable) {
      throw new RuntimeException(throwable);
    }
  }
}
