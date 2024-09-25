package com.javaoop.materi.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.javaoop.materi.Pretty_Table.PrettyTable;

public class ReadTable {
    public static void main(String[] args) {
        String jdbcURL = "jdbc:postgresql://localhost:5432/School";
        String username = "postgres";
        String password = "sibeHBQ342169";
        PrettyTable table = new PrettyTable("Nis","Nama","Kelas","Jurusan");

        try{
            Connection connection = DriverManager.getConnection(jdbcURL, username, password);
            System.out.println("connected!");

            // String sql = "INSERT INTO siswa (nama, kelas, jurusan)"
            //             + "VALUES ('Sibe','XA1','IPA')";
            
            String sql = "SELECT * FROM siswa";
            java.sql.Statement statement = connection.createStatement();

            ResultSet result = statement.executeQuery(sql);

            while (result.next()){
                int nis =  result.getInt("nis");
                String nama = result.getString("nama");
                String kelas = result.getString("kelas");
                String jurusan = result.getString("jurusan");

                String niss = String.valueOf(nis);
                
                table.addRow(niss,nama, kelas, jurusan);
                // System.out.printf("%d - %s - %s - %s\n",nis,nama,kelas,jurusan);
            }

            System.out.println(table);

            connection.close();

        } catch(SQLException e){
            System.out.println("error connect database");
            e.printStackTrace();
        }
    }
}
