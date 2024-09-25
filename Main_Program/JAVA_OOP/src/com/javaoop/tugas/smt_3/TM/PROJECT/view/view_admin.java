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
public class view_admin {

    
    String nama;
    String peran;
    int idPeran;
    int idPerson;
    boolean isLogout = false;
    barang brg = new barang();

    public int pilihMenu() {
        System.out.println("Pilihan Admin");
        System.out.println("1. Tambah user ");
        System.out.println("2. Lihat stok ");
        System.out.println("3. Lihat penjualan ");
        System.out.println("0. Logout ");
        System.out.print("Masukkan Pilihan (0,1,2,3):");
        Scanner sc = new Scanner(System.in);
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
        while (!isLogout) {
            int pilihan = pilihMenu();
            switch (pilihan) {
                case 2:
//                    tampilkanStokBarang();
                    ArrayList lstField = brg.listField();
                    ArrayList lstBrg = brg.listStokBarang();
                    helper.displayTabel(lstField, lstBrg);
//
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
