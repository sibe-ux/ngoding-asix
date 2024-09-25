package com.javaoop.java_dasar;

import java.util.Scanner;

public class factorial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try{
            System.out.print("numb : ");
            int faktor = scanner.nextInt();
            int hasil=1;
            for(int x=faktor;x>=1;x--){
                hasil*=x;
            }
            System.out.println(faktor+"! : "+hasil);
        } finally {
            scanner.close();
        }
    }
}
