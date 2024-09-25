package com.javaoop.tugas.KUIS;

import java.util.*;

public class siswa {
    private String nama;
    private float nilai;
    int noAbsen;
    String jurusan;
    int tingkat;
    String kategori;
    boolean isPresensi;
    boolean isIzin;
    kelas kelas1;
    boolean done;
    int jumlahTugasDikerjakan;
    int jumlahTugasdinilai;
    sekolah.mapel mapel;
    int tugasDiberikan;

    siswa(String nama, int absen, kelas kelas) {
        this.nama = nama;
        this.noAbsen = absen;
        this.isPresensi = false;
        this.isIzin = false;
        this.jurusan = kelas.getJurusan();
        this.tingkat = kelas.getTingkat();
        this.kategori = kelas.getKategori();
        this.kelas1 = kelas;
        kelas.jumlahSiswa += 1;
    }

    public String getNamaSiswa() {
        return this.nama;
    }

    public float getNilaiSiswa() {
        return this.nilai;
    }

    public void setNilaiSiswa(float nilai) {
        this.nilai += nilai;
    }

    // method mengerjakan tugas/UH
    public void doingTugasUlangan(sekolah.mapel mapel) {
        this.mapel = mapel;
        if ((this.isPresensi == true) && (this.isIzin == false)) {
            if (kelas1.daftarNilaiMapel.containsKey(mapel.namaMapel) == false) {
                System.out.println(nama + " (" + noAbsen + ") tidak dapat mengerjakan tugas/ulangan karena kelas "
                        + kelas1.tingkat + "-" + kelas1.kategori + " belum diberi tugas " + mapel.namaMapel);
            } else {
                mapel.doingTugas += 1;
                if (mapel.doingTugas > mapel.uh) {
                    System.out.println("tidak ada tugas/UH " + mapel.namaMapel
                            + " baru untuk diselesaikan! jumlah tugas saat ini adalah " + mapel.uh);
                } else {
                    if (kelas1.isTugasDikumpulkan == true) {
                        System.out.println(nama + " (" + noAbsen + ") "
                                + "Tidak dapat mengerjakan tugas/UH karena Waktu pengerjaan sudah habis!");
                    } else {
                        System.out.println("Siswa absen " + noAbsen + " (" + nama + ") telah mengerjakan tugas "
                                + mapel.namaMapel + " ke-" + mapel.doingTugas);
                        this.done = true;
                        mapel.indeksNilaiPerPertemuan.add((float) 0);
                        mapel.indeksNilaiPerPertemuan.set(mapel.doingTugas - 1, (float) 0);
                        mapel.isSudahDinilai.get(mapel.namaMapel).add(mapel.doingTugas, true);
                        mapel.isSudahDinilai.get(mapel.namaMapel).remove(mapel.doingTugas - 1);
                        kelas1.isSudahDinilai.get(mapel.namaMapel).add(mapel.doingTugas, true);
                        kelas1.isSudahDinilai.get(mapel.namaMapel).remove(mapel.doingTugas - 1);

                        mapel.indeksTugas.set(mapel.doingTugas - 1, "1");
                        this.jumlahTugasDikerjakan += 1;
                    }
                }
            }
        } else {
            if (this.isIzin == true) {
                System.out.println(nama + " (" + noAbsen + ") "
                        + "Tidak dapat mengerjakan tugas/ulangan karena hari ini tidak hadir!");
            } else {
                System.out.println(
                        nama + " (" + noAbsen + ") " + "Silakan presensi terlebih dahulu sebelum mengerjakan Tugas/UH");
            }
        }
    }

    // method izin
    public void izin() {
        if (kelas1.getLibur() == true) {
            System.out.println("Sekolah hari ini libur, tidak perlu membuat surat izin!");
        } else {
            System.out.println(nama + " (" + noAbsen + ") izin tidak hadir ke sekolah!!");
            this.isPresensi = false;
            this.isIzin = true;
            kelas1.jumlahSiswa -= 1;
        }
    }

    // method presensi
    public void presensi() {
        if ((kelas1.getLibur() == true) || this.isIzin == true) {
            if (kelas1.getLibur() == true) {
                System.out.println("Sekolah Diliburkan! Silakan pulang dan tidak perlu presensi!");
            } else {
                System.out
                        .println(nama + " (" + noAbsen + ") hari ini izin tidak hadir! tidak perlu melakukan presensi");
            }
        } else {
            if (this.isPresensi == true) {
                System.out.println(
                        nama + " (" + noAbsen + ") sudah melakukan presensi! Tidak perlu melakukan presensi kembali");
            } else {
                System.out.println(nama + " (" + noAbsen + ") Telah berhasil dalam melakukan presensi!");
                this.isPresensi = true;
            }
        }
    }

    // method menampikan nilai pelajaran
    public void hasil() {
        System.out.println("\n============== Daftar Nilai Mapel : " + this.nama + " =================");
        System.out.println("Nama\t: "+this.nama);
        System.out.println("absen\t: "+this.noAbsen);
        System.out.println("kelas\t: "+this.tingkat+"-"+this.kategori);
        if (kelas1.isTugasUlangan == 0) {
            for (Map.Entry<String, ArrayList<Float>> entry : kelas1.daftarNilaiMapel.entrySet()) {
                String key = entry.getKey();
                ArrayList<Float> value = entry.getValue();
                // int x = kelas1.isSudahDinilai.get(key).size();
                int x = 0;
                int y = 0;
                for (float z : value) {
                    x++;
                    y++;
                    // nilai += z;
                    kelas1.mapel.nilaiPerMapel += z;
                    if (kelas1.isSudahDinilai.get(key).get(x - 1) == true) {
                        if (z != (float) 0) {
                            System.out.println("Nilai tugas/UH " + key + " ke-" + y + " : " + z);
                        } else {
                            System.out.println(
                                    "Nilai tugas/UH " + key + " ke-" + y + " belum ada! guru belum memberikan nilai!");
                        }
                    } else {
                        System.out.println("Nilai tugas/UH " + key + " ke-" + y
                                + " adalah 0, Karena tidak mengerjakan ulangan/tugas");
                    }
                }
                System.out.println(
                        "rata-rata nilai : " + (kelas1.mapel.nilaiPerMapel / kelas1.isSudahDinilai.get(key).size()));
                kelas1.mapel.nilaiPerMapel = (float) 0;
            }
            System.out.println("Total rata-rata dari keseluruhan mapel : " + nilai / kelas1.uh);
        } else {
            if ((kelas1.isLibur == true) || (kelas1.isIstirahat = true)) {
                System.out.println("belum ada tugas/ulangan yang diberikan kepada kelas " + kelas1.getTingkat() + "-"
                        + kelas1.getKategori());
            }
        }
    }
}

// int a = kelas1.indeksTugas.size();
// System.out.println(kelas1.indeksTugas);
// int y = 0;
// for (int x = 1; x <= a; x++) {
// y += 1;
// if (kelas1.indeksTugas.get(x - 1).equals("1")) {
// if (kelas1.indeksNilaiPerPertemuan.get(y - 1) != 0) {
// System.out
// .println("Nilai tugas/UH ke-" + y + " : " +
// kelas1.indeksNilaiPerPertemuan.get(y - 1));
// } else {
// System.out.println("Nilai tugas/UH ke-" + y + " belum ada! guru belum
// memberikan nilai!");
// }
// } else {
// System.out.println("Nilai tugas/UH ke-" + y + " adalah 0, Karena tidak
// mengerjakan ulangan/tugas");
// }
// }
// System.out.println("rata-rata nilai : " + (nilai / kelas1.uh));
// } else {
// if ((kelas1.isLibur == true) || (kelas1.isIstirahat = true)) {
// System.out.println("belum ada tugas/ulangan yang diberikan kepada kelas " +
// kelas1.getTingkat() + "-"
// + kelas1.getKategori());
// }