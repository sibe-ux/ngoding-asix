package com.javaoop.tugas.smt_3.project_akhir.main_project.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.javaoop.tugas.smt_3.project_akhir.main_project.service.HomeApp;
import com.javaoop.tugas.smt_3.project_akhir.main_project.service.LoginApp;
import com.javaoop.tugas.smt_3.project_akhir.main_project.service.RegisterApp;
import com.javaoop.tugas.smt_3.project_akhir.main_project.util.ConfirmUtil;
import com.javaoop.tugas.smt_3.project_akhir.main_project.view.ApplicationView;
import com.javaoop.tugas.smt_3.project_akhir.main_project.view.GuruHomeView;
import com.javaoop.tugas.smt_3.project_akhir.main_project.view.SiswaHomeView;

// ABSTRACT CLASS
public abstract class DataRepository {
    // ACCESS MODIFIER PRIVATE (ENCAPSULATION)
    private static Connection db;
    public DataRepository(){
        String jdbcURL = "jdbc:postgresql://localhost:5432/School";
        String username = "postgres";
        String password = "sibeHBQ342169";
        try{
            Connection connection = DriverManager.getConnection(jdbcURL, username, password);
            DataRepository.db = DriverManager.getConnection(jdbcURL, username, password);
            connection.close();
        } catch(SQLException e){
            System.out.println("error connect database");
            // e.printStackTrace();
        }
    }

    public static void deleteAktor(String aktor){
        // TRY CATCH EXCEPTION
        try{
            Class.forName("org.postgresql.Driver");

            Connection con = DriverManager.getConnection
            ("jdbc:postgresql://localhost:5432/School", "postgres", "sibeHBQ342169");
            var sql = "";
            if(aktor.equals("guru")){
                var x = ApplicationView.countTableGuru()+2100;
                sql = "DELETE FROM "+aktor+" WHERE nip='"+x+"'";
            } else{
                var x = ApplicationView.countTableSiswa()+1000;
                sql = "DELETE FROM "+aktor+" WHERE nis='"+x+"'";
            }
            java.sql.Statement statement = con.createStatement();
            statement.executeUpdate(sql);

            con.close();
        } catch (Exception ioe){
            Logger.getLogger(DataRepository.class.getName()).log(Level.SEVERE, null, ioe);
        }
    }

    // OVERLOADING
    public static void deleteAktor(String username, String aktor){
        try{
            Class.forName("org.postgresql.Driver");

            Connection con = DriverManager.getConnection
            ("jdbc:postgresql://localhost:5432/School", "postgres", "sibeHBQ342169");
            String sql = "DELETE FROM "+aktor+" WHERE username='"+username+"'";
            java.sql.Statement statement = con.createStatement();
            statement.executeUpdate(sql);

            con.close();
        } catch (Exception ioe){
            Logger.getLogger(DataRepository.class.getName()).log(Level.SEVERE, null, ioe);
        }
    }

    // FITUR LOGIN MENAMBAHKAN USERNAME DAN PASSWORD KE DATABASE
    public static void addRowsLogin(String username, String password,String aktor) throws ClassNotFoundException {
        try{
            Class.forName("org.postgresql.Driver");

            Connection con = 
            DriverManager.getConnection("jdbc:postgresql://localhost:5432/School", "postgres", "sibeHBQ342169");
            var exit = false;
            while (exit == false){
                System.out.print("Yakin untuk mendaftar sebagai "+aktor+" ? (Y/t) ");
                new ConfirmUtil();
                if (ConfirmUtil.getInput().toLowerCase().equals("y")){
                    String sql = "INSERT INTO login (username,password,status)" + "VALUES (?,?,?)";
                    java.sql.PreparedStatement statement = con.prepareStatement(sql);

                    statement.setString(1, username);
                    statement.setString(2, password);
                    statement.setString(3, aktor.toUpperCase());
            
                    int rows = statement.executeUpdate();
                    if (rows > 0) {
                        System.out.println("\nRegister berhasil!\n");
                    }
                    exit = true;
                    con.close();
                    statement.close();
                    System.out.print("Tekan enter untuk ke login page!");
                    // INSTANSIASI OBJECT
                    new ConfirmUtil();
                    switch (aktor){
                        case "guru":
                        HomeApp.menuGuru();
                        break;

                        case "siswa":
                        HomeApp.menuSiswa();
                        break;
                        }
                    break;
                } else if (ConfirmUtil.getInput().toLowerCase().equals("t")){
                    System.out.print("\nRegister dibatalkan! Tekan enter untuk kembali");
                    deleteAktor(username, aktor);
                    new ConfirmUtil();
                    exit = true;
                    if (aktor.toLowerCase().equals("guru")){
                        HomeApp.menuGuru();
                    } else{
                        HomeApp.menuSiswa();
                    }
                    break;
                } else{
                    System.out.println("Perintah tidak ditemukan! Harap ulangi");
                    continue;
                }
            }
        } catch(SQLException e){
            System.out.print("Username telah digunakan sebelumnya!\nMohon isi kembali! Klik enter untuk ulangi");
            deleteAktor(aktor);
            // AGREGASI
            new ConfirmUtil();
            new RegisterApp(aktor, new GuruRepoImpl(), new SiswaRepoImpl());
        }
    }

    // FITUR LOGIN = MEMBACA USERNAME & PASSWORD DARI DATABASE
    public void readLogin(String username, String password,String aktor){
        boolean flag = false;
        try{
            String sql = null;
            switch (aktor.toUpperCase()){
                case "GURU":
                sql = "SELECT username, password FROM login WHERE status='GURU'";
                break;

                case "SISWA":
                sql = "SELECT username, password FROM login WHERE status='SISWA'";
                break;
            }
            
            java.sql.Statement statement = db.createStatement();
            ResultSet results = statement.executeQuery(sql);

            while (results.next()){
                String aktorUser = results.getString("username");
                String aktorPass = results.getString("password");

                if ((username.equals(aktorUser)) && (password.equals(aktorPass))){
                    flag = true;
                    System.out.println("Login Berhasil!");
                }
            } 
            if (flag == false){
                System.out.println("Username/Password tidak ditemukan!\n");
                System.out.print("Mohon Periksa Kembali! Tekan enter untuk ulangi");
                // AGREGASI
                new ConfirmUtil();
                new LoginApp(aktor.toLowerCase());
            } else{
                System.out.print("\nTekan enter untuk ke halaman utama!");
                new ConfirmUtil();
                if (aktor.equalsIgnoreCase("guru")){
                    GuruHomeView.guruHome(GuruRepoImpl.getNamaGuru(username),username);
                } else{
                    new SiswaHomeView(SiswaRepoImpl.getNamaSiswa(username),username); // ngambil nama dari siswa yang login
                }
            }
        } catch(SQLException e){
            System.out.println("error database");
            // e.printStackTrace();
        }
    }
}
