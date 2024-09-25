package com.javaoop.java_dasar;

public class ArrayObject {
    String nama;

    ArrayObject(String nama){
        this.nama = nama;
    }
    public static void main(String[] args) {
        ArrayObject [] myArray = new ArrayObject[10];
        myArray[0] = new ArrayObject("sibe");
        myArray[1] = new ArrayObject("oke");

        // System.out.println(myArray[0]);
        for (var x = 0;x<myArray.length;x++){
            System.out.println(myArray[x]);
        }
    }
}
