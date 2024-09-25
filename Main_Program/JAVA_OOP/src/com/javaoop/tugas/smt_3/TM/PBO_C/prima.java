package com.javaoop.tugas.smt_3.TM.PBO_C;

import java.io.*;

public class prima {
    public static void main(String[] args) {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.print("Input Number : ");
            int number = Integer.parseInt(input.readLine());
            int factor = 0; // 2
            if (number > 1) {
                for (int x = 1; x <= number; x++) {
                    int numbFact = number % x;
                    if (numbFact == 0) {
                        factor++;
                    }
                }
                if (factor == 2) {
                    System.out.println("The Number is Prime");
                } else {
                    System.out.println("The number is not Prime");
                }
            } else {
                System.out.println("The number is not prime");
            }
        } catch (IOException exception) {
            System.out.println("Error input!");
        }
    }
}

// faktor = 0 +1 = 1 + 1 = 2
// 1 & 
//5    1 2 3 4 5
// 5%1 = 0 , 5%2 = 1, 5%3 = 2, 5 % 4 =, 5 % 5= 0

// factor = 1 + 1 + 1 + 1
// 6%1 = 0, 6%2 = 0, 6%3=0