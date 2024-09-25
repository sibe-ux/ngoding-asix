package com.javaoop.tugas.smt_3.project_akhir.main_project.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConfirmUtil {
    private static String input;
    BufferedReader inputt = new BufferedReader(new InputStreamReader(System.in));
    public ConfirmUtil(){
        try{
            String p = inputt.readLine();
            ConfirmUtil.input = p;
        } catch(IOException e){
            System.out.println("error");
        }
    }

    public static String getInput(){
        return ConfirmUtil.input;
    }
}
