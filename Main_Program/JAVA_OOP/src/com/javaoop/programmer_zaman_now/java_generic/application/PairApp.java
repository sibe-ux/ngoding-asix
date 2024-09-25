package com.javaoop.programmer_zaman_now.java_generic.application;

import com.javaoop.programmer_zaman_now.java_generic.Pair;

public class PairApp{
    public static void main(String[] args) {

        Pair<String, Integer> pair = new Pair<String, Integer>("sibe", 19);
        
        System.out.println(pair.getFirst());
        System.out.println(pair.getSecond());
    }

}