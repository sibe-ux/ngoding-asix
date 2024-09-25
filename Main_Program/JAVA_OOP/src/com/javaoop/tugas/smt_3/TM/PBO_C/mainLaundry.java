package com.javaoop.tugas.smt_3.TM.PBO_C;

class pelanggan{
    String namaPelanggan; // cahya
    int tanggalMencuci; // 110921
    double uangDibayarkan;
    double uangPembayaran; //500000
    double uangLunas;
    int laundry; // 5 kg
    boolean isLunas; // true false

    public pelanggan(String namaPelanggan, int tanggalMencuci, double uangPembayaran, int laundry,double uangDibayarkan){
        this.namaPelanggan = namaPelanggan;
        this.tanggalMencuci = tanggalMencuci;
        this.uangPembayaran = uangPembayaran;
        this.laundry = laundry;
        this.uangDibayarkan = uangDibayarkan;
    }

    public void setNama(String nama){ // setter
        this.namaPelanggan = nama;
    } 

    public void setUangDibayarkan(double uang){ // setter
        this.uangDibayarkan = uang;
    }

    public double getUangPembayaran(){ // getter
        return uangLunas = uangDibayarkan - uangPembayaran;
    }

    public void uangPembayaran(){
        if (getUangPembayaran()<0){
            isLunas=false;
            System.out.println(uangDibayarkan+" - "+uangPembayaran);
            System.out.println("sisa biaya yang harus dibayarkan : "+(0-uangLunas));
        } else{
            isLunas = true;
            System.out.println(uangDibayarkan+" - "+uangPembayaran);
            System.out.println("sisa biaya yang harus dibayarkan : 0.00");
        }
    }

    public void isLunas(){
        if(this.isLunas==true){
            System.out.println("biaya laundry telah lunas");
        } else{
            System.out.println("biaya laundry belum lunas");
            System.out.println("sisa biaya yang harus dibayar : "+(0-uangLunas));
        }
    }
}

class laundry{
    String nama;
    pelanggan pelanggan;
    boolean isBuka;

    public laundry(String nama){
        this.nama = nama;
        isBuka = true;
    }

    public void riwayatLaundry(pelanggan x){ // setter
        this.pelanggan = x;
        System.out.println("\n========"+pelanggan.namaPelanggan+"========");
        System.out.println("Nama : "+pelanggan.namaPelanggan);
        System.out.println("Tanggal : "+pelanggan.tanggalMencuci);
        System.out.println("Harga : "+pelanggan.uangPembayaran);
        System.out.println("Berat : "+pelanggan.laundry+" KG");
        pelanggan.uangPembayaran();
        pelanggan.isLunas();
    }
}

public class mainLaundry {
    public static void main(String[] args) {
        pelanggan A = new pelanggan("cahya", 110921, 10000, 5, 20000);
        pelanggan B = new pelanggan("abdul", 231222, 20000, 2, 10000);
        
        laundry cahaya = new laundry("cahaya");
        System.out.println(cahaya.nama);
        // setter
        cahaya.riwayatLaundry(A);
        // setter
        A.setNama("Sibe");
        A.setUangDibayarkan(5000);
        cahaya.riwayatLaundry(A);
        cahaya.riwayatLaundry(B);
    }       
}
