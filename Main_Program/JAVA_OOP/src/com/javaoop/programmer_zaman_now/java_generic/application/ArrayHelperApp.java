package com.javaoop.programmer_zaman_now.java_generic.application;

import com.javaoop.programmer_zaman_now.java_generic.util.ArrayHelper;

public class ArrayHelperApp {
    public static void main(String[] args) {
        
        String nama[] = {"nasrul", "wahabi", "sibe"};
        Integer number[] = {1,2,3,4,5};

        System.out.println(
            ArrayHelper.<String>count(nama)
        );

        System.out.println(
            ArrayHelper.count(number)
        );
    }
}
