package com.javaoop.java_dasar;

import java.util.Arrays;

public class ArraysToString {
    public static void main(String[] args) {
        String sayuran[] = {"kentang", "tomat", "wortel"};
        String buahan[][] = {{"apel","mangga"},{"sirsak","semangka"}};

        System.out.println(Arrays.toString(sayuran));
        System.out.println(Arrays.deepToString(buahan)); // kalo >= 2 multidimensi, harus pake deepToString
    }
}
