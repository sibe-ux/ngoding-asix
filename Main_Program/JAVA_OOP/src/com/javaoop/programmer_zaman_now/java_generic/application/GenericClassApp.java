package com.javaoop.programmer_zaman_now.java_generic.application;

import com.javaoop.programmer_zaman_now.java_generic.MyData;

public class GenericClassApp {
    public static void main(String[] args) {
        MyData<String> stringMyData = new MyData<String>("SIbe");
        MyData<Integer> integerMyData = new MyData<Integer>(19);

        String stringValue = stringMyData.getData();
        Integer integerValue = integerMyData.getData();

        System.out.println(stringValue);
        System.out.println(integerValue);
    }
}
