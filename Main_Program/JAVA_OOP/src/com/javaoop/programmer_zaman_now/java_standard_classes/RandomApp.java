package com.javaoop.programmer_zaman_now.java_standard_classes;

import java.util.Random;

public class RandomApp {
  public static void main(String[] args) {

    Random random = new Random();

    for (int i = 0; i < 1000; i++) {
      int value = random.nextInt(1000);
      System.out.println(value);
    }

  }
}
