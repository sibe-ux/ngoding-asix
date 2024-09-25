package com.javaoop.programmer_zaman_now.java_collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ImmutableApp {
    public static void main(String[] args) {
        
        List<String> one = Collections.singletonList("satu");
        List<String> empty = Collections.emptyList();

        List<String> mutable = new ArrayList<>();
        mutable.add("satu");
        mutable.add("dua");

        List<String> immutable = Collections.unmodifiableList(mutable);
        System.out.println(immutable);

        List<Integer> elements = List.of(1, 2,3,4,5);
        // error
        // elements.add(6); 
    }
}
