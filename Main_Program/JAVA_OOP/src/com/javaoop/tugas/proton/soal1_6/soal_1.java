package com.javaoop.tugas.proton.soal1_6;
import java.io.*;
public class soal_1 {
    public static void main(String[] args) {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        try{
            System.out.print("Input Number : ");
            int number = Integer.parseInt(input.readLine());
            for (int x=number;x>=1;x--){
                for(int z=number;z>=x;z--){
                    System.out.print(z);
                }
                System.out.println("");
            }
        } catch (IOException exception) {
            System.out.println("Error input!");
        }
    }
}
