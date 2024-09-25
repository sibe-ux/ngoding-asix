package com.javaoop.tugas.smt_3.TM.PBO_C;

import java.io.*;

class fisherman{
    String nama;
    String alamat;
    int no; 
    String jenisKelamin;

    // constructor = input data
    fisherman(String nama, String alamat, int no, String kelamin){
        this.nama = nama;
        this.alamat = alamat;
        this.no = no;
        this.jenisKelamin = kelamin;
    }

    String getNama(){
        return this.nama;
    }

    void setNama(String nama){
        this.nama = nama;
    }

    String getAlamat(){
        return this.alamat;
    }

    int getNo(){
        return this.no;
    }

    String getKelamin(){
        return this.jenisKelamin;
    }

    // method menangkap ikan
    void menangkap(int indeks){
        if (indeks==0){
            System.out.println("ikan gagal ditangkap");
        } else{
            System.out.println("ikan berhasil didapatkan : "+indeks+" ekor");
        }
    }
}

public class nelayan {
    public static void main(String[] args) {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        try {
            // objek 1 
            System.out.print("input nama : ");
            String name = input.readLine();
            System.out.print("input alamat : ");
            String alamat = input.readLine();
            System.out.print("input no : ");
            int no = Integer.parseInt(input.readLine());
            System.out.print("input kelamin : ");
            String kelamin = input.readLine();
            fisherman nelayan = new fisherman(name,alamat,no,kelamin);
            System.out.print("input ikan : ");
            int ikan = Integer.parseInt(input.readLine());
            System.out.println("===============");
            System.out.println("nama : "+nelayan.getNama());
            System.out.println("alamat : "+nelayan.getAlamat());
            System.out.println("no hp : "+nelayan.getNo());
            System.out.println("kelamin : "+nelayan.getAlamat());
            nelayan.menangkap(ikan);
            System.out.println("=================");

            nelayan.setNama("adam");
            System.out.println("set nama : "+nelayan.getNama());


        } catch (IOException exception) {
            System.out.println("Error input!");
        }
    } 
}
