package com.javaoop.kelas_terbuka.constructorDasar;

// class tanpa constructor / class polos
class polos {
    String dataString;
    int dataInteger;
}

// class dengan constructor
class mahasiswaa {
    String nama;
    String NIM;
    String jurusan;

    // constructor dipanggil saat object pertama kali dibuat
    // Mahasiswa(){
    // System.out.println("ini adalah constructor");
    // }

    // constructor dengan parameter
    mahasiswaa(String inputNama, String inputNIM, String inputJurusan) {
        nama = inputNama;
        NIM = inputNIM;
        jurusan = inputJurusan;

        System.out.println(nama);
        System.out.println(NIM);
        System.out.println(jurusan);
    }
}

public class constructor {
    public static void main(String[] args) throws Exception {

        mahasiswaa mahasiswaa1 = new mahasiswaa("sibe", "61731624", "Teknik Nuklir");
        mahasiswaa mahasiswaa2 = new mahasiswaa("habi", "62131274", "Teknik elektro");
        System.out.println("mahasiswaa1.nama : " + mahasiswaa1.nama);
        System.out.println("mahasiswaa2.jurusan : " + mahasiswaa2.jurusan);
        // polos objectPolos = new Polos();
        // objectPolos.dataString = "Polos";
        // objectPolos.dataInteger = 0;

        // System.out.printIn(objectPolos.dataString);
        // System.out.printIn(objectPolos.dataInteger);
    }
}
