package com.javaoop.java_dasar.ArrayClass;

public class TestFruit {
    public static void main(String[] args) {

        FruitService nanas = new FruitService();
        nanas.data[0] = new Fruit("nanas");
        nanas.data[1] = new Fruit("Apel");
        nanas.data[2] = new Fruit("Mangga");

        for(var x : nanas.getAll()){
            System.out.println(x.getBuah());
        }
    }
}
