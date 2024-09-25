package com.javaoop.tugas.proton;
import java.io.*;
public class triangleBAja {
    public static void main(String[] args) {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.print("N : ");
            int n = Integer.parseInt( input.readLine() );
            for (int x=1;x<=n;x++){
                for (int y=1;y<=x;y++){
                    if (x%2!=0){
                        System.out.print(y);
                    } else{
                        System.out.print("*");
                    }
                }
                System.out.print("\n");
            }
        } catch (IOException exception) {
            System.out.println("Error input!");
        }
    }
}
