package com.javaoop.tugas.smt_3.PRAKTIKUM.tokolapak;

public class barang extends daftarBarang {
    private String nama;
    private double berat;
    private double harga;

    barang(String nama, double berat, double harga, double jumlah) {
        this.nama = nama;
        this.berat = berat;
        this.harga = harga;
        daftarBarang.setBeratBarang(berat * jumlah);
        daftarBarang.setHargaTotal(harga * jumlah);
        daftarBarang.namaBarang(nama, berat, harga, jumlah);
    }

    public String getNamaBarang() {
        return this.nama;
    }

    public double getBerat() {
        return this.berat;
    }

    public double getHarga() {
        return this.harga;
    }

}
