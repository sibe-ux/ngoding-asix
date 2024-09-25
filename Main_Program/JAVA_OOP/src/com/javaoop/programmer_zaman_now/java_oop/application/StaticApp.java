package com.javaoop.programmer_zaman_now.java_oop.application;

import static com.javaoop.programmer_zaman_now.java_oop.data.Application.PROCESSORS;
import static com.javaoop.programmer_zaman_now.java_oop.data.Constant.*;

import com.javaoop.programmer_zaman_now.java_oop.data.Country;
import com.javaoop.programmer_zaman_now.java_oop.util.MathUtil;

public class StaticApp {
  public static void main(String[] args) {

    System.out.println(APPLICATION);
    System.out.println(VERSION);

    System.out.println(
        MathUtil.sum(1,1,1,1,1)
    );

    Country.City city = new Country.City();
    city.setName("Subang");

    System.out.println(city.getName());

    System.out.println(PROCESSORS);
  }
}
