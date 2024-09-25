package com.javaoop.tugas.proton.soal1_6;
import java.io.*;
public class soal_2 {
    public static void main(String[] args) {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        try{
            System.out.print("Input Number : ");
            int number = Integer.parseInt(input.readLine());
            double hasil = 5;
            for(int x = 1;x<=number;x++){
                if (x==1){
                    // System.out.println(5);
                    continue;
                } else{
                    hasil*=0.5;
                    // System.out.println(hasil);
                }
            }
            System.out.println(hasil);

        } catch (IOException exception) {
            System.out.println("Error input!");
        }
    }
    
}
