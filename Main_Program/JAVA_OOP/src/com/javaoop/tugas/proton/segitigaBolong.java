package com.javaoop.tugas.proton;
import java.util.Scanner;
public class segitigaBolong {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try{
            System.out.print("Numb : ");
            int numb = scanner.nextInt();
            for(int x=0;x<numb;x++){
                for(int y=2;y<=numb-x;y++){
                    System.out.print("* ");
                }
                System.out.print("*");
                for(int z=0;z<=x*2;z++){
                    System.out.print("  ");
                }
                for(int a=1;a<=numb-x;a++){
                    System.out.print(" *");
                }
                System.out.println();
            }
            for(int x=0;x<numb;x++){
                for(int y=numb-1;y>=numb-x;y--){
                    System.out.print("* ");
                }
                System.out.print("*");
                for(int z=1;z<=numb-x;z++){
                    System.out.print("  ");
                }
                for(int z=2;z<=numb-x;z++){
                    System.out.print("  ");
                }
                for(int y=numb;y>=numb-x;y--){
                    System.out.print(" *");
                }    
                System.out.println();
            }
        } finally{
            scanner.close();
        }
    }
}
