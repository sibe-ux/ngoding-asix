package com.javaoop.programmer_zaman_now.java_standard_classes;

public class NumberApp {
  public static void main(String[] args) {


    Integer intValue = 10;

    Long longValue = intValue.longValue();
    Double doubleValue = longValue.doubleValue();
    Short shortValue = doubleValue.shortValue();

    System.out.println(shortValue);
    String contoh = "100.10";

    Double contohInt = Double.valueOf(contoh);
    System.out.println(contohInt);

  }
}
