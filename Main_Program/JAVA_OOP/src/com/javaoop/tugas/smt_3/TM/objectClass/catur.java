package com.javaoop.tugas.smt_3.TM.objectClass;

class pion{
    String warna;
    int langkah = 1;

    void display(){
        System.out.println(this.warna);
    }

    String getWarna(){
        return this.warna;
    }

    void setWarna(String warna){
        this.warna = warna;
    }

    void moveForward(int langkah){
        if (langkah == 2){
            if(langkah ==2){
                System.out.println("you can only move forward 2 steps once");
            } else{
                System.out.println("move forward 2 steps");
                this.langkah = 0;
            }
        } else if(langkah ==1){
            System.out.println("move forward 1 steps");
            this.langkah = 0;
        } else{
            System.out.println("only can move 1 steps");
        }
    }
}


public class catur {
    public static void main(String[] args) {
        pion pion = new pion();
        pion.setWarna("putih");
        System.out.println(pion.getWarna());
        pion.display();
        pion.moveForward(1);
        pion.moveForward(2);
    }
}
