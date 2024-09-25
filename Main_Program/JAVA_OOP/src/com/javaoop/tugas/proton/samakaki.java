package com.javaoop.tugas.proton;
import java.util.Scanner;
public class samakaki {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try{
            System.out.print("n : ");
            int n = scanner.nextInt();
            if(n==1){
                for(int x =1;x<n;x++){
                    System.out.print(" ");
                }
                System.out.println("*");
            } else{
                for(int x =1;x<n;x++){
                    System.out.print(" ");
                }
                System.out.println("*");
                for(int x = 1;x<=n-2;x++){
                    for(int z =n-x-2;z>=0;z--){
                        System.out.print(" ");
                    }
                    System.out.print("*");
                    for(int y=1;y<=x+(x-1);y++){
                        System.out.print(" ");
                    }
                    System.out.println("*");
                }
                for(int x =1;x<=n;x++){
                    System.out.print("* ");
                }
            }
            System.out.println("\njumlah bintang = "+(n+(2*(n-2))+1));
        } finally{
            scanner.close();
        }
    }
}
