package com.javaoop.tugas.smt_3.PRAKTIKUM.Enkapsulasi_Polymorphisme;

public class Main {
    public static void main(String[] args) {
        Charging charge = new Charging();
        Laptop hp = new Laptop("HP","HDD",2);
        Asus asus = new Asus("ASUS","SSD",8);
        Laptop acer = new Acer("ACER","HDD",8);

        hp.Upgrade("hdd",4);
        hp.booting();
        asus.Upgrade(16);
        asus.booting();
        acer.Upgrade("ssd");
        acer.booting();

        hp.testFPS(charge);
        asus.testFPS(charge);
        acer.testFPS();
    }
}
