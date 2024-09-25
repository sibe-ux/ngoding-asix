package com.javaoop.programmer_zaman_now.java_collection;

import java.util.List;

import com.javaoop.programmer_zaman_now.java_collection.Data.Person;

public class MutableApp {
    public static void main(String[] args) {
        
        Person person = new Person("sibel");

        person.addHobby("reading");
        person.addHobby("coding");

        DoSomethingWithHobbies(person.getHobbiesMutable());

        // DoSomethingWithHobbies(person.getHobbiesImmutale());

        for (var hobby : person.getHobbiesImmutale()) {
            System.out.println(hobby);
        }
    }

    public static void DoSomethingWithHobbies(List<String> hobbies) {
            hobbies.add("Bukan hobi");
    }
}
