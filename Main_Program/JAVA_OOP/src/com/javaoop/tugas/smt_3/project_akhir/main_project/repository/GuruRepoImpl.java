package com.javaoop.tugas.smt_3.project_akhir.main_project.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.javaoop.tugas.smt_3.project_akhir.main_project.view.ApplicationView;

public class GuruRepoImpl extends DataRepository implements DatatInteRepo {
    
    // MENAMBAHKAN DATA GURU KE DATABASE
    @Override // OVERRIDING
    public void setDataToDatabase(String nama, String username,String password,String aktor, String mapel){
        try{
            Class.forName("org.postgresql.Driver");

            Connection con = 
            DriverManager.getConnection("jdbc:postgresql://localhost:5432/School", "postgres", "sibeHBQ342169");
            java.sql.PreparedStatement statement = con.prepareStatement("insert into guru values (?,?,?,?)");

            var baris = ApplicationView.countTableGuru();

            statement.setString(1, String.valueOf(2100+baris+1));
            statement.setString(2, mapel);
            statement.setString(3, nama);
            statement.setString(4, username);

            statement.executeUpdate();
            
            statement.close();
            con.close();
            addRowsLogin(username, password,aktor);
        } catch (Exception e) {
            Logger.getLogger(KelasRepoImpl.class.getName()).log(Level.SEVERE,null,e);
            System.out.println("Data tidak boleh sama");
        }
    }

    // MENGAMBIL NAMA GURU DARI DATABASE
    public static String getNamaGuru(String username){
        String namaSiswa = null;
        try{
            Class.forName("org.postgresql.Driver");

            Connection con = DriverManager.getConnection
            ("jdbc:postgresql://localhost:5432/School", "postgres", "sibeHBQ342169");

            Statement statement = con.createStatement();
            ResultSet res = statement.executeQuery("SELECT * FROM guru WHERE username='"+username+"'");
            var nama = "";
            while (res.next()){
                    nama = res.getString("nama");
            }

            namaSiswa = nama;
            statement.close();
            con.close();
        } catch (Exception ioe){
            Logger.getLogger(ApplicationView.class.getName()).log(Level.SEVERE, null, ioe);
        }
        return namaSiswa;
    }

    @Override
    public void setDataToDatabase(int tingkat, String jurusan) {
        // TODO Auto-generated method stub
        
    }
    
}

