package com.javaoop.tugas.proton.soal1_6;
import java.io.*;
public class soal_4 {
    public static void main(String[] args) {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        try{
            System.out.print("Input Number : ");
            int number = Integer.parseInt(input.readLine());
            int hasil=0;
            for (int x=1;x<=number;x++){
                if (x%3==0){
                    hasil-=x*2;
                } else{
                    hasil+=x*2;
                }
            }
            System.out.println(hasil);
        } catch (IOException exception) {
            System.out.println("Error input!");
        }
    }
}
