package com.javaoop.java_dasar;

public class method_static {
    
    //Menambahkan Sifat Static pada Variable
    static String nama;
    static int tahun_s = 2017, tahun_l = 1998, umur;
    static double IPK;
    
    public static void main(String[] args){
        //Memanggil Data Static pada Method Main
        nama = "Wildan";
        System.out.println("Nama Saya: "+nama);
        System.out.println("Umur Saya: "+Umur_Saya()+" Tahun");
        NilaiIPK();
    }
    
    //Menambahkan Sifat Static pada Method Return
    static int Umur_Saya(){
        umur = tahun_s - tahun_l;
        return umur;
    }
    
    //Menambahkan Sifat Static pada Method Void
    static void NilaiIPK(){
        IPK = 4.0;
        System.out.println("Nilai IPK Saya: "+IPK);
    }
}
