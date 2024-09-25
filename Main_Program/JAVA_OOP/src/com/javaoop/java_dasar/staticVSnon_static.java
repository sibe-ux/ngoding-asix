package com.javaoop.java_dasar;

public class staticVSnon_static {
    
    // Fungsi non-static
    void makan(String makanan){
        System.out.println("Hi!");
        System.out.println("Saya sedang makan " + makanan);
    }
    
    // fungsi static
    static void minum(String minuman){
        System.out.println("Saya sedang minum " + minuman);
    }
    
    // fungsi main
    public static void main(String[] args) {
        
        // pemanggilan fungsi static
        minum("Kopi");
        minum("susu");
        
        
        // mambuat instansiasi objek saya dari class FungsiStatic
        staticVSnon_static saya = new staticVSnon_static();
        // pemanggilan fungsi non-static
        saya.makan("Nasi Goreng");
        saya.makan("sate");
    }
    
}
