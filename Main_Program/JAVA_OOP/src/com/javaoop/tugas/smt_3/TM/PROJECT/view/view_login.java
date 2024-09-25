/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javaoop.tugas.smt_3.TM.PROJECT.view;


import java.util.Scanner;

import com.javaoop.tugas.smt_3.TM.PROJECT.models.login;

/**
 *
 * @author Istiyadi
 */
public class view_login {
    login lgn = new login();
    view_admin vAdmin = new view_admin();
    view_gudang vGudang = new view_gudang();
    view_kasir vKasir = new view_kasir();
    Scanner sc = new Scanner(System.in);

    private void showPilihan() {
        System.out.println("Pilih:");
        System.out.println("1. Login");
        System.out.println("2. Exit");
        System.out.print("Masukkan angka pilihan (1,2): ");
    }

    private boolean loginForm() {

//        view_penjualan vpj = new view_penjualan();
        Scanner sc = new Scanner(System.in);
        System.out.print("Masukkan username: ");
        String namaUser = sc.next();
        System.out.print("Masukkan password: ");
        String pswd = sc.next();
        boolean isLogin = lgn.loginUser(namaUser, pswd);
        if (isLogin) {
            System.out.println("Login berhasil");
            System.out.println("nama: " + lgn.nama);
            System.out.println("peran: " + lgn.peran);
//            System.out.println("idPeran: " +lgn.idPeran);
//            vpj.showPilihan();
        } else {
            System.out.println("Login gagal");
        }
        return isLogin;
    }

    public static void main(String[] args) {
        new view_login();
    }

    public view_login() {
        boolean isRunning = true;
        while (isRunning) {
            showPilihan();
            String s = sc.next();
            if(!helper.isNumeric(s))
            {
                System.out.println("Input pilihan tidak valid.");
                continue;
            }            
            
            int p = Integer.valueOf(s);
            switch (p) {
                case 1:
                    boolean isLoginSuccess = loginForm();
                    if (isLoginSuccess) {

                        switch (lgn.idPeran) {
                            case 1:
                                vAdmin.initData(lgn.nama, lgn.peran, lgn.idPeran, lgn.idPerson);
                                break;
                            case 2:
                                vGudang.initData(lgn.nama, lgn.peran, lgn.idPeran, lgn.idPerson);
                                break;
                            case 3:
                                vKasir.initData(lgn.nama, lgn.peran, lgn.idPeran, lgn.idPerson);
                                break;
                            default:
                                break;
                        }
                    }
                    break;
                case 2:
                    System.out.println("Aplikasi exit...");
                    isRunning = false;
                    break;
                default:
                    System.out.println("Pilihan tidak sesuai\n------------");
                    break;
            }
//            } else if (s.equals("2")) {
//                isRunning = false;
//                System.out.println("Aplikasi exit...");
//            } else {
//                System.out.println("Pilihan tidak sesuai\n------------");
//            }
        }
    }
}
