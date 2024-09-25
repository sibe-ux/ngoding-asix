package com.javaoop.programmer_zaman_now.java_oop;

class Employee {

  String name;

  Employee(String name) {
    this.name = name;
  }

  void sayHello(String name) {
    System.out.println("Hi " + name + ", My Name Is Employee " + this.name);
  }
}
