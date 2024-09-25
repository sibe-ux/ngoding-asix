package com.javaoop.programmer_zaman_now.java_generic.application;

import com.javaoop.programmer_zaman_now.java_generic.MyData;

public class CovariantApp {
    
    public static void main(String[] args) {
        MyData<String> sMyData = new MyData<String>("sibe");
        process(sMyData);

        MyData<? extends Object> mData = sMyData;
        System.out.println(mData);
    }

    public static void process(MyData<? extends Object> myData) {
        
    }
}
