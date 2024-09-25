package com.javaoop.tugas.smt_3.PRAKTIKUM.geometri;

class weapon {
    int magazine;
    int remagazine;

    // method untuk kategori senjata
    void weaponCategory(String weap, String ammo, String tipeWeap, String range, int magazine) {
        System.out.println("weapon : " + weap);
        System.out.println("Type Ammo : " + ammo);
        System.out.println("Type weapon : " + tipeWeap);
        System.out.println("Range : " + range);
        this.magazine = magazine;
        remagazine = magazine;
        System.out.println("Default Ammo : " + magazine);
    }

    // method untuk menembak
    void openFire(int rateFire) {
        if (remagazine <= 0) {
            System.out.println("Ammo empty..!! Need reload...!!");
        } else {
            System.out.println("On fire....!!!");
            remagazine -= rateFire;
            if (remagazine <= 0) {
                System.out.println("Remains Ammo : 0");
            } else {
                System.out.println("Remains Ammo : " + remagazine);
            }
        }
    }

    // method untuk reload
    void reloadWeap() {
        System.out.println("Reloading weapon...!! \nRemains ammo : " + magazine);
        remagazine = magazine;
        System.out.println("Weapon reloaded...!!");
    }

}

public class weapon_1052 {
    public static void main(String[] args) {
        weapon weapon1 = new weapon();
        weapon1.weaponCategory("Scar-L", "AR", "Assault Riffle", "Long range", 25);
        System.out.println("================");
        weapon1.openFire(10);
        weapon1.openFire(10);
        weapon1.openFire(10);
        weapon1.openFire(10);
        weapon1.reloadWeap();
        weapon1.openFire(10);

    }
}
