package com.javaoop.tugas.smt_3.TM.objectClass;

class mobilSedan{
    String warna;
    String plat;
    String jenis;
    double berat;
    int year;
    double price;

    mobilSedan(String inputJenis, String inputWarna, String inputPlat, double inputBerat, int inputYear, double inputprice){
        this.warna = inputWarna;
        this.plat = inputPlat;
        this.jenis = inputJenis;
        this.berat = inputBerat;
        this.year = inputYear;
        this.price = inputprice; 
    }

    void display(){
        System.out.println("jenis : "+this.jenis);
        System.out.println("warna : "+this.warna);
        System.out.println("plat  : "+this.plat);
        System.out.println("berat : "+this.berat +" KG");
        System.out.println("tahun : "+this.year);
        System.out.println("harga : Rp."+this.price +" Juta");
    }

    String getJenis(){ //getter
        return this.jenis;
    }

    void setJenis(String jenis){
        this.jenis = jenis;
    }

    String getWarna(){
        return this.warna;
    }

    void setWarna(String warna){
        this.warna = warna;
    }

    String getPlat(){
        return this.plat;
    }

    void setPlat(String plat){
        this.plat = plat;
    }

    double getBerat(){
        return this.berat;
    }

    void setBerat(double berat){
        this.berat = berat;
    }

    int getYear(){
        return this.year;
    }

    void setYear(int year){
        this.year = year;
    }

    double getPrice(){
        return this.price;
    }

    void setPrice(double price){
        this.price = price;
    }
}

public class mobil {
    public static void main(String[] args) {
        mobilSedan sedan1 = new mobilSedan("BMW", "silver","AG BGH 34", 200, 2013, 500);
        System.out.println("mobil : "+ sedan1.getJenis());
        System.out.println("warna : "+ sedan1.getWarna());
        System.out.println("plat  : "+ sedan1.getPlat());
        System.out.println("berat : "+ sedan1.getBerat()+" KG");
        System.out.println("tahun : "+ sedan1.getYear());
        System.out.println("harga : Rp."+ sedan1.getPrice()+" juta");
        System.out.println("=================");

        sedan1.setJenis("Lambo");
        // System.out.println("mobil : "+ sedan1.getJenis());
        sedan1.setWarna("merah");
        sedan1.setPlat("AG 563 AKS");
        sedan1.setBerat(300);
        sedan1.setYear(2017);
        sedan1.setPrice(700);

        sedan1.display();
    }
    
}
