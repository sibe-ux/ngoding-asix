package com.javaoop.java_dasar.Serializable;

import java.io.Serializable;

public class Fruit implements Serializable {
    String name;
    int price;

    Fruit(String name, int price){
        this.name = name;
        this.price = price;
    }

    public void setNama(String nama){
        this.name = nama;
    }

    public int getPrice(){
        return this.price;
    }
}
