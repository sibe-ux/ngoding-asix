package com.javaoop.tugas.KUIS;

public class MainStudy {
    public static void main(String[] args) {

        sekolah smasa = new sekolah("SMAN 01 Blitar", "BLitar", "SMA");

        sekolah.mapel kimia = smasa.new mapel("KIMIA");

        kelas xai = new kelas(1, "MIPA", "A1", smasa);

        guru pakAnton = new guru("Pak Anton", kimia);

        siswa reza = new siswa("Reza", 20, xai);

        smasa.mulaijamPertama();
        pakAnton.doTugasUlangan(xai);
        reza.presensi();
        reza.doingTugasUlangan(kimia);
        pakAnton.nilaiTugasUlangan(reza, 90, 1);
        pakAnton.nilaiTugasUlangan(reza, 100, 6);
        // reza.hasil();
        reza.doingTugasUlangan(kimia);
        pakAnton.kumpulkanTugas(xai);
        
        reza.izin();
        reza.doingTugasUlangan(kimia);
        xai.jumlahSiswa();

        // method guru memberikan tugas/ulangan
        // method menyampaikan UH/Tugas dari guru
        // method sekolah libur
        // method sekolah masuk
        // method izin
        // method presensi
        // melihat jumlah siswa dalam kelas
        // method jam istirahat
        // guru memberikan nilai
        // method bel masuk kelas
        // method mengumpulkan tugas
        // method displayKelas
        
    }
}
