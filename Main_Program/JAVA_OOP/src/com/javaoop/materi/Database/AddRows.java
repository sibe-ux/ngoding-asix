package com.javaoop.materi.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddRows {
    public static void main(String[] args) {
        String jdbcURL = "jdbc:postgresql://localhost:5432/School";
        String username = "postgres";
        String password = "sibeHBQ342169";

        try{
            Connection connection = DriverManager.getConnection(jdbcURL, username, password);
            System.out.println("connected!");
            // String sql = "INSERT INTO siswa (nama, kelas, jurusan)"
            //             + "VALUES ('Sibe','XA1','IPA')";
            String sql = "INSERT INTO siswa (nama, kelas, jurusan)" + "VALUES (?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, "nasrul");
            statement.setString(2, "XIIS2");
            statement.setString(3, "IPS");

            int rows = statement.executeUpdate();
            if (rows > 0) {
                System.out.println("Data Siswa Berhasil Ditambahkan");
            }
            connection.close();
        } catch(SQLException e){
            System.out.println("error connect database");
            e.printStackTrace();
        }
    }
}
