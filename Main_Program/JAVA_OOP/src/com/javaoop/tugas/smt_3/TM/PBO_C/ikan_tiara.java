package com.javaoop.tugas.smt_3.TM.PBO_C;
import java.io.*;
class iwak_tiara{
    String jenis;
    String warna;
    String kelamin;
    String habitat;

    iwak_tiara(String jenis, String warna, String kelamin, String habitat){
        this.jenis = jenis;
        this.warna = warna;
        this.kelamin = kelamin;
        this.habitat = habitat;
    }

    String getJenis(){
        return this.jenis;
    }

    String getwarna(){
        return this.warna;
    }

    String getKelamin(){
        return this.kelamin;
    }

    String getHabitat(){
        return this.habitat;
    }

    void berenang(String move){
        if ((move.equals("w")) || (move.equals("W"))){
            System.out.println("move forward");
        } else if ((move.equals("A"))||(move.equals("a"))){
            System.out.println("move left");
        } else if ((move.equals("d"))||(move.equals("D"))){
            System.out.println("move right");
        } else if ((move.equals("s"))||(move.equals("S"))){
            System.out.println("move backward");
        } else {
            System.out.println("command not found");
        }
    }
}

public class ikan_tiara{
    public static void main(String[] args) {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        try {
            iwak_tiara lele = new iwak_tiara("lele","hitam","betina","air tawar");
            System.out.println("jenis : " + lele.getJenis());
            System.out.println("warna : "+lele.getwarna());
            System.out.println("kelamin : "+lele.getKelamin());
            System.out.println("habitat : "+lele.getHabitat());
            System.out.print("move : ");
            String kelamin = input.readLine();
            String s = ""+kelamin;
            lele.berenang(s);
            lele.berenang("w");
            lele.berenang("A");
            lele.berenang("s");
        } catch (IOException exception) {
            System.out.println("Error input!");
        }
    }
}