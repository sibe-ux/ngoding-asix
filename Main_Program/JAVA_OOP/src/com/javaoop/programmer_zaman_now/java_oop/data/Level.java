package com.javaoop.programmer_zaman_now.java_oop.data;

import com.javaoop.programmer_zaman_now.java_oop.annotation.Fancy;

@Fancy(name = "AnimalApp", tags = {"application", "java"})
public enum Level {
  STANDARD("Standard Level"),
  PREMIUM("Premium Level"),
  VIP("VIP Level");

  private String description;

  Level(String description){
    this.description = description;
  }

  public String getDescription() {
    return description;
  }

  public static Level valLevel(String string) {
    return null;
  }
}
