package com.javaoop.programmer_zaman_now.java_generic.application;

import com.javaoop.programmer_zaman_now.java_generic.MyData;

public class TypeErasureApp {
    public static void main(String[] args) {
        
        MyData myData = new MyData("siberia");

        MyData<Integer> iMyData = (MyData<Integer>) myData; // error
        Integer integer = iMyData.getData();
    }
}
