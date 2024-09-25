package com.javaoop.tugas.KUIS;

import java.util.*;

public class guru {
    private String nama;
    sekolah.mapel mapel;
    String namaMapel;
    kelas kelas;
    String tugasDiberikan = "0";

    guru(String nama, sekolah.mapel mapel) {
        this.nama = nama;
        this.mapel = mapel;
        this.namaMapel = mapel.namaMapel;
    }

    public String getNama() {
        return this.nama;
    }

    // method ngasih tugas/ulangan
    public void doTugasUlangan(kelas kelas) {
        mapel.uh += 1;
        mapel.indeksTugas.add((this.tugasDiberikan == null) ? "" : tugasDiberikan);
        mapel.isSudahDinilai.put(this.namaMapel, new ArrayList<Boolean>());
        kelas.isSudahDinilai.put(this.namaMapel, new ArrayList<Boolean>());
        for (int x = 1; x <= mapel.uh; x++) {
            mapel.isSudahDinilai.get(this.namaMapel).add(false);
            kelas.isSudahDinilai.get(this.namaMapel).add(false);
        }
        kelas.indeksTugas = mapel.indeksTugas;
        mapel.daftarNilaiMapel.put(this.namaMapel, new ArrayList<Float>());
        kelas.daftarNilaiMapel.put(this.namaMapel, new ArrayList<Float>());
        for (int x = 1; x <= mapel.uh; x++) {
            mapel.daftarNilaiMapel.get(this.namaMapel).add((float) 0);
            kelas.daftarNilaiMapel.get(this.namaMapel).add((float) 0);
        }
        mapel.indeksTugas.set(mapel.uh - 1, (this.tugasDiberikan == null) ? "" : tugasDiberikan);
        kelas.doTugasUlangan(this.nama, this.namaMapel, mapel.uh, this.mapel);
        kelas.uh += 1;
        this.kelas = kelas;
    }

    // method mengumpulkan tugas siswa
    public void kumpulkanTugas(kelas kelas) {
        if (kelas.isTugasUlangan == 2) {
            System.out.println("Tidak ada tugas/UH saat ini untuk dikumpulkan dari kelas : " + kelas.getTingkat() + "-"
                    + kelas.getKategori());
        } else {
            System.out.println("Waktu habis! harap siswa kelas " + kelas.getTingkat() + "-" + kelas.getKategori()
                    + " segera mengumpulkan tugas/UH " + mapel.namaMapel);
            kelas.isTugasDikumpulkan = true;
        }
    }

    // menilai tugas/ulangan
    public void nilaiTugasUlangan(siswa siswa, float nilai, int indeks) {
        if ((indeks <= 0) || (indeks > mapel.uh)) {
            if (indeks <= 0) {
                System.out.println("Tugas/Uh harus dimulai dari ke-1");
            } else {
                System.out.println("tidak ada tugas/UH " + mapel.namaMapel
                        + " baru untuk dinilai! jumlah tugas saat ini adalah " + mapel.uh);
            }
        } else {
            if (mapel.indeksTugas.get(indeks - 1).equals("1")) {
                if (mapel.indeksNilai.size() >= indeks) {
                    if (mapel.indeksNilai.get(indeks - 1) == indeks) {
                        System.out.println("siswa " + siswa.getNamaSiswa() + " (" + siswa.noAbsen
                                + ") telah diberikan nilai sebelumnya (" + siswa.getNilaiSiswa() + ")");
                    } else {
                        System.out.println("Pak/Bu " + this.nama + " memberikan nilai " + nilai + " untuk tugas/UH "
                                + mapel.namaMapel + " ke-" + indeks + " pada " + siswa.getNamaSiswa() + " ("
                                + siswa.noAbsen + ")");
                        mapel.indeksNilai.add(indeks);
                        mapel.indeksNilaiPerPertemuan.set(indeks - 1, nilai);
                        siswa.kelas1.indeksNilaiPerPertemuan = mapel.indeksNilaiPerPertemuan;
                        mapel.daftarNilaiMapel.get(this.namaMapel).add(indeks, nilai);
                        mapel.daftarNilaiMapel.get(this.namaMapel).remove(indeks - 1);
                        siswa.kelas1.daftarNilaiMapel.get(this.namaMapel).add(indeks, nilai);
                        siswa.kelas1.daftarNilaiMapel.get(this.namaMapel).remove(indeks - 1);
                        siswa.setNilaiSiswa(nilai);
                        siswa.jumlahTugasdinilai += 1;
                    }
                } else {
                    System.out.println(
                            "Pak/Bu " + this.nama + " memberikan nilai " + nilai + " untuk tugas/UH " + mapel.namaMapel
                                    + " ke-" + indeks + " pada " + siswa.getNamaSiswa() + " (" + siswa.noAbsen + ")");
                    mapel.indeksNilai.add(indeks);
                    mapel.indeksNilaiPerPertemuan.set(indeks - 1, nilai);
                    siswa.kelas1.indeksNilaiPerPertemuan = mapel.indeksNilaiPerPertemuan;
                    mapel.daftarNilaiMapel.get(this.namaMapel).add(indeks, nilai);
                    mapel.daftarNilaiMapel.get(this.namaMapel).remove(indeks - 1);
                    siswa.kelas1.daftarNilaiMapel.get(this.namaMapel).add(indeks, nilai);
                    siswa.kelas1.daftarNilaiMapel.get(this.namaMapel).remove(indeks - 1);
                    siswa.setNilaiSiswa(nilai);
                    siswa.jumlahTugasdinilai += 1;
                }
            } else {
                if (siswa.kelas1.daftarNilaiMapel.containsKey(mapel.namaMapel) == false) {
                    System.out.println("tidak dapat memberikan nilai kepada " + siswa.getNamaSiswa() + " ("
                            + siswa.noAbsen + ") karena kelas " + siswa.kelas1.tingkat + "-" + siswa.kelas1.kategori
                            + " belum diberikan tugas " + this.namaMapel + "!");
                } else {
                    System.out.println("tidak dapat memberikan nilai karena " + siswa.getNamaSiswa() + " ("
                            + siswa.noAbsen + ") tidak mengerjakan tugas/UH ke-" + indeks);
                }
            }
        }
    }
}
