package com.javaoop.programmer_zaman_now.java_oop;

class VicePresident extends Manager {

  VicePresident(String name){
    super(name);
  }

  void sayHello(String name){
    System.out.println("Hi " + name + ", My Name Is VP " + this.name);
  }

}
