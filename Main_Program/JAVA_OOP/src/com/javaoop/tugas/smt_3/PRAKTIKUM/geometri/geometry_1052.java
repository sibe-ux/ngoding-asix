package com.javaoop.tugas.smt_3.PRAKTIKUM.geometri;

class kubus{
    double rusuk;

    kubus(double newRusuk){
        rusuk = newRusuk;
    }

    double hitungVolume(){
        return Math.pow(rusuk,3);
    }

    double hitungLuas(){
        return 6*(rusuk*rusuk);
    }
    
    double hitungKeliling(){
        return 12*rusuk;
    }
}

public class geometry_1052 {
    public static void main(String[] args) {
        kubus kubus1 = new kubus(10);
        System.out.println("volume : " + kubus1.hitungVolume());
        System.out.println("Luas : " + kubus1.hitungLuas());
        System.out.println("keliling : " + kubus1.hitungKeliling());
    }
}
