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
public class view_gudang {

    String nama;
    String peran;
    int idPeran;
    int idPerson;
    boolean isLogout = false;
    barang brg = new barang();
    Scanner sc = new Scanner(System.in);

    public int pilihMenu() {
        System.out.println("Pilihan gudang");
        System.out.println("1. Input barang ");
        System.out.println("2. Lihat stok ");
        System.out.println("0. Logout ");
        System.out.print("Masukkan Pilihan transaksi (0,1,2):");

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

    public void mainView() {
        isLogout = false;
        while (!isLogout) {
            int pilihan = pilihMenu();
            switch (pilihan) {
                case 1:
                    tambahBarangMasuk();
                    break;
                case 2:
                    tampilkanStokBarang();
                    break;
                case 0:
                    isLogout = true;
                    break;

            }
        }
    }

    private void tampilkanStokBarang() {
        ArrayList lstField = brg.listField();
        ArrayList lstBrg = brg.listStokBarang();
        helper.displayTabel(lstField, lstBrg);
    }

    private void tambahBarangMasuk() {
        int[] idBarang = {1, 2, 3};
        System.out.println("Pilih Barang masuk: ");
        System.out.println("1. BRS = Beras");
        System.out.println("2. GL = Gula");
        System.out.println("3. MG = Minyak Goreng");
        System.out.print("Masukkan angka pilihan (1,2,3): ");
        int pilih = sc.nextInt();
        int vIdBarang = idBarang[pilih - 1];
        brg.setIdBarang(vIdBarang);

        System.out.print("Masukkan jumlah barang: ");
        double vJmlBrg = sc.nextDouble();
        brg.setJumlahBarangMasuk(vJmlBrg);

//        System.out.println("Masukkan satuan barang:");
//        System.out.println("1. Kg");
//        System.out.println("2. Liter");
//        System.out.print("Pilih satuan barang (1,2): ");
//        pilih = sc.nextInt();
//        String satuanBrg = "Kg";
//        if (pilih == 2) {
//            satuanBrg = "Liter";
//        }
//        brg.setSatuanBarang(satuanBrg);

        System.out.print("Masukkan Harga satuan Rp ");
        double vHargaSatuan = sc.nextDouble();
        brg.setHargaBeliSatuan(vHargaSatuan);

        brg.simpanBarangMasuk(idPerson);
    }
}
