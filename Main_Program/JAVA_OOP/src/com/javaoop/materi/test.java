package com.javaoop.materi;
import java.io.*;
public class test {
    public static void main(String[] args) {
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        try{
            System.out.print("Input Number : ");
            int number = Integer.parseInt(input.readLine());
            for (var x = 1;x<=number;x++){
                if (x % 2 == 1){
                    for (var y =1;y<=(2*x-1);y++){
                        System.out.print(y);
                        y+=1;
                    }
                    for (var z = (2*x-3);z>=1;z--){
                        System.out.print(z);
                        z-=1;
                    }
                    System.out.println();
                } else{
                    for (var y=(2*x-1);y>=1;y--){
                        System.out.print(y);
                        y-=1;
                    }
                    for(var z=3;z<=(2*x-1);z++){
                        System.out.print(z);
                        z+=1;
                    }
                    System.out.println();
                }
            }

        } catch (IOException exception) {
            System.out.println("Error input!");

        }
    }
}
