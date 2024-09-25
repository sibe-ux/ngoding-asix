package com.javaoop.programmer_zaman_now.java_collection.Data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Person {
    
    private String name;

    private List<String> hobbies;

    public Person(String name){
        this.name = name;
        this.hobbies = new ArrayList<>();
    }

    public void addHobby(String hobby){
        hobbies.add(hobby);
    }

    // mutable list
    public List<String> getHobbiesMutable() {
        return hobbies;
    }

    // immutable list
    public List<String> getHobbiesImmutale() {
        return Collections.unmodifiableList(hobbies);
    }
    

    public String getName() {
        return name;
    }
}
