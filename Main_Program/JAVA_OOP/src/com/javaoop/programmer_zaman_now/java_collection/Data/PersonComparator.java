package com.javaoop.programmer_zaman_now.java_collection.Data;

import java.util.Comparator;

public class PersonComparator implements Comparator<Person> {
    // Ascending
    @Override
    public int compare(Person o1, Person o2) {
        return o1.getName().compareTo(o2.getName());
    }

    // Descending
    public int compareDESC(Person o1, Person o2) {
        return o2.getName().compareTo(o1.getName());
    }
}
