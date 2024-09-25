package com.javaoop.programmer_zaman_now.java_oop.data;

public class Avanza implements Car{

  public void drive() {
    System.out.println("Avanza drive");
  }

  public int getTier() {
    return 4;
  }

  public String getBrand() {
    return "Toyota";
  }

  public boolean isMaintenance() {
    return false;
  }
}
