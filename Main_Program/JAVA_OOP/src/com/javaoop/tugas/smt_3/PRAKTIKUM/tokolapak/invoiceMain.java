package com.javaoop.tugas.smt_3.PRAKTIKUM.tokolapak;

public class invoiceMain {
    public static void main(String[] args) {
        // class ekspedisi
        ekspedisi jne = new ekspedisi("JNE", 15000, 20000, 30000, 40000);
        ekspedisi jnt = new ekspedisi("J&T", 16000, 22000, 32000, 38000);
        ekspedisi Sicepat = new ekspedisi("SiCepat", 15000, 21000, 29000, 40000);
        ekspedisi Anteraja = new ekspedisi("Anteraja", 14000, 22000, 30000, 39000);
        ekspedisi Ninja_Express = new ekspedisi("Ninja Express", 17000, 21000, 32000, 41000);

        // class pembeli (katanya ga bisa bikin object kalo gada class person)
        // aku ga ngerti gimana maksutnya xixixi
        pembeli user1 = new pembeli("sibe", "pria", "blitar");

        // class barang (Nama barang ga boleh sama, ingat ya nama barangnya, bukan nama objectnya)
        // soalnya kalo sama nanti jadi dihitung sebagai satu object yang sama hehe (salah satu g dianggap)
        barang RAM = new barang("V-GeN DDR4-16GB", 0.01, 1320000, 2);
        barang SSD = new barang("SSD NVMe 1TB", 0.102, 1488500, 2);
        barang VGA = new barang("MSI RTX 3080 TI", 2, 30987231, 1);
        barang CPU = new barang("Ryzen 9 5950X", 1, 12393000, 1);
        barang CSG = new barang("Aorus C700 RGB", 6, 5890000, 1);


        // nama paket ekspedisi (harus disamakan kaya ini, lowercase & uppercase diabaikan)
        // 1. ekonomis
        // 2. regular
        // 3. instan
        // 4. sehari_sampai

        // class static daftarBarang, ga perlu bikin object ea, langsung dipanggil via nama classnya
        daftarBarang.checkOut(jnt, "ReGuLaR");
    }
}
