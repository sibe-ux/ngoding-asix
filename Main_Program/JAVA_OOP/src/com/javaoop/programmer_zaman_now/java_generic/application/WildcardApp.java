package com.javaoop.programmer_zaman_now.java_generic.application;

import com.javaoop.programmer_zaman_now.java_generic.MyData;
import com.javaoop.programmer_zaman_now.java_generic.application.MultipleConstraintApp.Manager;

public class WildcardApp {
    public static void main(String[] args) {
        
        print(new MyData<Integer>(100));
        print(new MyData<String>("Java"));
        print(new MyData<MultipleConstraintApp.Manager>(new MultipleConstraintApp.Manager()));
    }

    public static void print(MyData<?> myData){
        System.out.println(myData.getData());
    }
}
