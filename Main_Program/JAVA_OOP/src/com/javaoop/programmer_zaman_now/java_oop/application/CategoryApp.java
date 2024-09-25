package com.javaoop.programmer_zaman_now.java_oop.application;

import com.javaoop.programmer_zaman_now.java_oop.data.Category;

public class CategoryApp {
  public static void main(String[] args) {


    var category = new Category();
    category.setId("ID");
    category.setId(null);

    System.out.println(category.getId());

  }
}
