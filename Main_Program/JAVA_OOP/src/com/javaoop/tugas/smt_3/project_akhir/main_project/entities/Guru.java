package com.javaoop.tugas.smt_3.project_akhir.main_project.entities;

public class Guru {
    // ENKAPSULASI
    private String NIP;
    private String nama;
    private String username;
    private String namaMapel;

    public Guru(String nip,String nama, String username,String mapel){
        this.NIP = nip;
        this.nama = nama;
        this.username = username;
        this.namaMapel = mapel;
    }

    // GETTER
    public String getNama(){
        return this.nama;
    }

    public String getUsername(){
        return this.username;
    }

    public String getNIP() {
        return NIP;
    }

    public String getNamaMapel() {
        return namaMapel;
    }
}
