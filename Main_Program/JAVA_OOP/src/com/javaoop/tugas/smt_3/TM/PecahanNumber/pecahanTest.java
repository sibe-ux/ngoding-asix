package com.javaoop.tugas.smt_3.TM.PecahanNumber;

public class pecahanTest{
  public static void main(String[] args) {
      pecahan A = new pecahan(2,3);
      pecahan B = new pecahan (1,3);
      A.cetakLayar();
      B.cetakLayar();
      
      System.out.println("======= PERKALIAN ========");
      double x1 = A.dikalikan1(B);
      System.out.println(x1);
      pecahan C1 = A.dikalikan2(B);
      C1.sederhana();
      
      System.out.println("\n======= PENJUMLAHAN ========");
      double x2 = A.penjumlahan1(B);
      System.out.println(x2);
      pecahan C2 = A.penjumlahan2(B);
      C2.sederhana();

      System.out.println("\n======= PENGURANGAN ========");
      double x3 = A.pengurangan1(B);
      System.out.println(x3);
      pecahan C3 = A.pengurangan2(B);
      C3.sederhana();

      System.out.println("\n======= PEMBAGIAN ========");
      double x = A.pembagian1(B);
      System.out.println(x);
      pecahan C = A.pembagian2(B);
      C.sederhana();
      
}
}
