package com.javaoop.tugas.proton;
import java.io.*;
public class diagonal {
    public static void main(String[] args) {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    try {
        System.out.print("Input Number : ");
        int number = Integer.parseInt(input.readLine());
        int plus = number;
        for(int x=1;x<=number;x++){
            for (int z=1;z<=number;z++){
                if(z==plus){
                    System.out.print("+");
                    plus--;
                } else{
                    System.out.print(z);
                }
            }
            System.out.println("");
        }
        
    } catch (IOException exception) {
        System.out.println("Error input!");
    }
}
    
}
