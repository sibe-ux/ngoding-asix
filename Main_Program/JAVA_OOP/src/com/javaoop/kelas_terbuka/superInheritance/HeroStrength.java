package com.javaoop.kelas_terbuka.superInheritance;

// this.name akan mengakses atribut name kalau ada di kelas ini.
// jika tidak ada maka akan mengakses atribut name dari superclass.

// super.name akan selalu mengakses atribut superclass
public class HeroStrength extends Hero{
    String name = "Class Strength";

    void display(){
        System.out.println("Ini adalah " + this.name);
        this.dummyMethod();
    }

    void displaySuper(){
        System.out.println("Ini adalah " + super.name);
        super.dummyMethod();
    }

    void dummyMethod(){
        System.out.println("method ini ada di subclass");
    }
}
