package com.javaoop.java_dasar.inheritance;

public class Kucing extends Animal{

    private String nama;

    Kucing(String nama) {
        super(nama);
        this.nama = nama;
        //TODO Auto-generated constructor stub
    }
    
    @Override
    public String getNama() {
        // TODO Auto-generated method stub
        return super.getNama();
    }

    @Override
    public void setNama(String nama) {
        // TODO Auto-generated method stub
        super.setNama(nama);
    }

    @Override
    public void roar(String text) {
        // TODO Auto-generated method stub
        System.out.println("from kucinf");
    }

    @Override
    public void eat() {
        System.out.println("kucing eat");
        System.out.println(nama);
        
    }
}
