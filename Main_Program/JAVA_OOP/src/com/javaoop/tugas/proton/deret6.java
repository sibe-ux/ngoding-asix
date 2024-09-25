package com.javaoop.tugas.proton;

import java.util.*;
// import java.lang.Math;

public class deret6 {
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int i, j, n, y, a;
        
        n = input.nextInt();
        a = (int) (-5);
        y = 0;
        System.out.print("y = ");
        for (i = 1; i <= n; i++) {
            a = a + 6;
            if (i % 2 == 0) {
                j = a;
                System.out.print("+");
                System.out.print(j);
            } else {
                j = (int) (-a);
                System.out.print(j);
            }
            y = y + j;
        }
        System.out.println("");
        System.out.print("y = ");
        System.out.println(y);
    }
}
