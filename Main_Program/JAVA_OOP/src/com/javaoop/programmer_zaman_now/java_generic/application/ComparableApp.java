package com.javaoop.programmer_zaman_now.java_generic.application;

import java.util.Arrays;

import com.javaoop.programmer_zaman_now.java_generic.Person;

public class ComparableApp {
    public static void main(String[] args) {
        
        Person [] people = {
            new Person("sibe", "bali"),
            new Person("habi", "bali"),
            new Person("biqi", "bali")
        };

        Arrays.sort(people);

        System.out.println(Arrays.toString(people));
    }
}
