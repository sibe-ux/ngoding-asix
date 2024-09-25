package com.javaoop.programmer_zaman_now.java_oop.application;

import com.javaoop.programmer_zaman_now.java_oop.annotation.Fancy;
import com.javaoop.programmer_zaman_now.java_oop.data.Animal;
import com.javaoop.programmer_zaman_now.java_oop.data.Cat;

@Fancy(name = "AnimalApp", tags = {"application", "java"})
public class AnimalApp {
  public static void main(String[] args) {


    Animal animal = new Cat();
    animal.name = "Puss";
    animal.run();

  }
}
