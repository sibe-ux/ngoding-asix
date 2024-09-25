package com.javaoop.programmer_zaman_now.java_generic.application;

import com.javaoop.programmer_zaman_now.java_generic.MyData;

public class ContravariantApp {
    public static void main(String[] args) {
        
        MyData<Object> oMyData = new MyData<Object>("sibe");
        MyData<? super String> myData = oMyData;
        process(myData);

        System.out.println(myData.getData());
    }
    public static void process(MyData<? super String> myData ) {
        String value = (String) myData.getData();
        System.out.println("proses parameter "+ value);
        
        myData.setData("sibe habi");
    }
}

