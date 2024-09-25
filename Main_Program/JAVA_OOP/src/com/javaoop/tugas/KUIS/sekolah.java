package com.javaoop.tugas.KUIS;

import java.util.ArrayList;
import java.util.*;

public class sekolah {
    String namaSekolah;
    String lokasi;
    String jenjang;
    boolean isLibur;
    sekolah sekolah1;
    boolean isIstirahat;
    boolean isBelMasuk;

    sekolah(String nama, String lokasi, String jenjang) {
        this.namaSekolah = nama;
        this.lokasi = lokasi;
        this.jenjang = jenjang;
        this.isIstirahat = false;
        this.isLibur = false;
        this.isBelMasuk = false;
    }

    public class mapel {
        String namaMapel;
        int uh;
        int doingTugas;
        float nilaiPerMapel;
        ArrayList<String> indeksTugas = new ArrayList<String>();
        ArrayList<Integer> indeksNilai = new ArrayList<Integer>();
        ArrayList<Float> indeksNilaiPerPertemuan = new ArrayList<Float>();
        Map<String, ArrayList<Float>> daftarNilaiMapel = new HashMap<String, ArrayList<Float>>();
        Map<String, ArrayList<Boolean>> isSudahDinilai = new HashMap<String, ArrayList<Boolean>>();

        mapel(String nama) {
            this.namaMapel = nama;
        }

        public String getMapel() {
            return namaMapel;
        }

        public float getNilaiMapel() {
            return this.nilaiPerMapel;
        }

        public int getLength() {
            return indeksTugas.size();
        }
    }

    public void Masuk() {
        System.out.println("Saatnya Jam pertama Dimulai!!");
        isLibur = false;
    }

    public void Libur() {
        System.out.println("Sekolah hari ini diliburkan! silakan belajar mandiri di rumah!");
        isLibur = true;
    }

    public void istirahat() {
        System.out.println("Saatnya Jam istirahat!!");
        this.isIstirahat = true;
    }

    public void mulaijamPertama() {
        System.out.println("Saanya kelas jam pertama dimulai!");
        isBelMasuk = true;
    }
}
