package com.javaoop.materi;

import java.lang.Math;

class lingkaran{
    String warna = "hitam";
    double jari_jari;

    // inisialisasi class (constructor)
    // konstruktor dijalankan ketika instant dari class (object) dibuat
    public lingkaran(double newJariJari){
        jari_jari = newJariJari;
    }

    void setJariJari(double newJariJari){
        jari_jari= newJariJari;
    }

    double hitungLuas(){
        // double luas = Math.PI*jari_jari*jari_jari
        return Math.PI*jari_jari*jari_jari;
    }

    double hitungkeliling(){
        return 2*Math.PI*jari_jari;
    }
}

public class contoh2 {
    public static void main(String[] args) {
        lingkaran lingkaran1 = new lingkaran(10);
        System.out.println("luas : "+lingkaran1.hitungLuas());
        System.out.println("keliling : "+lingkaran1.hitungkeliling());
        
        lingkaran lingkaran2 = new lingkaran(100);
        System.out.println("luas : "+lingkaran2.hitungLuas());
        System.out.println("keliling : "+lingkaran2.hitungkeliling());
    }    
}
