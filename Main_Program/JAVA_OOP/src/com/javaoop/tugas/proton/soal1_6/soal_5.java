package com.javaoop.tugas.proton.soal1_6;
import java.io.*;
public class soal_5 {
    public static void main(String[] args) {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        try{
            System.out.print("Input Number : ");
            int number = Integer.parseInt(input.readLine());
            for(int x=1;x<=number;x++){
                if(x%2!=0){
                    for(int b=1;b<=x-1;b++){
                        System.out.print(" ");
                    }
                    for(int z=number;z>=x;z--){
                        System.out.print(z);
                    }
                } else{
                    for(int b=1;b<=x-1;b++){
                        System.out.print(" ");
                    }
                    for(int z=1;z<=number-(x-1);z++){
                        System.out.print("*");
                    }
                }
                System.out.println("");
            }
        } catch (IOException exception) {
            System.out.println("Error input!");
        }
    }
}
