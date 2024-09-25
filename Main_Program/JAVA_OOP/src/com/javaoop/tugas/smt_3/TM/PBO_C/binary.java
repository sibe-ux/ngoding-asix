package com.javaoop.tugas.smt_3.TM.PBO_C;

import java.io.*;

public class binary {
    public static void main(String[] args) {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.print("Input Number : ");
            int index = 0;
            int number = Integer.parseInt(input.readLine());
            int[] binary = { 3, 5, 8, 11, 15, 23, 52, 66 };
            int binaryLen = binary.length; // len(array)
            for (int x : binary) { // for x in array
                if (number == x) {
                    System.out.println("Number is in array at index " + index);
                    break;
                }
                index++;
            }
            if (index == binaryLen) {
                System.out.println("Number is not in array!");
            }
        } catch (IOException exception) {
            System.out.println("Error input!");
        }
    }
}

// indeks = 0 + 1 + 1 + 1 + 1 = 4 + 1 + 1 + 1 =  8
// 151
// 3 , 151 = 3 ? 151 = 5, 151 = 8, 11, 15, 23, 52, 66