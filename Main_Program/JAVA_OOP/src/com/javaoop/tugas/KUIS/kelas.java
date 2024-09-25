package com.javaoop.tugas.KUIS;

import java.util.ArrayList;
import java.util.*;

public class kelas {
    String kategori;
    int tingkat;
    int uh;
    int jumlahSiswa;
    String jurusan;
    siswa siswa;
    int isTugasUlangan = 2;
    boolean isLibur;
    boolean isTugasDikumpulkan;
    boolean isIstirahat;
    sekolah sekolah;
    sekolah.mapel mapel;
    int doingTugas;
    int jumlahTugas;
    ArrayList<String> indeksTugas = new ArrayList<String>();
    ArrayList<Float> indeksNilaiPerPertemuan = new ArrayList<Float>();
    Map<String, ArrayList<Float>> daftarNilaiMapel = new HashMap<String, ArrayList<Float>>();
    Map<String, ArrayList<Boolean>> isSudahDinilai = new HashMap<String, ArrayList<Boolean>>();

    kelas(int tingkat, String jurusan, String kategori, sekolah sekolah) {
        this.kategori = kategori;
        this.tingkat = tingkat;
        this.jurusan = jurusan;
        this.sekolah = sekolah;
        this.isIstirahat = false;
        this.isTugasDikumpulkan = false;
    }

    // method untuk menyampaikan pesan UH dari guru ke siswa
    public boolean doTugasUlangan(String namaGuru, String namaMapel, int uh, sekolah.mapel mapel) {
        this.mapel = mapel;
        if ((sekolah.isBelMasuk == false) && (sekolah.isLibur == false)) {
            System.out.println("Jam pertama belum dimulai! tidak dapat memberikan tugas!");
            return false;
        } else {
            if ((sekolah.isLibur == true) || (sekolah.isIstirahat == true)) {
                if (sekolah.isLibur == true) {
                    System.out.println(
                            "Sekolah sedang libur! Pak/Bu " + namaGuru + " tidak dapat memberikan tugas/ulangan");
                    this.isLibur = true;
                    return false;
                } else {
                    System.out.println(
                            "Kelas sedang jam istirahat! Pak/Bu " + namaGuru + " tidak dapat memberikan tugas/ulangan");
                    this.isIstirahat = true;
                    return false;
                }
            } else {
                this.isLibur = false;
                this.isTugasUlangan = 0;
                System.out.println("Kelas " + getTingkat() + "-" + getKategori() + " diberi tugas/ulangan " + namaMapel
                        + " ke-" + uh + " oleh Pak/Bu " + namaGuru);
                this.jumlahTugas += 1;
                this.indeksNilaiPerPertemuan.add((float) 0);
                return true;
            }
        }
    }

    // method melihat siswa hadir
    public void jumlahSiswa() {
        if (sekolah.isLibur == false) {
            System.out.println("jumlah siswa kelas " + getTingkat() + "-" + getKategori()
                    + " yang hadir hari ini sebanyak " + jumlahSiswa + " siswa");
        } else {
            System.out.println("sekolah hari ini libur! Tidak ada siswa yang hadir!");
        }
    }

    // method menampilkan biodata kelas
    public void displayKelas(){
        System.out.println("Angkatan : "+this.tingkat);
        System.out.println("Kategori : "+this.kategori);
        System.out.println("Jurusan  : "+this.jurusan);
        System.out.println("Sekolah  : "+this.sekolah.namaSekolah);
    }
    

    public boolean getLibur() {
        return sekolah.isLibur;
    }

    public int getTingkat() {
        return this.tingkat;
    }

    public String getJurusan() {
        return this.jurusan;
    }

    public String getKategori() {
        return this.kategori;
    }

}
