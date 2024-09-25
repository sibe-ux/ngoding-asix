package com.javaoop.programmer_zaman_now.java_oop;

class Manager extends Employee {

  String company;

  Manager(String name) {
    super(name);
  }

  Manager(String name, String company) {
    super(name);
    this.company = company;
  }

  void sayHello(String name) {
    System.out.println("Hi " + name + ", My Name Is Manager " + this.name);
  }

}