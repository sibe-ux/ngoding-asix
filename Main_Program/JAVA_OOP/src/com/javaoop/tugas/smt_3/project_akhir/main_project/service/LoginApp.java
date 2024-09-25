package com.javaoop.tugas.smt_3.project_akhir.main_project.service;

import java.util.Scanner;

import com.javaoop.tugas.smt_3.project_akhir.main_project.repository.DataRepository;
import com.javaoop.tugas.smt_3.project_akhir.main_project.util.ClearScreenUtil;

public class LoginApp {
    Scanner in = new Scanner(System.in);
    // CONSTRUCTOR
    public LoginApp(String aktor){
        if (aktor.equalsIgnoreCase("guru")){
            ClearScreenUtil.ClearConsole();
            System.out.println("------------------------------");
            System.out.println("        * LOGIN GURU*");
            System.out.println("------------------------------\n");
            System.out.print(" -> Username : ");
            String username = in.nextLine();
            System.out.print(" -> Password : ");
            String password = in.nextLine();
            System.out.println("\n------------------------------");
            readDataLogin(username, password,aktor);
        } else{
            ClearScreenUtil.ClearConsole();
            System.out.println("------------------------------");
            System.out.println("       * LOGIN SISWA*");
            System.out.println("------------------------------\n");
            System.out.print(" -> Username : ");
            String username = in.nextLine();
            System.out.print(" -> Password : ");
            String password = in.nextLine();
            System.out.println("\n------------------------------");
            readDataLogin(username, password,aktor);
        }
    }

    public void readDataLogin(String user, String pass,String aktor){
        DataRepository dataRepo = new DataRepository() {};
        dataRepo.readLogin(user,pass,aktor);
    }
    
}
