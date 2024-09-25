package com.javaoop.programmer_zaman_now.java_oop.application;

import java.io.BufferedReader;
import java.io.FileReader;
// import java.io.IOException;

public class ReadApp {
  public static void main(String[] args) {
    var directory = "G:/.shortcut-targets-by-id/1GLhesaekxPRKr-lkNYX-mtfouqJhqhXN/DCIM/KULIAH/00 - UNEJ/PEMROGRAMAN/My Program/JAVA_OOP/src/com/javaoop/belajar_java_oop_master/README.md";
    try (BufferedReader reader = new BufferedReader(new FileReader(directory))) {

      while (true) {
        String line = reader.readLine();
        if (line == null) {
          break;
        }
        System.out.println(line);
      }

    } catch (Throwable throwable) {
      System.out.println("Error membaca file " + throwable.getMessage());
    }

  }
}
