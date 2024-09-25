package com.javaoop.programmer_zaman_now.java_standard_classes;

public class StringApp {
  public static void main(String[] args) {

    String name = "Eko Kurniawan Khannedy";
    String nameLowercase = name.toLowerCase();
    String nameUppercase = name.toUpperCase();


    System.out.println(name);
    System.out.println(nameLowercase);
    System.out.println(nameUppercase);
    System.out.println(name.length());
    System.out.println(name.startsWith("Eko"));
    System.out.println(name.endsWith("Khannedy"));

    String[] names = name.split(" ");
    for(var value : names){
      System.out.println(value);
    }

    System.out.println(" ".isBlank());
    System.out.println(" ".isEmpty());
    System.out.println("".isEmpty());
    System.out.println(name.charAt(0));

    // char[] chars = name.toCharArray();

  }
}
