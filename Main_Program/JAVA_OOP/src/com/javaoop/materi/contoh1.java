package com.javaoop.materi;

class person{
    // atribut
    String nama, alamat, jenisKelamin, hobi;

    // methods
    void setNama(String newNama, String newAlamat){
        nama = newNama;
        alamat = newAlamat;
    }
    String bacaNama(){
        return nama;
    }
    String bacaAlamat(){
        return alamat;
    }

}

public class contoh1 {
    public static void main(String[] args) {
        // baris program yang dijalankan pertama => di bawah main method
        person person1 = new person();
        person1.setNama("sibe","tunjung");
        System.out.println(person1.bacaNama());
        System.out.println(person1.bacaAlamat());
    }
}
