package com.javaoop.programmer_zaman_now.java_oop.application;

import com.javaoop.programmer_zaman_now.java_oop.data.City;

public class LocationApp {
  public static void main(String[] args) {

    // var location = new Location(); // ERROR
    var city = new City();
    city.name = "Jakarta";

    System.out.println(city.name);

  }
}
