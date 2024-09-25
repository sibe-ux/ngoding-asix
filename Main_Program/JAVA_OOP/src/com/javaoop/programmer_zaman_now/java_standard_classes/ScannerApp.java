package com.javaoop.programmer_zaman_now.java_standard_classes;

import java.util.Scanner;

public class ScannerApp {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    try {

      System.out.print("Nama : ");
      String name = scanner.nextLine();

      System.out.print("Umur : ");
      Integer age = scanner.nextInt();

      System.out.println("Hello " + name + " umur anda adalah " + age);
    } finally {
      scanner.close();
    }

  }
}
