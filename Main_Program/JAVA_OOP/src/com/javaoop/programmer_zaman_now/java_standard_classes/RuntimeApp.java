package com.javaoop.programmer_zaman_now.java_standard_classes;

public class RuntimeApp {
  public static void main(String[] args) {

    Runtime runtime = Runtime.getRuntime();

    System.out.println(runtime.availableProcessors());
    System.out.println(runtime.freeMemory());
    System.out.println(runtime.totalMemory());
    System.out.println(runtime.maxMemory());


  }
}
