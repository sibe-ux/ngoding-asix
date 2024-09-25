package com.javaoop.programmer_zaman_now.java_oop;

class Parent {
  String name;
  void doIt(){
    System.out.println("Do it in parent");
  }
}

class Child extends Parent{
  String name;
  void doIt(){
    System.out.println("Do it in child");
    System.out.println("Parent name is " + super.name);
  }
}
