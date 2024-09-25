package com.javaoop.tugas.proton;
import java.io.*;
public class primeSegi3 {
    public static void main(String[] args) {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        try {
            int primeTest = 2;
            int indeks = 0;
            int prime = 0;
            System.out.print("input N : ");
            int n = Integer.parseInt(input.readLine());
            for (int x=1;x<=n;x++){
                while (indeks<x){
                    int indeksPrime=0;
                    for(int y=1;y<=primeTest;y++){
                        if (primeTest%y== 0){
                            indeksPrime+=1;
                        }
                    }
                    if (indeksPrime == 2){
                        indeks +=1;
                        prime = primeTest;
                        if(indeks<x){
                            System.out.print(prime+",");
                        }else {
                            System.out.print(prime);
                        }
                    }
                    primeTest+=1;
                }
                indeks=0;
                System.out.println("");
            }


        }  catch (IOException exception) {
            System.out.println("Error input!");
        }  
    }
}
