package com.javaoop.tugas.smt_3.project_akhir.main_project.util;

import java.util.Scanner;

public class InputUtil {
    // ENCAPSULATION
    private static Scanner scanner = new Scanner(System.in);

    InputUtil(){
        
    }

    public static String input(String info) {
        System.out.print(info + " : ");
        return scanner.nextLine();
    }
    
}
