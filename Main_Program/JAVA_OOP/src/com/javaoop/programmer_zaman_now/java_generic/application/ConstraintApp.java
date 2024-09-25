package com.javaoop.programmer_zaman_now.java_generic.application;

public class ConstraintApp {
    public static void main(String[] args){
        
        NumberData<Integer> integerNumberData = 
        new NumberData<>(1);
        // NumberData<Long> longNumberData = 
        // new NumberData(1L); ini bisa

        // NumberData<String> stringNumberData = 
        // new NumberData<String>("sibe"); ini error
        
        System.out.println(integerNumberData);
        // System.out.println(longNumberData);

    }

    public static class NumberData<T extends Number>{

        private T data;
    
        public NumberData(T data){
            this.data = data;
        }
    
        public T getData() {
            return data;
        }
    
        public void setData(T data) {
            this.data =  data;
        }
    }
}