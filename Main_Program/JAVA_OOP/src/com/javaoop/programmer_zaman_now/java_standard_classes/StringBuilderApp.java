package com.javaoop.programmer_zaman_now.java_standard_classes;

public class StringBuilderApp {
  public static void main(String[] args) {

    StringBuilder builder = new StringBuilder();
    builder.append("Eko");
    builder.append(" ");
    builder.append("Kurniawan");
    builder.append(" ");
    builder.append("Khannedy");

    String name = builder.toString();
    System.out.println(name);

  }
}
