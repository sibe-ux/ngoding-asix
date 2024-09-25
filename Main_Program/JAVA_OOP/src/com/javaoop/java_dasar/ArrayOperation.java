package com.javaoop.java_dasar;

import java.util.Arrays;

public class ArrayOperation {
    public static void main(String[] args) {
        int scores[] = {100, 90, 80, 70, 60, 50, 40, 30, 20, 10};

        System.out.println("Scores : "+ Arrays.toString(scores));

        // penjumlahan
        int total = 0;
        for (int val: scores) {
            total += val;
        }
        System.out.println("Total : "+total);

        // max
        int max = 0;
        for (int val: scores) {
            if (val > max) {
                max = val;
            }
        }
        System.out.println("Max : "+max);

        // min
        int min = scores[0];
        for (int val: scores) {
            if (val < min) {
                min = val;
            }
        }
        System.out.println("Min : "+min);
    }
}
