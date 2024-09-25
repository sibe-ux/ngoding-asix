package com.javaoop.programmer_zaman_now.java_generic.application;

import com.javaoop.programmer_zaman_now.java_generic.MyData;

public class InvariantApp {
    public static void main(String[] args) {
        
        MyData<String> sMyData = new MyData<>("sibe");
        // doIt(sMyData); // ini error
        // MyData<Object> oMyData = sMyData; // ini error
        System.out.println(sMyData.getData());
        
        MyData<Object> oMyData = new MyData<Object>(1000); 
        // MyData<Integer> iMyData = oMyData; // ini juga error
        // doItInteger(oMyData); // ini juga error
        doIt(oMyData);
    }

    public static void doIt(MyData<Object> oMyData){
        // do nothing
    }

    public static void doItInteger(MyData<Integer> iMyData){
        // do nothing
    }
}
