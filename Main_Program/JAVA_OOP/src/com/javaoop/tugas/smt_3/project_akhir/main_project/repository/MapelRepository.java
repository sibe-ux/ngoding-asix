package com.javaoop.tugas.smt_3.project_akhir.main_project.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MapelRepository extends DataRepository {
    public static String getNamaMapelByIdMapel(String id){
        String result = "";
        try{
            Class.forName("org.postgresql.Driver");

            Connection con = DriverManager.getConnection
            ("jdbc:postgresql://localhost:5432/School", "postgres", "sibeHBQ342169");

            Statement statement = con.createStatement();
            ResultSet res = statement.executeQuery("SELECT * FROM mapel WHERE id_mapel = '"+id+"'");

            while (res.next()){
                result = res.getString("nama");
            }
            statement.close();
            con.close();
        } catch (Exception ioe){
            Logger.getLogger(KelasRepoImpl.class.getName()).log(Level.SEVERE, null, ioe);
        }
        return result;
    }
}
