package com.javaoop.programmer_zaman_now.java_collection;

import java.util.EnumSet;

public class EnumSetApp {

    public static enum gender{
        male, female, not_mention
    }

    public static void main(String[] args) {
        
        EnumSet<gender> genders = EnumSet.allOf(gender.class);
        EnumSet<gender> gendersElement = EnumSet.of(gender.male, gender.female);

        for (var x : genders){
            System.out.println(x);
        }
    }
}
