package com.javaoop.tugas.proton;
import java.io.*;
public class segitiga {
public static void main(String[] args) {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.print("N : ");
            int n = Integer.parseInt( input.readLine() );
            int oke = n;
            int base = n;
            int output = n-2;
            int input1 = n;
            int indeks1 = n;
            int indeks = 1;
            while(n > 1){
                int x = n-1;
                for (int k=1;k<=x;k++){
                  System.out.print(" ");
                }
                if (indeks%2==0){
                  String s = ""+n;
                  for (int p = 1;p<indeks;p++){
                    System.out.print(s);
                  }
                  System.out.println(s);
                } else{
                for (int xo = n;xo<oke;xo++){
                  String s = ""+xo;
                  System.out.print(s);
                }
                System.out.println(oke);
                }
                n--;
                indeks++;
            }

            if (base%2==1){
              while(indeks1 > 1){
                System.out.print(indeks1);
                indeks1--;
              }
              System.out.println(indeks1);
            }else{
              String s = ""+base;
              for(int x=1;x<base;x++){
                System.out.print(s);
              }
              System.out.println(s);
            }
          //  while (indeks1 >1){
          //    if (base %2==1){
          //      System.out.print(indeks1);
          //    }else {
          //      String s = ""+base;
          //      for (int x=1;x<=base;x++){
          //        System.out.println(s);
          //      }
          //    }
          //    indeks1--;
          //  }
          //  System.out.println(indeks1);
           
           if (input1>1){
             int sy = base + 1;
             for (int last = 2;last<=input1;last++){
               int df = last -1;
               for (int dx = 1;dx<=df;dx++){
                 System.out.print(" ");
               }
               if (sy%2==0){
                 String s = ""+last;
                 for (int zx = 1;zx<=output;zx++){
                   System.out.print(s);   
                 }
                 System.out.println(s);
                 output-=1;
               } else{
               for (int xd=last;xd<base;xd++){
                 String s = "" + xd;
                 System.out.print(s);
               }
               System.out.println(base);
               output-=1;
               }
               sy+=1;
             }
           }
        } catch (IOException exception) {
            System.out.println("Error input!");
        }
    }

}