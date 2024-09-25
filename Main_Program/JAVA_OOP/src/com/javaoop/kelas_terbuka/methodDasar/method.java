package com.javaoop.kelas_terbuka.methodDasar;

class Maha_siswa{
    // data member
    String nama;
    String NIM;

    // constructor
    Maha_siswa(String inputNama, String inputNIM){
        nama = inputNama;
        NIM = inputNIM;
        method.test();
    }
}

class Maha_siswa1{
    // data member
    String nama1 = "nama asli";
    String nama;
    String NIM;
    
    // constructor
    Maha_siswa1(String nama1, String nama, String NIM){
        System.out.println("nama1 : " + nama1);
        System.out.println("this.nama1 : " + this.nama1);
        this.nama = nama;
        this.NIM = NIM;
    }

    // method tanpa return dan tanpa parameter
    void show(){
        System.out.println("nama : " + this.nama);
        System.out.println("NIM : " + this.NIM);
    }

    // method tanpa return dan dengan parameter
    void setNama(String nama){
        this.nama = nama;
    }

    // method dengan return tanpa parameter
    String getNama(){
        return this.nama;
    }
    String getNIM(){
        return this.NIM;
    }

    // method dengan return dan dengan parameter
    String sayHI(String message){
        return message + " juga, nama gwejj adalah : " + this.nama;
    }
}

public class method {
    public static void main(String[] args) {
        Maha_siswa1 mahasiswa1 = new Maha_siswa1("ucup", "sibe" , "436178346");
        System.out.println("mahasiswa1.nama1 : " + mahasiswa1.nama);
        System.out.println("=================SHOW=================");
        // method
        mahasiswa1.show();
        System.out.println("=================SET NAMA=================");
        mahasiswa1.setNama("habi");
        mahasiswa1.show();
        
        System.out.println("=================GET NAMA=================");
        System.out.println(mahasiswa1.getNama());
        System.out.println(mahasiswa1.getNIM());
        
        System.out.println("=================SAY HI=================");
        String data = mahasiswa1.sayHI("GGWP");
        System.out.println(data);

        System.out.println("=================METHOD TEST=================");
        Maha_siswa mahasiswa11 = new Maha_siswa("ucup", "436178346");
        System.out.println(mahasiswa11.nama);
        test();
    }
    static void test(){
        System.out.println("ini adalah method test");
    }
}
