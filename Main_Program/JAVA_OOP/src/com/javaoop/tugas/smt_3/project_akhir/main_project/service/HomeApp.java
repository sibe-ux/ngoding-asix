package com.javaoop.tugas.smt_3.project_akhir.main_project.service;

import com.javaoop.tugas.smt_3.project_akhir.main_project.repository.GuruRepoImpl;
import com.javaoop.tugas.smt_3.project_akhir.main_project.repository.SiswaRepoImpl;
import com.javaoop.tugas.smt_3.project_akhir.main_project.util.ClearScreenUtil;
import com.javaoop.tugas.smt_3.project_akhir.main_project.util.ConfirmUtil;

import org.apache.commons.lang3.StringUtils;

public class HomeApp {

    public void guess(){
        ClearScreenUtil.ClearConsole();
        System.out.println("------------------------------");
        System.out.println("        * RankerIn *");
        System.out.println("------------------------------\n");
        System.out.println("[1] Guru");
        System.out.println("[2] Siswa\n"); 
        System.out.println("[0] Exit");
        System.out.println("\n------------------------------");
        System.out.print("\nPilih Aktor :: ");
    }

    public static void menuGuru(){
        boolean exit = false;
        while(exit != true){
            ClearScreenUtil.ClearConsole();
            System.out.println("------------------------------");
            System.out.println("           * GURU *");
            System.out.println("------------------------------\n");
            System.out.println("[1] Register");
            System.out.println("[2] Login\n");
            System.out.println("[0] Kembali");
            System.out.println("\n------------------------------");
            System.out.print("\nPilih menu :: ");
            new ConfirmUtil();
            if(!StringUtils.isNumeric(ConfirmUtil.getInput())){
                System.out.println("Perintah tidak ditemukan");
                System.out.print("\nTekan sembarang untuk kembali!");
                new ConfirmUtil();
                ClearScreenUtil.ClearConsole();
                continue;
            }

            switch(ConfirmUtil.getInput()){
                case "1":
                new RegisterApp("Guru", new GuruRepoImpl(), new SiswaRepoImpl());
                exit = true;
                break;

                case "2" :
                new LoginApp("Guru");
                exit = true;
                break;

                case "0":
                ClearScreenUtil.ClearConsole();
                new StartingApp(new HomeApp());
                exit = true;
                break;

                default:
                System.out.println("Perintah tidak ditemukan!");
                System.out.print("\nTekan enter untuk kembali!");
                new ConfirmUtil();
                ClearScreenUtil.ClearConsole();
            } 
        }
    }

    public static void menuSiswa(){
        boolean exit = false;
        while(exit != true){
            ClearScreenUtil.ClearConsole();
            System.out.println("------------------------------");
            System.out.println("           * SISWA *");
            System.out.println("------------------------------\n");
            System.out.println("[1] Register");
            System.out.println("[2] Login\n");
            System.out.println("[0] Kembali");
            System.out.println("\n------------------------------");
            System.out.print("\nPilih menu :: ");
            new ConfirmUtil();
            if(!StringUtils.isNumeric(ConfirmUtil.getInput())){
                System.out.println("Perintah tidak ditemukan");
                System.out.print("\nTekan sembarang untuk kembali!");
                new ConfirmUtil();
                ClearScreenUtil.ClearConsole();
                continue;
            }

            switch(ConfirmUtil.getInput()){
                case "1":
                // KOMPOSISI
                new RegisterApp("Siswa", new GuruRepoImpl(), new SiswaRepoImpl());
                exit = true;
                break;

                case "2" :
                new LoginApp("Siswa");
                exit = true;
                break;

                case "0":
                ClearScreenUtil.ClearConsole();
                new StartingApp(new HomeApp());
                exit = true;
                break;

                default:
                System.out.println("Perintah tidak ditemukan!");
                System.out.print("\nTekan enter untuk kembali!");
                new ConfirmUtil();
                ClearScreenUtil.ClearConsole();
            } 
        }
    }
}
