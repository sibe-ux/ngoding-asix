package com.javaoop.programmer_zaman_now.java_dasar_master;
public class TernaryOperator {
  public static void main(String[] args) {


    var nilai = 75;
    String ucapan = nilai >= 75 ? "Selamat Anda Lulus" : "Silahkan Coba lagi";

    var belum = "false";
    String sudah = belum.equals("sudah") ? "salah" : "benar";

    System.out.println(sudah);
    System.out.println(ucapan);

  }
}
