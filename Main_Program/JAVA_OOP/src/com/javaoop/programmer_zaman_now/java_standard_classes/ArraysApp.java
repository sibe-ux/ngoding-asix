package com.javaoop.programmer_zaman_now.java_standard_classes;

import java.util.Arrays;

public class ArraysApp {
  public static void main(String[] args) {

    int[] numbers = {
        1, 4, 234, 5, 6, 19, 5, 67, 4, 5, 67, 4, 6, 7
    };

    Arrays.sort(numbers);

    System.out.println(Arrays.toString(numbers));

    System.out.println(Arrays.binarySearch(numbers, 7));
    System.out.println(Arrays.binarySearch(numbers, 234));
    System.out.println(Arrays.binarySearch(numbers, 100));

    int[] result = Arrays.copyOf(numbers, 5);
    System.out.println(Arrays.toString(result));

    int[] result2 = Arrays.copyOfRange(numbers, 5, 10);
    System.out.println(Arrays.toString(result2));

  }
}
