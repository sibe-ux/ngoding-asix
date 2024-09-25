package com.javaoop.java_dasar;

public class sumARRAY {
    public static void main(String args[]) {
        int dragon[] = { 7, 2 };
        int sum = 0;
        int indeks = 0;
        for (int x = 1; x <= dragon.length; x++) {
            sum = sum + dragon[indeks];
            indeks++;
        }
        System.out.println(sum);
    }
}
