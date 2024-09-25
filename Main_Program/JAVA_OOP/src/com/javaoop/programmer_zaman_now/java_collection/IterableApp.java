package com.javaoop.programmer_zaman_now.java_collection;

import java.util.Iterator;
import java.util.List;

public class IterableApp {
    public static void main(String[] args) {

        Iterable<String> names = List.of("sibe","habqi","habi");

        for (var name : names) {
            System.out.println(name);
        }

        System.out.println("iterator");

        Iterable<Integer> numbers = List.of(1,2,3,4,5);
        Iterator<Integer> iterator = numbers.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}