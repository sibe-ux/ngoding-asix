package com.javaoop.tugas.smt_3.project_akhir.main_project.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.javaoop.tugas.smt_3.project_akhir.main_project.repository.SiswaRepoImpl;
import com.javaoop.tugas.smt_3.project_akhir.main_project.repository.TugasRepository;
import com.javaoop.tugas.smt_3.project_akhir.main_project.util.ClearScreenUtil;
import com.javaoop.tugas.smt_3.project_akhir.main_project.util.ConfirmUtil;
import com.javaoop.tugas.smt_3.project_akhir.main_project.util.ValidationUtil;
import com.javaoop.tugas.smt_3.project_akhir.main_project.view.ApplicationView;
import com.javaoop.tugas.smt_3.project_akhir.main_project.view.SiswaHomeView;
import com.javaoop.tugas.smt_3.project_akhir.main_project.view.Pretty_Table.PrettyTable;
public class SiswaApp {
    private String namaSiswa;
    private String username;
    private String nis;

    public SiswaApp (String namaSiswa, String username, String nis){
        this.namaSiswa = namaSiswa;
        this.username = username;
        this.nis = nis;
    }

    public String getNis() {
        return nis;
    }

    public String getNamaSiswa() {
        return namaSiswa;
    }

    public String getUsername() {
        return username;
    }

    public void kerjakanTugas(String name,String username) {
        try{
            Class.forName("org.postgresql.Driver");

            Connection con = DriverManager.getConnection
            ("jdbc:postgresql://localhost:5432/School", "postgres", "sibeHBQ342169");
            Statement statement = con.createStatement();
            ResultSet res = statement.executeQuery(
                "SELECT m.nama,t.nama_tugas,t.urutan,st.id_status,st.id_tugas "+
                "FROM mapel m "+
                "JOIN tugas t ON m.id_mapel = t.id_mapel "+
                "JOIN status_tugas st ON t.id_tugas = st.id_tugas "+
                "where st.nis = '"+SiswaRepoImpl.getNisByUsername(username)
                +"' and st.is_kerjakan = 'false'"+
            " ORDER BY st.id_tugas ASC");
            PrettyTable prettyTable = new PrettyTable("No","Mata Pelajaran","Tugas","Jenis");
            String[] idStatus = new String[getCountTugas()];
            var idTugas = "";
            var index = 1;
            while (res.next()){
                prettyTable.addRow(String.valueOf(index),res.getString("nama"),
                res.getString("nama_tugas"),String.valueOf("Tugas Ke-"+res.getInt("urutan"))) ;
                idStatus[index-1] = res.getString("id_status");
                idTugas = res.getString("id_tugas");
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
                System.out.println("---------------------------");
                var x = ValidationUtil.inputInteger(
                    "\nPilih tugas untuk dikerjakan  :: ", getCountTugas());
                TugasRepository.addStatusTugasDatabase(idStatus[x-1], idTugas, this.nis,
                this.namaSiswa, this.username);
            }
            statement.close();
            con.close();

        } catch (Exception ioe){
            Logger.getLogger(ApplicationView.class.getName()).log(Level.SEVERE, null, ioe);
        }
    }

    public int getCountTugas(){
        int result = 0;
        try{
            Class.forName("org.postgresql.Driver");

            Connection con = DriverManager.getConnection
            ("jdbc:postgresql://localhost:5432/School", "postgres", "sibeHBQ342169");

            Statement statement = con.createStatement();
            ResultSet res = statement.executeQuery(
                "SELECT COUNT(*) as jumlah_baris FROM status_tugas WHERE nis='"+
                SiswaRepoImpl.getNisByUsername(username)+"'");

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
