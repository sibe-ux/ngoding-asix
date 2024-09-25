package com.javaoop.tugas.smt_3.PRAKTIKUM.tokolapak;

import java.util.ArrayList;
import java.util.*;
import java.util.Locale;
import java.text.DecimalFormat;

public class daftarBarang {

    private static double hargaTotal;
    private static double beratBarang;
    private static Map<String, ArrayList<Double>> namelist = new HashMap<String, ArrayList<Double>>();

    public static void checkOut(ekspedisi ekspedisi, String paket) {
        System.out.println("keranjang Belanja : ");
        System.out.println("======================================");
        double subtotal = 0;
        float berat = 0;
        for (Map.Entry<String, ArrayList<Double>> entry : namelist.entrySet()) {
            ArrayList<Double> value = entry.getValue();
            String key = entry.getKey();
            float b = (float) Math.abs(value.get(0));
            int h = (int) Math.round(value.get(1));
            int j = (int) Math.round(value.get(2));
            String hasil = String.format(Locale.GERMANY, "%,d", h);
            System.out.println(key + "\t(Rp." + hasil + " x " + j + ")");
            System.out.println("Rp." + String.format(Locale.GERMANY, "%,d", h * j) + "\n");
            subtotal += value.get(1) * value.get(2);
            berat += b;
        }
        System.out.println("======================================");
        int ongkos = 0;
        String namaPaket = "";
        boolean tampilkan = false;
        switch (paket.toLowerCase()) {
            case ("ekonomis"):
                ongkos = ekspedisi.ekonomis;
                namaPaket = "Ekonomis";
                tampilkan = true;
                break;
            case ("regular"):
                ongkos = ekspedisi.regular;
                namaPaket = "Regular";
                tampilkan = true;
                break;
            case ("instan"):
                ongkos = ekspedisi.instan;
                namaPaket = "Instan";
                tampilkan = true;
                break;
            case ("sehari_sampai"):
                ongkos = ekspedisi.sehari_sampai;
                namaPaket = "Sehari Sampai";
                tampilkan = true;
                break;
            default:
                System.out.println("Paket Ekspedisi tidak ditemukan");
                System.out.println("list Paket ekspedisi : \n1. ekonomis \n2. regular \n3. instan \n4. sehari_sampai");
        }
        if (tampilkan == true) {
            int subTotal = (int) Math.round(subtotal);
            String total = String.format(Locale.GERMANY, "%,d", subTotal);
            System.out.println("Subtotal : Rp." + total);
            DecimalFormat df = new DecimalFormat("#.##");
            float totalBerat = Math.round(berat);
            System.out.println("\nBerat : " + df.format(berat) + " KG");
            String namaEkspedisi = ekspedisi.namaEkspedisi;
            System.out.println("Ekspedisi pengiriman : " + namaEkspedisi + " - " + namaPaket);
            System.out.println("Ongkos kirim : Rp." + String.format(Locale.GERMANY, "%,d", (int) totalBerat * ongkos));
            System.out.println("\nTotal : Rp."
                    + String.format(Locale.GERMANY, "%,d", subTotal + ((int) totalBerat * ongkos)) + "\n");
        }
    }

    public static void namaBarang(String nama, Double berat, Double harga, Double jumlah) {
        daftarBarang.namelist.put(nama, new ArrayList<Double>());
        daftarBarang.namelist.get(nama).add(berat);
        daftarBarang.namelist.get(nama).add(harga);
        daftarBarang.namelist.get(nama).add(jumlah);
    }

    public static void setBeratBarang(Double berat) {
        daftarBarang.beratBarang += berat;
    }

    public static double getberatBarang() {
        return daftarBarang.beratBarang;
    }

    public static void setHargaTotal(Double harga) {
        daftarBarang.hargaTotal += harga;
    }

    public static double getHargaTotal() {
        return daftarBarang.hargaTotal;
    }

}
