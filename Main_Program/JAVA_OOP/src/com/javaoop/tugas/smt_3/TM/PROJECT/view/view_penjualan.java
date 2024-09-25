/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javaoop.tugas.smt_3.TM.PROJECT.view;

import java.util.Scanner;

/**
 *
 * @author Istiyadi
 */
public class view_penjualan {

    boolean isSelesai;


    public void showPilihan() {
        isSelesai = false;
        String[] namaBarang = new String[30];
        String[] idBarang = new String[30];
        String[] jmlBarang = new String[30];
        int index = 0;
        int jmlItembarang = 0;

        boolean isLogout = false;

        while (!isLogout) {

            while (!isSelesai) {
                index = jmlItembarang;
                boolean isIdBarangIsOk = false;
                while (!isIdBarangIsOk) {
                    System.out.println("Pilih barang:");
                    System.out.println("1. BRS = Beras");
                    System.out.println("2. GL = Gula");
                    System.out.println("3. MG = Minyak Goreng");
                    System.out.println("4. Selesai input");
                    System.out.println("5. Kembali ke menu utama");
                    System.out.print("Masukkan pilihan nomor barang:");
                    Scanner sc = new Scanner(System.in);
                    String pilihanBarang = sc.next();
                    if (pilihanBarang.equals("1")) {
                        System.out.println("Beras");
                        idBarang[index] = pilihanBarang;
                        namaBarang[index] = "Beras";
                        isIdBarangIsOk = true;
                        index++;
                        jmlItembarang++;
                    } else if (pilihanBarang.equals("2")) {
                        System.out.println("Gula");
                        idBarang[index] = pilihanBarang;
                        namaBarang[index] = "Gula";
                        isIdBarangIsOk = true;
                        index++;
                        jmlItembarang++;
                    } else if (pilihanBarang.equals("3")) {
                        System.out.println("Minyak Goreng");
                        idBarang[index] = pilihanBarang;
                        namaBarang[index] = "Minyak Goreng";
                        isIdBarangIsOk = true;
                        index++;
                        jmlItembarang++;
                    } else if (pilihanBarang.equals("4")) {
                        isSelesai = true;
                        break;
                    } else if (pilihanBarang.equals("5")) {
                        isSelesai = true;
                        break;
                    } else {
                        System.out.println("Pilihan tidak sesuai");
                    }
                }

                index--;
                boolean isJmlBarangIsOk = false;
                while (!isJmlBarangIsOk && isIdBarangIsOk) {
                    System.out.print("masukkan jumlah barang:");
                    Scanner sc = new Scanner(System.in);
                    String pilihanBarang = sc.next();
                    boolean isNum = helper.isNumeric(pilihanBarang);
                    if (isNum) {
                        jmlBarang[index] = pilihanBarang;
                        index++;
                        isJmlBarangIsOk = true;
                    } else {
                        System.out.println("Pilihan tidak sesuai");
                    }
                }

                System.out.println("=================================");
                for (int a = 0; a < jmlItembarang; a++) {
                    System.out.println((a + 1) + " . " + namaBarang[a] + "\t\t" + jmlBarang[a]);
                }

                System.out.println("----------------------------------");

            }

            boolean isTotalSelesai = false;

            System.out.println("=================================");
            for (int a = 0; a < jmlItembarang; a++) {
                System.out.println((a + 1) + " . " + namaBarang[a] + "\t\t" + jmlBarang[a]);
            }

            System.out.println("----------------------------------");
            System.out.println("Total: ");
            System.out.println("----------------------------------");

            System.out.println("Pilihan ");
            System.out.println("1. Lanjutkan pembayaran berikutnya");
            System.out.println("2. Logout");
            System.out.print("Masukkan Pilihan: ");
            Scanner sc = new Scanner(System.in);
            String pilihan = sc.next();
            if (pilihan.equals("2")) {
                isLogout = true;
            } else {
                isSelesai = false;
                namaBarang = new String[30];
                idBarang = new String[30];
                jmlBarang = new String[30];
                index = 0;
                jmlItembarang = 0;

            }
        }// end isLogout
    }

    boolean mulaiTransaksi() {

        return isSelesai;
    }
}
