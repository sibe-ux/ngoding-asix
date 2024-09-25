package com.javaoop.tugas.proton;
import java.io.*;
public class primeSum {
    public static void main(String[] args) {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.print("input N : ");
            int n = Integer.parseInt(input.readLine());
            int nilai=2;
            int indeksIterasi = 0;
            int sum=1;
            int hasil = 0;
           while(indeksIterasi<n){
                int indeks=0;
                for(int x=1;x<=nilai;x++){
                    if (nilai%x==0){
                        indeks+=1;
                    }
                }
                if (indeks==2){
                    if (sum%2!=0){
                        hasil+=nilai;
                        indeksIterasi+=1;
                        sum++;
                    } else{
                        hasil-=nilai;
                        indeksIterasi+=1;
                        sum++;
                    }
                }
                nilai+=1;
            }
            System.out.println(hasil);
        }  catch (IOException exception) {
            System.out.println("Error input!");
        }  
    }
    }

