package com.javaoop.programmer_zaman_now.java_generic.application;

import java.util.Comparator;

import com.javaoop.programmer_zaman_now.java_generic.Person;

public class ComparatorApp {
    public static void main(String[] args) {
        
        Person[] people = {
            new Person("sibe", "bali"),
            new Person("asep", "bali"),
            new Person("udin", "bali")
    };

    Comparator<Person> comparator = new Comparator<Person>() {
        @Override
        public int compare(Person o1, Person o2) {
            return o1.getName().compareTo(o2.getName());
    }
    
};

    // sort by name
    java.util.Arrays.sort(people, comparator);
    System.out.println("Sorted by name: " + java.util.Arrays.toString(people));
};
}
