package com.javaoop.tugas.smt_3.project_akhir.main_project.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.javaoop.tugas.smt_3.project_akhir.main_project.util.ConfirmUtil;
import com.javaoop.tugas.smt_3.project_akhir.main_project.view.ApplicationView;
import com.javaoop.tugas.smt_3.project_akhir.main_project.view.SiswaHomeView;

public class TugasRepository extends DataRepository {

    public static void setTugasToDatabase(String namaTugas, int urutan, String idMapel, String category){
        try{
            Class.forName("org.postgresql.Driver");

            Connection con = 
            DriverManager.getConnection("jdbc:postgresql://localhost:5432/School", "postgres", "sibeHBQ342169");
            java.sql.PreparedStatement statement = con.prepareStatement("insert into tugas values (?,?,?,?,?)");

            var baris = ApplicationView.countTableTugas()+1;

            statement.setString(1, String.valueOf("T-"+baris));
            statement.setString(2, namaTugas);
            statement.setInt(3, urutan);
            statement.setString(4, idMapel);
            statement.setString(5, category);

            statement.executeUpdate();
            
            statement.close();
            con.close();
            for (var x : SiswaRepoImpl.getArrayNisByCategory(category)){
                addStatusTugasDatabase(String.valueOf("T-"+baris), x);
            }
        } catch (Exception e) {
            Logger.getLogger(KelasRepoImpl.class.getName()).log(Level.SEVERE,null,e);
            System.out.println("Data tidak boleh sama");
        }
    }

    public static void addStatusTugasDatabase(String idStatus,String idTugas, 
    String nis, String nama, String username){
        try{
            Class.forName("org.postgresql.Driver");

            Connection con = 
            DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/School", "postgres", "sibeHBQ342169");
            java.sql.PreparedStatement statement = con.prepareStatement(
                "UPDATE status_tugas SET id_status='"+idStatus+
                "', id_tugas='"+idTugas+
                "', nis='"+nis+"', is_kerjakan ='true'"+
                " WHERE id_status='"+idStatus+"'");

            // statement.setString(1, idStatus);
            // statement.setString(2, idTugas);
            // statement.setString(3, nis);
            // statement.setString(4, "true");
            
            statement.executeUpdate();

            statement.close();
            con.close();
            System.out.println("\n===============================================");
            System.out.println("Selamat! Anda telah berhasil mengerjakan tugas!");
            System.out.println("===============================================");
            System.out.print("\nKlik enter untuk ke halaman utama! ");
            new ConfirmUtil();
            new SiswaHomeView(nama, username);
        } catch (Exception e) {
            Logger.getLogger(KelasRepoImpl.class.getName()).log(Level.SEVERE,null,e);
            System.out.println("Data tidak boleh sama");
        }
    }

    // OVERLOADING
    public static void addStatusTugasDatabase(String idTugas, String nis){
        try{
            Class.forName("org.postgresql.Driver");

            Connection con = 
            DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/School", "postgres", "sibeHBQ342169");
            java.sql.PreparedStatement statement = 
            con.prepareStatement("insert into status_tugas values (?,?,?,?)");

            var x = ApplicationView.countTableStatusTugas()+1;

            statement.setString(1, "ST-"+x);
            statement.setString(2, idTugas);
            statement.setString(3, nis);
            statement.setString(4, "false");
            
            statement.executeUpdate();

            statement.close();
            con.close();
        } catch (Exception e) {
            Logger.getLogger(KelasRepoImpl.class.getName()).log(Level.SEVERE,null,e);
            System.out.println("Data tidak boleh sama");
        }
    }

}
