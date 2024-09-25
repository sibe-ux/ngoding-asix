package com.javaoop.programmer_zaman_now.java_collection;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class SetApp {
    public static void main(String[] args) {
        
        // data tidak terurut
        Set<String> nama = new HashSet<>();

        // data terurut
        Set<String> namaLinked = new LinkedHashSet<>();

        nama.add("M. ");
        nama.add("nasrul");
        nama.add("wahabi");
        nama.add("M. ");
        nama.add("nasrul");
        nama.add("wahabi");
        
        namaLinked.add("M. ");
        namaLinked.add("nasrul");
        namaLinked.add("wahabi");
        namaLinked.add("M. ");
        namaLinked.add("nasrul");
        namaLinked.add("wahabi");

        for (var x : nama){
            System.out.println(x);
        }
        
        for (var x : namaLinked){
            System.out.println(x);
        }

    }
}
