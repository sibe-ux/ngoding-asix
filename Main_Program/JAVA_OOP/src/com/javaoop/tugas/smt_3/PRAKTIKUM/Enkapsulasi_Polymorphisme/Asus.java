package com.javaoop.tugas.smt_3.PRAKTIKUM.Enkapsulasi_Polymorphisme;

public class Asus extends Laptop {

    Asus(String nama,String storage,int ram) {
        super(nama,storage,ram);
    }

    // overriding
    @Override
    public void testFPS() {
        System.out.println("\nLaptop       : " + getName());
        System.out.println("RAM          : " + getRam() + " GB");
        System.out.println("Type Storage : " + getStorage());
        System.out.println("GPU          : AMD Radeon (Integrated GPU, Increase 30%)");
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
        fps += (fps * 0.3);
        System.out.println("FPS Rate     : " + fps + " FPS");
    }

    // overloading & Overriding
    @Override
    public void testFPS(Charging charge) {
        System.out.println("\nLaptop       : " + getName());
        System.out.println("RAM          : " + getRam() + " GB");
        System.out.println("Type Storage : " + getStorage());
        System.out.println("GPU          : AMD Raedon (Integrated GPU, Increase 30%)");
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
        fps += (fps * 0.5);
        System.out.println("FPS Rate     : " + fps + " FPS");
    }

}
