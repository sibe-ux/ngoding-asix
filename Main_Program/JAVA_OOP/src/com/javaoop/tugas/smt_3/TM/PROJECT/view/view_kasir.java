/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javaoop.tugas.smt_3.TM.PROJECT.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.javaoop.tugas.smt_3.TM.PROJECT.models.*;

/**
 *
 * @author Istiyadi
 */
public class view_kasir {

    String nama;
    String peran;
    int idPeran, idPerson;
    boolean isLogout = false;
    barang brg = new barang();
    transaksiPenjualan tpj = new transaksiPenjualan();
    Scanner sc = new Scanner(System.in);

    public int pilihMenu() {
        System.out.println("Pilihan kasir");
        System.out.println("1. Transaksi Penjualan ");
        System.out.println("2. Lihat stok ");
        System.out.println("3. Rekap transaksi ");
        System.out.println("0. Logout ");
        System.out.print("Masukkan Pilihan (0,1,2,3):");
//        Scanner sc = new Scanner(System.in);
        int pilihan = sc.nextInt();
        return pilihan;
    }

    public void initData(String nama, String peran, int idPeran, int idPerson) {
        this.nama = nama;
        this.peran = peran;
        this.idPeran = idPeran;
        this.idPerson = idPerson;
        this.mainView();
    }

    public int showPenjualanBarang() {
//        isSelesai = false;
        isLogout = false;
        String[] namaBarang = new String[30];
        int[] idBarang = new int[30];
        double[] jmlBarang = new double[30];
        int index = 0;
        int jmlItembarang = 0;

        boolean isEndInputJual = false;
        while (!isEndInputJual) {
            boolean isInputBrgNJmlSls = false;
            while (!isInputBrgNJmlSls) {
                index = jmlItembarang;
                boolean isInputNamaBrgSelesai = false;
                while (!isInputNamaBrgSelesai) {
                    System.out.println("Pilih barang:");
                    System.out.println("1. BRS = Beras");
                    System.out.println("2. GL = Gula");
                    System.out.println("3. MG = Minyak Goreng");
                    System.out.println("4. Selesai input (ke total pembayaran)");
                    System.out.println("5. Kembali ke menu sebelumnya (batal)");
                    System.out.print("Masukkan pilihan nomor barang (1,2,3,4,5):");
//                    Scanner sc = new Scanner(System.in);
                    int pilihanBarang = sc.nextInt();
                    switch (pilihanBarang) {
                        case 1:
                            System.out.println("Beras");
                            idBarang[index] = pilihanBarang;
                            namaBarang[index] = "Beras";
                            isInputNamaBrgSelesai = true;

                            System.out.print("Masukkan jumlah  " + namaBarang[index] + " (kg): ");
                            jmlBarang[index] = sc.nextDouble();

                            index++;
                            jmlItembarang++;
                            break;
                        case 2:
                            System.out.println("Gula");
                            idBarang[index] = pilihanBarang;
                            namaBarang[index] = "Gula";
                            isInputNamaBrgSelesai = true;
                            System.out.print("Masukkan jumlah  " + namaBarang[index] + " (kg): ");
                            jmlBarang[index] = sc.nextDouble();

                            index++;
                            jmlItembarang++;
                            break;
                        case 3:
                            System.out.println("Minyak Goreng");
                            idBarang[index] = pilihanBarang;
                            namaBarang[index] = "Minyak Goreng";
                            isInputNamaBrgSelesai = true;
                            System.out.print("Masukkan jumlah  " + namaBarang[index] + " (Liter): ");
                            jmlBarang[index] = sc.nextDouble();

                            index++;
                            jmlItembarang++;
                            break;
                        case 4:
                            if (jmlItembarang > 0) {
                                isInputNamaBrgSelesai = true;
                                isInputBrgNJmlSls = true;
                            } else {
                                System.out.println("Belum ada barang di entrikan..!");
                            }
                            break;
                        case 5:
                            isInputNamaBrgSelesai = false;
                            isEndInputJual = true;
                            isInputBrgNJmlSls = true;
                            return -1;
//                            break;
                    }
                }

                System.out.println("=================================");
                for (int a = 0; a < jmlItembarang; a++) {
                    System.out.println((a + 1) + " . " + namaBarang[a] + "\t\t" + jmlBarang[a]);
                }

                System.out.println("----------------------------------");

            }

//            boolean isTotalSelesai = false;
            System.out.println("=================================");
            double total = 0;
            for (int a = 0; a < jmlItembarang; a++) {
                double hargaJual = brg.getHargaBarangSatuan(Integer.valueOf(idBarang[a]));
                double subTotal = hargaJual * Double.valueOf(jmlBarang[a]);
                System.out.println((a + 1) + " . " + namaBarang[a] + "\t\t" + jmlBarang[a]
                        + "\t\t" + String.format("%,.2f", hargaJual) + "\t\t" + String.format("%,.2f", subTotal));
                total += subTotal;
            }

            System.out.println("----------------------------------");
            System.out.println("Total Rp " + String.format("%,.2f", total));
            System.out.println("----------------------------------");

            System.out.println("Pilihan ");
            System.out.println("1. Masukkan uang pembayaran");
            System.out.println("2. Batalkan transaksi");
//            System.out.println("3. Logout");
            System.out.print("Masukkan Pilihan (1,2): ");
//            Scanner sc = new Scanner(System.in);
            int pilihan = sc.nextInt();

            switch (pilihan) {
                case 1:
                    int uangPembayaran = 0;
                    double uangKembalian = 0;
                    while (uangPembayaran < total) {
                        System.out.print("Masukkan uang pembayaran Rp ");
                        uangPembayaran = sc.nextInt();
                        uangKembalian = uangPembayaran - total;

                        if (uangPembayaran < total) {
                            System.out.println("Jumlah uang pembayaran tidak cukup.");
                        }

                    }

                    System.out.println("Kembalian Rp " + String.format("%,.2f", uangKembalian));
                    System.out.println("----------------------------------");
//                isSelesai = false;
                    System.out.print("Tekan Enter untuk selesai transaksi");
                    new Scanner(System.in).nextLine();
                    // Simpan database
//                simpanTransaksiPenjualan(String[] idBarang, int[] jmlBarang, int idPerson)
                    tpj.simpanTransaksiPenjualan(idBarang, jmlBarang, this.idPerson, jmlItembarang);

                    isInputBrgNJmlSls = false;
                    namaBarang = new String[30];
                    idBarang = new int[30];
                    jmlBarang = new double[30];
                    index = 0;
                    jmlItembarang = 0;
                    System.out.println("\nSelesai transaksi pembelian barang.");
                    System.out.println("=============================================\n\n");
                    break;

                case 2:
                    isInputBrgNJmlSls = false;
                    namaBarang = new String[30];
                    idBarang = new int[30];
                    jmlBarang = new double[30];
                    index = 0;
                    jmlItembarang = 0;

                    break;
            }

        }// end isEndInputJual

        return -1;
    }

    public void mainView() {
        while (!isLogout) {
            int pilihan = pilihMenu();
            switch (pilihan) {
                case 1:
                    showPenjualanBarang();
                    break;
                case 2:
//                    tampilkanStokBarang();
                    ArrayList lstField = brg.listField();
                    ArrayList lstBrg = brg.listStokBarang();
                    helper.displayTabel(lstField, lstBrg);
                    
//                    System.out.println("-------------------------------------");
//                    for (int a = 0; a < lstBrg.size(); a++) {
//                        if (a == 0) {
//                            for (int b = 0; b < lstField.size(); b++) {
//                                System.out.print(lstField.get(b) + "\t");
//                            }
//                            System.out.println("\n-------------------------------------");
//                        }
//
//                        System.out.print(lstBrg.get(a) + "\t");
//
//                        if ((a + 1) % lstField.size() == 0) {
//                            System.out.println("");
//                        }
//                    }
//                    System.out.println("-------------------------------------");
                    break;
                case 0:
                    isLogout = true;
                    break;

            }
        }
    }
}
