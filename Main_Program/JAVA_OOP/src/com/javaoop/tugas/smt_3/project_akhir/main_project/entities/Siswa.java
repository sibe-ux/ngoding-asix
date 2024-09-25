package com.javaoop.tugas.smt_3.project_akhir.main_project.entities;

import java.io.Serializable;

public class Siswa implements Serializable {
    private int nis;
    private String username;
    private String nama;
    private Kelas kelas;
    
    public Siswa(int nis,String nama,String username,String category){
        this.nis = nis;
        this.nama = nama;
        this.username = username;
    }

    public String getNamaSiswa(){
        return this.nama;
    }

    public void setNamaSiswa(String nama){
        this.nama = nama;
    }

    public int getNis(){
        return this.nis;
    }

    public void setNis(int noAbsen){
        this.nis = noAbsen;
    }

    public Kelas getkelas(){
        return this.kelas;
    }

    public void setKelas(Kelas kelas){
        this.kelas = kelas;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
