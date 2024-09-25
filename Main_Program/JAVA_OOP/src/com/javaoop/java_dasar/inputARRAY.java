package com.javaoop.java_dasar;
import java.io.*;
import java.util.Arrays;
public class inputARRAY {
    public static void main(String[] args) {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.print("input lenght of array : ");
            int number = Integer.parseInt(input.readLine());
            int arrays[] = new int[number];
            for( int i = 0; i < arrays.length; i++ ){
                System.out.print("Array ke-" + i + ": ");
                arrays[i] = Integer.parseInt(input.readLine());
            }
            System.out.println("---------------------------");
            System.out.println(Arrays.toString(arrays));
        } catch (IOException exception) {
            System.out.println("Error input!");
    } 
}
}