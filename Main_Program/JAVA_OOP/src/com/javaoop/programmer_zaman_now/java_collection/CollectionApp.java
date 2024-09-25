package com.javaoop.programmer_zaman_now.java_collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CollectionApp {
    public static void main(String[] args) {
        
        Collection<String> names = new ArrayList<>();

        names.add("sibe");
        names.add("habqi");
        names.add("habi");
        names.addAll(List.of("3","2","1"));

        System.out.println(names);

        names.remove("habqi");
        names.remove("budi"); // no impact karena return boolean
        names.removeAll(List.of("sibe","nasrul"));

        for (var value : names){
            System.out.println(value);
        }

        System.out.println(
            names.contains("habibi")
        );

        System.out.println(
            names.containsAll(List.of("biqi","habi"))
        );
    }
}
