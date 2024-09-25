package com.javaoop.programmer_zaman_now.java_dasar_master;
public class ForEach {
  public static void main(String[] args) {


    String[] names = {
        "Eko", "Kurniawan", "Khannedy",
        "Programmer", "Zaman", "Now"
    };

    for (var i = 0; i < names.length; i++){
      System.out.println(names[i]);
    }

    System.out.println("FOR EACH");

    for(String name: names){
      System.out.println(name);
    }
  }
}
