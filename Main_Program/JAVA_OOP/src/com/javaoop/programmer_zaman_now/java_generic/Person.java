package com.javaoop.programmer_zaman_now.java_generic;

public class Person implements Comparable<Person> {
    
    private String name;
    private String address;
    
    public Person(String name, String address){
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public int compareTo(Person o) {
        // TODO Auto-generated method stub
        return this.name.compareTo(o.name);
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "Person [name=" + name + ", address=" + address + "]";
    }
}
