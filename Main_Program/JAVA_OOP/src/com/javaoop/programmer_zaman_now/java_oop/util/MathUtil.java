package com.javaoop.programmer_zaman_now.java_oop.util;

public class MathUtil {

  public static int sum(int... values) {
    int total = 0;
    for (var value : values) {
      total += value;
    }
    return total;
  }

}
