package com.javaoop.tugas.smt_3.project_akhir.main_project.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.apache.commons.lang3.StringUtils;

public class ValidationUtil {
    // ENKAPSULASI
    private static BufferedReader in = 
    new BufferedReader(new InputStreamReader(System.in));

    public static int inputInteger(String kalimat, int range, int test){
        var exit = false;
        var result = 0; 
        var testing = 1;
        while(!exit){
            try{
                System.out.print(kalimat);
                String input = in.readLine();
                if ((StringUtils.isNumeric(input) == true)){
                    if ((Integer.parseInt(input)<=range) 
                    && (Integer.parseInt(input)>0) ||
                    (Integer.parseInt(input)==0)){
                        int hasil = Integer.parseInt(input);
                        result = hasil;
                        testing = test;
                        exit = true;
                        break;
                    } else{
                        System.out.println("$$$< Input tidak ditemukan! (1-"
                    +range+") >$$$");
                    continue;
                    }
                } 
                else{
                    System.out.println("!!!< Data harus berupa angka >!!!");
                    continue;
                }
            } catch (IOException e){
                System.out.println("!!!< Data harus berupa angka >!!!");
            }
        }
        return result;
    }

    // OVERLOADING
    public static int inputInteger(String kalimat, int range){
        var exit = false;
        var result = 0; 
        while(!exit){
            try{
                System.out.print(kalimat);
                String input = in.readLine();
                if ((StringUtils.isNumeric(input) == true)){
                    if ((Integer.parseInt(input)<=range) 
                    && (Integer.parseInt(input)>0)){
                        int hasil = Integer.parseInt(input);
                        result = hasil;
                        exit = true;
                        break;
                    } else{
                        System.out.println("$$$< Input tidak ditemukan! (1-"
                    +range+") >$$$");
                    continue;
                    }
                } 
                else{
                    System.out.println("!!!< Data harus berupa angka >!!!");
                    continue;
                }
            } catch (IOException e){
                System.out.println("!!!< Data harus berupa angka >!!!");
            }
        }
        return result;
    }

    // OVERLOADING METHOD
    public static int inputInteger(String kalimat){
        var exit = false;
        var result = 0; 
        while(exit == false){
            try{
                System.out.print(kalimat);
                String input = in.readLine();
                if (StringUtils.isNumeric(input) == true){
                    int hasil = Integer.parseInt(input);
                    result = hasil;
                    exit = true;
                    break;
                } else{
                    System.out.println("!!!< Data harus berupa angka >!!!");
                    continue;
                }
            } catch (IOException e){
                System.out.println("!!!< Data harus berupa angka >!!!");
            }
        }
        return result;
    }

    public static String inputString(String kalimat){
        var result = "";
        try {
            System.out.print(kalimat);
            String input = in.readLine();
            result = input.toLowerCase();
        } catch (Exception e) {
            //TODO: handle exception
            System.out.println("input error");
        }
        return result;
    }

    public String inputYesNo(String kalimat){
        var result = "";
        try {
            var exit = false;
            while(exit == false){
                System.out.print(kalimat);
                String input = in.readLine();

                if (input.toLowerCase().equals("y")){
                    result = input;
                    exit = true;
                    break;
                } else if (input.toLowerCase().equals("t")){
                    result = input;
                    exit = true;
                    break;
                } else{
                    System.out.println("Perintah tidak ditemukan! Mohon ulangi!");
                    continue;
                }
            }
            
        } catch (Exception e) {
            //TODO: handle exception
        }
        return result;
    }
}
