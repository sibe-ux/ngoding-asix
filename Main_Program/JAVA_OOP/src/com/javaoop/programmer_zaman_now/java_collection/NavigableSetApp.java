package com.javaoop.programmer_zaman_now.java_collection;

import java.util.NavigableSet;
import java.util.Set;

public class NavigableSetApp {
    public static void main(String[] args) {
        
        NavigableSet<String> names = new java.util.TreeSet<>();
        names.addAll(Set.of("sibe", "zaman", "khan", "habi","biqi","okejek"));

        for (var x : names) {
            System.out.println(x);
        }

        NavigableSet<String> namesDesc = names.descendingSet();
        System.out.println("\nnames desc");
        for (var x : namesDesc) {
            System.out.println(x);
        }

        NavigableSet<String> khanHead = namesDesc.headSet("khan", true);
        NavigableSet<String> khan = namesDesc.tailSet("khan", true);

        System.out.println(khanHead);
        System.out.println(khan);

        // immutable navigable set
        // empty set
        NavigableSet<String> empty = java.util.Collections.emptyNavigableSet();

        NavigableSet<String> namesImmutable = java.util.Collections.unmodifiableNavigableSet(names);
        // error
        namesImmutable.add("sibe");
    }
}
