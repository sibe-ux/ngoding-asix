package com.javaoop.tugas.smt_3.project_akhir.main_project.view;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.javaoop.tugas.smt_3.project_akhir.main_project.repository.SiswaRepoImpl;
import com.javaoop.tugas.smt_3.project_akhir.main_project.service.HomeApp;
import com.javaoop.tugas.smt_3.project_akhir.main_project.service.SiswaApp;
import com.javaoop.tugas.smt_3.project_akhir.main_project.util.ClearScreenUtil;
import com.javaoop.tugas.smt_3.project_akhir.main_project.util.ConfirmUtil;
import com.javaoop.tugas.smt_3.project_akhir.main_project.util.ValidationUtil;
import com.javaoop.tugas.smt_3.project_akhir.main_project.view.Pretty_Table.PrettyTable;

// INHERITANCE
public class SiswaHomeView extends ApplicationView{
    // CONSTRUCTOR
    public SiswaHomeView(String nama,String username){
        ClearScreenUtil.ClearConsole();
        System.out.println("------------------------------");
        System.out.println("        * Halo! "+nama+" *");
        System.out.println("------------------------------\n");
        System.out.println("[1] Biodata");
        System.out.println("[2] Daftar Tugas"); 
        System.out.println("[3] Kerjakan Tugas");
        System.out.println("[4] Lihat Nilai\n");
        System.out.println("[0] Back to Login");
        System.out.println("\n------------------------------");
        var exit = false;
        while (exit == false){
            var menu = ValidationUtil.inputString("\nPilih Menu :: ");
            switch (menu){
                case "1":
                exit = true;
                siswaBiodata(username);
                break;

                case "2":
                exit = true;
                daftarTugas(nama, username);
                break;

                case "3":
                exit = true;
                SiswaApp siswaApp = new SiswaApp(nama,username,
                SiswaRepoImpl.getNisByUsername(username));
                siswaApp.kerjakanTugas(nama,username);
                break;

                case "4":
                exit = true;
                ClearScreenUtil.ClearConsole();
                // NESTED CLASS
                SiswaRepoImpl.NilaiSiswa.viewNilai(nama,username);
                break;

                case "0":
                exit = true;
                HomeApp.menuSiswa();
                break;

                default:
                System.out.println("Perintah tidak ditemukan!");
                System.out.print("\nTekan enter untuk kembali!");
                new ConfirmUtil();
                new SiswaHomeView(nama, username);
            }
        }
    }

    public static void daftarTugas(String name, String username){
        try{
            Class.forName("org.postgresql.Driver");

            Connection con = DriverManager.getConnection
            ("jdbc:postgresql://localhost:5432/School", "postgres", "sibeHBQ342169");
            Statement statement = con.createStatement();
            ResultSet res = statement.executeQuery(
            "SELECT m.nama,t.nama_tugas,t.urutan "+
            "FROM mapel m "+
            "JOIN tugas t ON m.id_mapel = t.id_mapel "+
            "JOIN status_tugas st ON t.id_tugas = st.id_tugas "+
            "where st.nis = '"+SiswaRepoImpl.getNisByUsername(username)
            +"' and st.is_kerjakan = 'false'");
            PrettyTable prettyTable = new PrettyTable("No","Mata Pelajaran","Tugas","Jenis");
            var index = 1;
            while (res.next()){
                prettyTable.addRow(String.valueOf(index),res.getString("nama"),
                res.getString("nama_tugas"),String.valueOf("Tugas Ke-"+res.getInt("urutan"))) ;
                index++;
            }
            ClearScreenUtil.ClearConsole();
            System.out.println("------------------------------");
            System.out.println("       * DAFTAR TUGAS *");
            System.out.println("------------------------------\n");
            if(index-1 == 0){
                prettyTable.addRow("--","--","--","--");
                System.out.println(prettyTable);
                System.out.print("\nBelum ada tugas tersedia! Klik enter untuk kembali! ");
                new ConfirmUtil();
                new SiswaHomeView(name, username);
            } else{
                System.out.println(prettyTable);
                System.out.print("\nKlik enter untuk kembali! ");
                new ConfirmUtil();
                new SiswaHomeView(name, username);
            }
            statement.close();
            con.close();

        } catch (Exception ioe){
            Logger.getLogger(ApplicationView.class.getName()).log(Level.SEVERE, null, ioe);
        }
    }

    public static String[] tingkatJurusan(String category){
        String[] result = null;
        try {
            Class.forName("org.postgresql.Driver");

            Connection con = DriverManager.getConnection
            ("jdbc:postgresql://localhost:5432/School", "postgres", "sibeHBQ342169");

            Statement statement = con.createStatement();
            ResultSet getKelas = statement.executeQuery("SELECT * FROM kelas_object WHERE category='"
            +category+"'");
            String dump[] = new String[2];
                while (getKelas.next()){
                    dump[0] = String.valueOf(getKelas.getInt("tingkat")) ;
                    dump[1] = getKelas.getString("jurusan");
                }
            result = dump;
            statement.close();
            con.close();
        } catch (Exception e) {
            //TODO: handle exception
            Logger.getLogger(ApplicationView.class.getName()).log(Level.SEVERE, null, e);
        }
        return result;
        
    }

    public static void siswaBiodata(String username){
        try{
            Class.forName("org.postgresql.Driver");

            Connection con = DriverManager.getConnection
            ("jdbc:postgresql://localhost:5432/School", "postgres", "sibeHBQ342169");
            Statement statement = con.createStatement();
            ResultSet res = statement.executeQuery("SELECT * FROM siswa WHERE username='"+username+"'");
            PrettyTable prettyTable = new PrettyTable("NIS","Nama","Tingkat","Jurusan","Kelas");
            var siswaCategory = "";
            var nama = "";
            while (res.next()){
                siswaCategory = res.getString("category");
                nama = res.getString("nama");
                var tingjur = tingkatJurusan(siswaCategory);
                prettyTable.addRow(String.valueOf(res.getInt("nis")),res.getString("nama"),
                String.valueOf(Integer.parseInt(tingjur[0])+9), tingjur[1],
                res.getString("category")); 
            }
            ClearScreenUtil.ClearConsole();
            System.out.println("------------------------------");
            System.out.println("          ===========");
            System.out.println("          * BIODATA *");
            System.out.println("          ===========");
            System.out.println("------------------------------\n");
            System.out.println(prettyTable);
            System.out.println("\n-------------------------");
            System.out.print("\nKlik enter untuk kembali! ");
            new ConfirmUtil();
            new SiswaHomeView(nama, username);
            statement.close();
            con.close();

        } catch (Exception ioe){
            Logger.getLogger(ApplicationView.class.getName()).log(Level.SEVERE, null, ioe);
        }
    }

    public static void dataTugas(){
        
    }
}
