package com.javaoop.programmer_zaman_now.java_standard_classes;

public class SystemApp {
  public static void main(String[] args) {

    System.out.println(System.currentTimeMillis());
    System.out.println(System.nanoTime());

    System.out.println(System.getenv("HOME"));
    System.out.println(System.getenv("APP"));

    System.gc();

    System.exit(1);

    System.out.println("Hi");

  }
}
