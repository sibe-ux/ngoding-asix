package com.javaoop.java_dasar;

public class void_learn {
    
    String nama, makanan;
    
    public static void main(String[] args){
        // Membuat Objek dari Class tutorial_dasar
        void_learn Hewan = new void_learn();
        System.out.println("====== KUCING =======");
        Hewan.Kucing();
        System.out.println("====== KAMBING ======");
        Hewan.Kambing();
    }
    
    // void kurang lebih seperti def pada python
    void Kucing(){
        nama = "Carberus";
        makanan = "Daging";
        System.out.println("Nama Kucing Saya Adalah "+nama);
        System.out.println("Kucing Saya Suka Makan "+makanan);
    }
    
    void Kambing(){
        nama = "Amaterasu";
        makanan = "Rumput";
        System.out.println("Nama Kambing Saya Adalah "+nama);
        System.out.println("Kambing Saya Suka Makan "+makanan);
    }
}