package com.javaoop.programmer_zaman_now.java_generic.application;

public class MultipleConstraintApp {
    public static void main(String[] args){
        // Data<Manager> managerdData = 
        // new Data<MultipleConstraintApp.Manager>(
        //     new Manager()
        // ); error manager tidak implement CanSayHello
        Data<VicePresident> vData = 
        new Data<MultipleConstraintApp.VicePresident>(
            new VicePresident()
        );

        System.out.println(vData);
    }

    public static interface CanSayHello{
        void sayHello(String name);
    }

    public static abstract class Employee {

    }

    public static class Manager extends Employee{

    }

    public static class VicePresident extends Employee
    implements CanSayHello{

        @Override
        public void sayHello(String name) {
            System.out.println("Hello " + name);
        }
    }

    public static class Data<T extends Employee 
    & CanSayHello>{

        private T data;

        public Data(T data){
            this.data = data;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }
    }
}