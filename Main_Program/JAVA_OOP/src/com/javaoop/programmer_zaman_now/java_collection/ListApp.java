package com.javaoop.programmer_zaman_now.java_collection;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

public class ListApp {
    public static void main(String[] args) {
        
        List<String> strings = new ArrayList<>();
        // LinkedList<String> strings = new LinkedList<>();

        strings.add("Java");
        strings.add("OOP");
        strings.add("Programming");
        strings.add("Zaman");
        System.out.println(strings);

        strings.set(0, "Test");
        System.out.println(strings);

        strings.remove(1); // OOP
        System.out.println(strings.get(0));

        for (var value : strings){
            System.out.println(value);
        }
    }
}
