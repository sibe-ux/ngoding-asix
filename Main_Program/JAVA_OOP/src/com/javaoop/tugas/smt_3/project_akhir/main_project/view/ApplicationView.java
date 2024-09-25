package com.javaoop.tugas.smt_3.project_akhir.main_project.view;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.javaoop.tugas.smt_3.project_akhir.main_project.repository.SiswaRepoImpl;
import com.javaoop.tugas.smt_3.project_akhir.main_project.view.Pretty_Table.PrettyTable;

public class ApplicationView {

    public static int countRowsColumns(String a,int b){
        int result = 0;
        try {
            Class.forName("org.postgresql.Driver");

            Connection con = DriverManager.getConnection
            ("jdbc:postgresql://localhost:5432/School", "postgres", "sibeHBQ342169");

            Statement statement = con.createStatement();
            ResultSet res = statement.executeQuery(
                "SELECT COUNT(jurusan) as jumlah_baris FROM kelas_object WHERE jurusan ilike'%"+
            a+"%' and tingkat='"+b+"'");

            while (res.next()){
                result = (res.getInt("jumlah_baris"));
            }
            statement.close();
            con.close();
        } catch (Exception e) {
            // TODO: handle exception
        }
        return result;
    }

    public static int countTableTugas(){
        int result = 0;
        try{
            Class.forName("org.postgresql.Driver");

            Connection con = DriverManager.getConnection
            ("jdbc:postgresql://localhost:5432/School", "postgres", "sibeHBQ342169");

            Statement statement = con.createStatement();
            ResultSet res = statement.executeQuery(
                "SELECT COUNT(*) as jumlah_baris FROM tugas");

            while (res.next()){
                result = (res.getInt("jumlah_baris"));
            }
            statement.close();
            con.close();
        } catch (Exception ioe){
            Logger.getLogger(ApplicationView.class.getName()).log(Level.SEVERE, null, ioe);
        }
        return result;
    }

    public static int countTableStatusTugas(){
        int result = 0;
        try{
            Class.forName("org.postgresql.Driver");

            Connection con = DriverManager.getConnection
            ("jdbc:postgresql://localhost:5432/School", "postgres", "sibeHBQ342169");

            Statement statement = con.createStatement();
            ResultSet res = statement.executeQuery(
                "SELECT COUNT(*) as jumlah_baris FROM status_tugas");

            while (res.next()){
                result = (res.getInt("jumlah_baris"));
            }
            statement.close();
            con.close();
        } catch (Exception ioe){
            Logger.getLogger(ApplicationView.class.getName()).log(Level.SEVERE, null, ioe);
        }
        return result;
    }

    public static int countTableKelas(){
        int result = 0;
        try{
            Class.forName("org.postgresql.Driver");

            Connection con = DriverManager.getConnection
            ("jdbc:postgresql://localhost:5432/School", "postgres", "sibeHBQ342169");

            Statement statement = con.createStatement();
            ResultSet res = statement.executeQuery(
                "SELECT COUNT(*) as jumlah_baris FROM kelas_object");

            while (res.next()){
                result = (res.getInt("jumlah_baris"));
            }
            statement.close();
            con.close();
        } catch (Exception ioe){
            Logger.getLogger(ApplicationView.class.getName()).log(Level.SEVERE, null, ioe);
        }
        return result;
    }

    public static int countTableMapel(){
        int result = 0;
        try{
            Class.forName("org.postgresql.Driver");

            Connection con = DriverManager.getConnection
            ("jdbc:postgresql://localhost:5432/School", "postgres", "sibeHBQ342169");

            Statement statement = con.createStatement();
            ResultSet res = statement.executeQuery(
                "SELECT COUNT(*) as jumlah_baris FROM mapel");

            while (res.next()){
                result = (res.getInt("jumlah_baris"));
            }
            statement.close();
            con.close();
        } catch (Exception ioe){
            Logger.getLogger(ApplicationView.class.getName()).log(Level.SEVERE, null, ioe);
        }
        return result;
    }

    public static int countTableGuru(){
        int result = 0;
        try{
            Class.forName("org.postgresql.Driver");

            Connection con = DriverManager.getConnection
            ("jdbc:postgresql://localhost:5432/School", "postgres", "sibeHBQ342169");

            Statement statement = con.createStatement();
            ResultSet res = statement.executeQuery(
                "SELECT COUNT(*) as jumlah_baris FROM guru");

            while (res.next()){
                result = (res.getInt("jumlah_baris"));
            }
            statement.close();
            con.close();
        } catch (Exception ioe){
            Logger.getLogger(ApplicationView.class.getName()).log(Level.SEVERE, null, ioe);
        }
        return result;
    }

    public static int countTableSiswa(){
        int result = 0;
        try{
            Class.forName("org.postgresql.Driver");

            Connection con = DriverManager.getConnection
            ("jdbc:postgresql://localhost:5432/School", "postgres", "sibeHBQ342169");

            Statement statement = con.createStatement();
            ResultSet res = statement.executeQuery(
                "SELECT COUNT(*) as jumlah_baris FROM siswa");

            while (res.next()){
                result = (res.getInt("jumlah_baris"));
            }
            statement.close();
            con.close();
        } catch (Exception ioe){
            Logger.getLogger(ApplicationView.class.getName()).log(Level.SEVERE, null, ioe);
        }
        return result;
    }

    public static String[] getArrayMapel() {
        String[] arrayMapel = null;
        try{
            Class.forName("org.postgresql.Driver");
            String array[] = new String[countTableMapel()];

            Connection con = DriverManager.getConnection
            ("jdbc:postgresql://localhost:5432/School", "postgres", "sibeHBQ342169");

            Statement statement = con.createStatement();
            ResultSet res = statement.executeQuery(
                "SELECT * FROM mapel ORDER BY id_mapel ASC");
            var x = 1;
            while (res.next()){
                    array[x-1] = res.getString("id_mapel");
                    x++;
            }
            arrayMapel = array;
            statement.close();
            con.close();
        } catch (Exception ioe){
            Logger.getLogger(ApplicationView.class.getName()).log(Level.SEVERE, null, ioe);
        }
        return arrayMapel;
    }

    public static String[] getArrayKelas() {
        String[] arrayKelas = null;
        try{
            Class.forName("org.postgresql.Driver");
            String array[] = new String[countTableKelas()];

            Connection con = DriverManager.getConnection
            ("jdbc:postgresql://localhost:5432/School", "postgres", "sibeHBQ342169");

            Statement statement = con.createStatement();
            ResultSet res = statement.executeQuery(
                "SELECT * FROM kelas_object ORDER BY category ASC");
            var x = 1;
            while (res.next()){
                    array[x-1] = res.getString("category");
                    x++;
            }
            arrayKelas = array;
            statement.close();
            con.close();
        } catch (Exception ioe){
            Logger.getLogger(ApplicationView.class.getName()).log(Level.SEVERE, null, ioe);
        }
        return arrayKelas;
    }
    

    public static void KelasTable(){
        try{
            Class.forName("org.postgresql.Driver");
            String[] arrayKelas = new String[countTableKelas()];

            Connection con = DriverManager.getConnection
            ("jdbc:postgresql://localhost:5432/School", "postgres", "sibeHBQ342169");

            Statement statement = con.createStatement();
            ResultSet res = statement.executeQuery("SELECT * FROM kelas_object ORDER BY category ASC");
            PrettyTable prettyTable = new PrettyTable("No","Tingkat","Jurusan","Kategori","Jumlah Siswa");
            var x = 1;
            while (res.next()){
                    prettyTable.addRow(String.valueOf(x),String.valueOf(res.getInt("tingkat")),
                    res.getString("jurusan"),
                    res.getString("category"),
                    String.valueOf(SiswaRepoImpl.getSiswaByKelas(res.getString("category"))));
                    arrayKelas[x-1] = res.getString("category");
                    x++;
            }

            System.out.println(prettyTable);
            statement.close();
            con.close();
        } catch (Exception ioe){
            Logger.getLogger(ApplicationView.class.getName()).log(Level.SEVERE, null, ioe);
        }
    }

    public static void mapelTable(){
        try{
            Class.forName("org.postgresql.Driver");
            String[] arrayMapel = new String[countTableMapel()];

            Connection con = DriverManager.getConnection
            ("jdbc:postgresql://localhost:5432/School", "postgres", "sibeHBQ342169");

            Statement statement = con.createStatement();
            ResultSet res = statement.executeQuery("SELECT * FROM mapel ORDER BY id_mapel ASC");
            PrettyTable prettyTable = new PrettyTable("No","Nama Mapel","Beban Jam");
            var x = 1;
            while (res.next()){
                    prettyTable.addRow(String.valueOf(x),String.valueOf(res.getString("nama")),
                    String.valueOf(res.getInt("beban")) );
                    arrayMapel[x-1] = res.getString("id_mapel");
                    x++;
            }
            System.out.println(prettyTable);
            statement.close();
            con.close();
        } catch (Exception ioe){
            Logger.getLogger(ApplicationView.class.getName()).log(Level.SEVERE, null, ioe);
        }
    }

    public static int countUrutanTugas(String id,String category){
        int result=0;
        try{
            Class.forName("org.postgresql.Driver");

            Connection con = DriverManager.getConnection
            ("jdbc:postgresql://localhost:5432/School", "postgres", "sibeHBQ342169");

            Statement statement = con.createStatement();
            ResultSet res = statement.executeQuery(
                "SELECT COUNT(*) as jumlah_baris FROM tugas WHERE id_mapel='"
                +id+"' and category='"+category+"'");

            while (res.next()){
                result = (res.getInt("jumlah_baris"));
            }
            statement.close();
            con.close();
        } catch (Exception ioe){
            Logger.getLogger(ApplicationView.class.getName()).log(Level.SEVERE, null, ioe);
        }
        return result;
    }

    public static int countSiswaByCategory(String category){
        int result=0;
        try{
            Class.forName("org.postgresql.Driver");

            Connection con = DriverManager.getConnection
            ("jdbc:postgresql://localhost:5432/School", "postgres", "sibeHBQ342169");

            Statement statement = con.createStatement();
            ResultSet res = statement.executeQuery(
                "SELECT COUNT(*) as jumlah_baris FROM siswa WHERE category='"
                +category+"'");

            while (res.next()){
                result = (res.getInt("jumlah_baris"));
            }
            statement.close();
            con.close();
        } catch (Exception ioe){
            Logger.getLogger(ApplicationView.class.getName()).log(Level.SEVERE, null, ioe);
        }
        return result;
    }
}
