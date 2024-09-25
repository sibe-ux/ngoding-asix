package com.javaoop.programmer_zaman_now.java_oop.data;

import com.javaoop.programmer_zaman_now.java_oop.annotation.Fancy;

@Fancy(name = "Car", tags = {"application", "java"})
public interface Car extends HasBrand, IsMaintenance {

  void drive();

  int getTier();

  default boolean isBig() {
    return false;
  }

}
