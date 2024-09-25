package com.javaoop.java_dasar.Serializable;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        // pertama bikin objek seperti biasa
        Fruit apel = new Fruit("apel", 500);
        try (
            // kedua, write di sebuah file pake ObjectOutputStream
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("/home/nasrulwahabi/Documents/PEMROGRAMAN-20211116T015536Z-001/PEMROGRAMAN/My Program/fruit.txt"))) {
            out.writeObject(apel); // berfungsi untuk menyimpan object ke dalam file
            try (
                // ketiga, mengambil object dari file
                ObjectInputStream in = new ObjectInputStream(new FileInputStream("/home/nasrulwahabi/Documents/PEMROGRAMAN-20211116T015536Z-001/PEMROGRAMAN/My Program/fruit.txt"))) {
                Fruit jeruk = (Fruit) in.readObject();
                System.out.println(jeruk.getPrice());
            
        }
            
        }
    }
}
