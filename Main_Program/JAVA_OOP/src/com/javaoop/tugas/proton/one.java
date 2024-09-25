package com.javaoop.tugas.proton;
import java.io.*;
public class one {
    public static void main(String[] args) {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        try {
            // 1/5 - 10 + 1/15 - 20 + 1/25 - (10*n) + 1/(5*n)
            System.out.print("Input Number : ");
            int number = Integer.parseInt(input.readLine());
            float hasil = 0;
            for(int x=1;x<=number;x++){
                if(x%2!=0){
                    float z = 1/((float)5*x);
                    hasil += z;
                } else {
                    float z = 5*x;
                    hasil-=z;
                }
            }
            System.out.println(hasil);
        }catch (IOException exception) {
            System.out.println("Error input!");
        }
    }
}
