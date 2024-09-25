package com.javaoop.tugas.smt_3.TM;
import java.io.*;

public class bmi_Nasrul_202410101052 {
    public static void main(String[] args) {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.print("Berat (Kg) : ");
            double berat = Double.parseDouble( input.readLine() );
            System.out.print("tinggi (Cm) : ");
            double tinggi = Double.parseDouble( input.readLine() );
            double totalTinggi = tinggi*tinggi/10000;
            double bmi = berat / totalTinggi;

            System.out.println("BMI : " + bmi);
            if (bmi < 18.5) {
                System.out.println(bmi + " : underweight");
            }
            else if (bmi <= 24.9) {
                System.out.println(bmi + " : normal weight"); // Jika menggunakan < , maka dimulai dari grade paling kecil
            }                                                 // Jika menggunakan > , maka dimulai dari grade paling besar
            else if (bmi <= 29.9) {
                System.out.println(bmi + " : overweight");
            }
            else if (bmi <= 34.9) {
                System.out.println(bmi + " : obesity class I");
            }
            else if (bmi <= 39.9) {
                System.out.println(bmi + " : obesity class II");
            }
            else if (bmi >= 40.0) {
                System.out.println(bmi + " : obesity class III");
            }
        } catch (IOException exception) {
            System.out.println("Error input!");
        }
    }
}