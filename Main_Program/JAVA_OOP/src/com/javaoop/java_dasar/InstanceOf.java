package com.javaoop.java_dasar;

public class InstanceOf {
    String pesan = "okejek";
    public static void main(String[] args) {
        InstanceOf test = new InstanceOf();
        System.out.println(test instanceof InstanceOf); // true
        System.out.println(test.pesan instanceof String); // true
    }
}
