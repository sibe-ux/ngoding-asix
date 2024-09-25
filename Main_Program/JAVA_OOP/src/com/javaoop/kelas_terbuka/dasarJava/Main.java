package com.javaoop.kelas_terbuka.dasarJava;

// membuat class sebagai template
class Mahasiswa{
    String nama;
    String NIM;
    String jurusan;
    double ipk;
    int umur;
}


public class Main {
    public static void main(String[] args) {
        
        // instansiasi / membuat object
        Mahasiswa mahasiswa1 = new Mahasiswa();
        mahasiswa1.nama = "sibe";
        mahasiswa1.NIM = "202410101052";
        mahasiswa1.jurusan = "SI";
        mahasiswa1.ipk = 4.0;
        mahasiswa1.umur = 19;

        System.out.println(mahasiswa1.nama);
        System.out.println(mahasiswa1.NIM);
        System.out.println(mahasiswa1.jurusan);
        System.out.println(mahasiswa1.ipk);
        System.out.println(mahasiswa1.umur);
    }
}
