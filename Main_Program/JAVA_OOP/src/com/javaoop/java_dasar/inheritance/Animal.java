package com.javaoop.java_dasar.inheritance;

public class Animal {
    private String nama;

    Animal (String nama){
        this.nama = nama;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void roar(String text) {
        System.out.println("from animal");
    }

    public void eat(){
        System.out.println("animal eat");
    }
}
