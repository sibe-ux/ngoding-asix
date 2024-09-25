package com.javaoop.materi.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB{
    public static void main(String[] args) {
        String jdbcURL = "jdbc:postgresql://localhost:5432/School";
        String username = "postgres";
        String password = "sibeHBQ342169";

        try{
            Connection connection = DriverManager.getConnection(jdbcURL, username, password);
            System.out.println("connected!");

            connection.close();
        } catch(SQLException e){
            System.out.println("error connect database");
            e.printStackTrace();
        }
    }

}