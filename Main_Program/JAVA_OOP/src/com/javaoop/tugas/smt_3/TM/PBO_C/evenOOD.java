package com.javaoop.tugas.smt_3.TM.PBO_C;

import java.io.*;

public class evenOOD {

  public static void main(String[] args) {
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    try {
      System.out.print("Input Number : ");
      int number = Integer.parseInt(input.readLine());
      int hasil = number % 2;
      if (hasil == 0) {
        System.out.print("This number is even");
      } else {
        System.out.print("This number is odd");
      }
    } catch (IOException exception) {
      System.out.println("Error input!");
      // 235872098375209385723985235
    }
  }
}