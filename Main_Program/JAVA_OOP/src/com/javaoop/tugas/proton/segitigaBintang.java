package com.javaoop.tugas.proton;
import java.io.*;
public class segitigaBintang {
    public static void main(String[] args) {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.print("N : ");
            int n = Integer.parseInt( input.readLine() );
            int indeks = n;
            while (indeks > 1){
                System.out.print(indeks);
                indeks--;
            }
            System.out.println(indeks);
            String s = "*";
            int space = n-1;
            int iterasi = 2;
            for (int x=1;x<=space;x++){
                for (int y=1;y<=x;y++){
                    System.out.print(" ");
                }
                if(iterasi%2==0){
                    for(int x1=n;x1>x+1;x1--){
                        System.out.print(s);
                    }
                    System.out.println(s);
                    iterasi++;
                } else{
                    for(int x2=n;x2>x+1;x2--){
                        System.out.print(x2);
                    }
                    System.out.println(x+1);
                    iterasi++;
                }
            }

        } catch (IOException exception) {
            System.out.println("Error input!");
        }
    }
}
