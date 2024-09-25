package com.javaoop.tugas.smt_3.PRAKTIKUM.Enkapsulasi_Polymorphisme;

public class Laptop {

    // enkapsulasi
    private String nama;
    private String Storage;
    private int Ram;

    Laptop(String nama, String storage, int ram) {
        this.nama = nama;
        this.Ram = ram;
        this.Storage = storage;
    }

    public void booting() {
        System.out.println("Laptop       : " + getName());
        System.out.println("RAM          : " + getRam() + " GB");
        System.out.println("Type Storage : " + getStorage());
        if (getStorage().equals("HDD")) {
            System.out.println("Time Booting : 50s\n");
        } else if (getStorage().equals("SSD")) {
            System.out.println("Time Booting : 10s\n");
        } else {
            System.out.println("Unknown Storage (HDD & SSD)");
        }
    }

    public int getRam() {
        return this.Ram;
    }

    public String getName() {
        return this.nama;
    }

    public String getStorage() {
        return this.Storage.toUpperCase();
    }

    public void Upgrade(String Storage) {
        System.out.println("Laptop " + getName() + " Upgrade Storage to " + Storage.toUpperCase());
        this.Storage = Storage;
    }

    // overloading
    public void Upgrade(String Storage,int ram) {
        System.out.println("Laptop " + getName() + " Upgrade Storage to " + Storage.toUpperCase()+" And RAM to "+ram+" GB");
        this.Storage = Storage;
        this.Ram = ram;
    }

    // overloading
    public void Upgrade(int ram) {
        System.out.println("Laptop " + getName() + " Upgrade RAM to "+ram+" GB");
        this.Ram = ram;
    }

    public void testFPS() {
        System.out.println("\nLaptop       : " + getName());
        System.out.println("RAM          : " + getRam() + " GB");
        System.out.println("Type Storage : " + getStorage());
        System.out.println("GPU          : No VGA (Integrated GPU)");
        System.out.println("Battery      : Not Charged (No Performance Increase)");

        float fps = 0;
        if (getStorage().equals("HDD")) {
            fps += 20;
        } else if (getStorage().equals("SSD")) {
            fps += 40;
        } else {
            System.out.println("Unknown Storage");
        }
        if (getRam() <= 4) {
            fps += 10;
        } else if (getRam() <= 8) {
            fps += 15;
        } else if (getRam() <= 16) {
            fps += 20;
        } else if (getRam() >= 32) {
            fps += 25;
        }
        System.out.println("FPS Rate     : " + fps + " FPS");
    }

    // overloading
    public void testFPS(Charging charge) {
        System.out.println("\nLaptop       : " + getName());
        System.out.println("RAM          : " + getRam() + " GB");
        System.out.println("Type Storage : " + getStorage());
        System.out.println("GPU          : No VGA (Integrated GPU)");
        System.out.println(charge.getCharge()); 

        float fps = 0;
        if (getStorage().equals("HDD")) {
            fps += 20;
        } else if (getStorage().equals("SSD")) {
            fps += 40;
        } else {
            System.out.println("Unknown Storage");
        }
        if (getRam() <= 4) {
            fps += 10;
        } else if (getRam() <= 8) {
            fps += 15;
        } else if (getRam() <= 16) {
            fps += 20;
        } else if (getRam() >= 32) {
            fps += 25;
        }
        fps += (fps * 0.2);
        System.out.println("FPS Rate     : " + fps + " FPS");
    }
}
