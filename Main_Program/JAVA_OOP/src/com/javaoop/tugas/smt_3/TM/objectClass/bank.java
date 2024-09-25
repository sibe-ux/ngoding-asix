package com.javaoop.tugas.smt_3.TM.objectClass;

class rekening{
    String pemilik;
    String nama;
    int nomor;
    int pin;
    double saldo;

    rekening(String pemilik, String nama, int nomor, int pin, double saldo){
        this.pemilik = pemilik;
        this.nama = nama;
        this.nomor = nomor;
        this.pin = pin;
        this.saldo = saldo;
    }

    void display(){
        System.out.println("pemilik : " +this.pemilik);
        System.out.println("bank    : " +this.nama);
        System.out.println("nomor   : "+this.nomor);
        System.out.println("pin     : "+this.pin);
        System.out.println("saldo   : Rp."+this.saldo);
    }

    String getPemilik(){
        return this.pemilik;
    }

    void setPemilik(String pemilik){
        this.pemilik = pemilik;
    }

    String getNama(){
       return this.nama; 
    }

    void setNama(String nama){
        this.nama = nama;
    }

    int getNomor(){
        return this.nomor;
    }

    void setNomor(int nomor){
        this.nomor = nomor;
    }

    int getPin(){
        return this.pin;
    }

    void setPin(int pin){
        this.pin = pin;
    }

    double getSaldo(){
        return this.saldo;
    }

    void setSaldo(double saldo){
        this.saldo = saldo;
    }

    void tambahSaldo(double saldo){
        this.saldo += saldo;
        System.out.println("saldo masuk : Rp."+saldo);
        System.out.println("saldo saat ini : Rp."+this.saldo);
    }

    void tarikTunai(double saldo){
        this.saldo -= saldo;
        System.out.println("saldo keluar : Rp."+saldo);
        System.out.println("saldo saat ini : Rp."+this.saldo);
    }
    }


public class bank {
    public static void main(String[] args) {
        rekening bca = new rekening("sibe", "BCA", 3438725, 342169, 500000);
        System.out.println("pemilik : " +bca.getPemilik());
        System.out.println("bank    : " +bca.getNama());
        System.out.println("nomor   : "+bca.getNomor());
        System.out.println("pin     : "+bca.getPin());
        System.out.println("saldo   : Rp."+bca.getSaldo());
        bca.tambahSaldo(200000);
        bca.tarikTunai(100000);
        System.out.println("====================");

        bca.setPemilik("habi");
        bca.setNama("bni");
        bca.setNomor(47346273);
        bca.setPin(365426);
        bca.setSaldo(300000);
        bca.display();
    }
    }

