package com.javaoop.programmer_zaman_now.java_oop;

class Shape {

  int getCorner(){
    return 0;
  }

}

class Rectangle extends Shape {

  int getCorner(){
    return 4;
  }

  int getParentCorner(){
    return super.getCorner();
  }

}
