package com.javaoop.programmer_zaman_now.java_collection;

import java.util.Collections;
import java.util.SortedSet;
import java.util.TreeSet;

import com.javaoop.programmer_zaman_now.java_collection.Data.Person;
import com.javaoop.programmer_zaman_now.java_collection.Data.PersonComparator;

public class SortedSetAp {
    public static void main(String[] args) {
        
        SortedSet<Person> people = new TreeSet<>(new PersonComparator());

        // reverse sort
        SortedSet<Person> peoplereverse = new TreeSet<>(new PersonComparator().reversed());
        
        people.add(new Person("sibe"));
        people.add(new Person("zaman"));
        people.add(new Person("khan"));
        
        peoplereverse.add(new Person("sibe"));
        peoplereverse.add(new Person("zaman"));
        peoplereverse.add(new Person("khan"));
        
        for (var x : people){
            System.out.println(x.getName());
        }

        System.out.println("");

        for (var x : peoplereverse){
            System.out.println(x.getName());
        }
        
        // immutable
        SortedSet<Person> peopleImmutable = Collections.unmodifiableSortedSet(people);
        // error
        peopleImmutable.add(new Person("sibe"));
        
    }
}