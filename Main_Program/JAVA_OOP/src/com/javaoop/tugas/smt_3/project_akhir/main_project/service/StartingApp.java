package com.javaoop.tugas.smt_3.project_akhir.main_project.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.javaoop.tugas.smt_3.project_akhir.main_project.util.ClearScreenUtil;

import org.apache.commons.lang3.StringUtils;

public class StartingApp {
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    // COMPOSITION
    public StartingApp(HomeApp home){
        boolean exit = false;
        while(!exit){
            home.guess();
            try{
                String inputMenu = input.readLine();
                if(!StringUtils.isNumeric(inputMenu)){
                    System.out.println("Perintah tidak ditemukan");
                    System.out.print("\nTekan sembarang untuk kembali!");
                    input.readLine();
                    ClearScreenUtil.ClearConsole();
                    continue;
                }

                switch(inputMenu){
                    case "1":
                    HomeApp.menuGuru();
                    exit = true;
                    break;

                    case "2" :
                    HomeApp.menuSiswa();
                    exit = true;
                    break;

                    case "0":
                    ClearScreenUtil.ClearConsole();
                    System.out.println("App Clossed!");
                    System.exit(0);
                    exit = true;
                    break;

                    default:
                    System.out.println("Perintah tidak ditemukan!");
                    System.out.print("\nTekan enter untuk kembali!");
                    input.readLine();
                    ClearScreenUtil.ClearConsole();
                } 
            } catch (IOException e) {
                System.out.println("error input");
            }
        }
    }
}
