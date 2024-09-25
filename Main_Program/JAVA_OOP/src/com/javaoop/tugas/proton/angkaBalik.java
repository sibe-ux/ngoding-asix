package com.javaoop.tugas.proton;
import java.io.*;
public class angkaBalik {
    public static void main(String[] args) {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        try{
            System.out.print("Input Number : ");
            int number = Integer.parseInt(input.readLine());
            for (int x=1;x<=number;x++){
                if(x%2==0){
                    for(int z=x;z>=1;z--){
                        System.out.print(z);
                    }
                } else{
                    for(int z=1;z<=x;z++){
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
