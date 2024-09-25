package com.javaoop.tugas.smt_3.project_akhir.main_project.view;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.javaoop.tugas.smt_3.project_akhir.main_project.repository.SiswaRepoImpl;
import com.javaoop.tugas.smt_3.project_akhir.main_project.repository.TugasRepository;
import com.javaoop.tugas.smt_3.project_akhir.main_project.service.GuruApp;
import com.javaoop.tugas.smt_3.project_akhir.main_project.service.HomeApp;
import com.javaoop.tugas.smt_3.project_akhir.main_project.util.ClearScreenUtil;
import com.javaoop.tugas.smt_3.project_akhir.main_project.util.ConfirmUtil;
import com.javaoop.tugas.smt_3.project_akhir.main_project.util.ValidationUtil;
import com.javaoop.tugas.smt_3.project_akhir.main_project.view.Pretty_Table.PrettyTable;

// INHERITANCE
public class GuruHomeView extends ApplicationView {
    public static void guruHome(String nama, String username) {
        ClearScreenUtil.ClearConsole();
        System.out.println("------------------------------");
        System.out.println("    * Halo! " + nama + "-Sensei *");
        System.out.println("------------------------------\n");
        System.out.println("[1] Biodata"); // read
        System.out.println("[2] Beri Tugas/Ulangan");
        System.out.println("[3] Beri Nilai Siswa");
        System.out.println("[4] Rekap Nilai\n");
        System.out.println("[0] Back to Login");
        System.out.println("\n------------------------------");
        var exit = false;
        while (!exit) {
            var menu = ValidationUtil.inputString("\nPilih Menu :: ");
            switch (menu) {
                case "1":
                    exit = true;
                    guruBiodata(username);
                    break;

                case "2":
                    exit = true;
                    beriTugas(nama, username);
                    break;

                case "3":
                    exit = true;
                    new GuruApp(nama, username).setNilai(nama, username);
                    break;

                case "4":
                    exit = true;
                    SiswaRepoImpl.NilaiSiswa.rankingSiswa("guru", nama, username);
                    break;

                case "0":
                    HomeApp.menuGuru();
                    exit = true;
                    break;

                default:
                    System.out.println("Perintah tidak ditemukan!");
                    System.out.print("\nTekan enter untuk kembali!");
                    new ConfirmUtil();
                    guruHome(nama, username);

            }
        }
    }

    public static String[] namaBeban(String category) {
        String[] result = null;
        try {
            Class.forName("org.postgresql.Driver");

            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/School", "postgres",
                    "sibeHBQ342169");

            Statement statement = con.createStatement();
            ResultSet getKelas = statement.executeQuery("SELECT * FROM mapel WHERE id_mapel='"
                    + category + "'");
            String dump[] = new String[2];
            while (getKelas.next()) {
                dump[0] = getKelas.getString("nama");
                dump[1] = String.valueOf(getKelas.getInt("beban"));
            }
            result = dump;
            statement.close();
            con.close();
        } catch (Exception e) {
            // TODO: handle exception
            Logger.getLogger(ApplicationView.class.getName()).log(Level.SEVERE, null, e);
        }
        return result;

    }

    public static void beriTugas(String nama, String username) {
        ClearScreenUtil.ClearConsole();
        System.out.println("------------------------------");
        System.out.println("       ** TUGAS TIME **");
        System.out.println("------------------------------\n");

        try {
            Class.forName("org.postgresql.Driver");
            String arrayKelas[] = new String[countTableKelas()];
            boolean isKosong = true;

            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/School", "postgres",
                    "sibeHBQ342169");

            Statement statement = con.createStatement();
            ResultSet res = statement.executeQuery("SELECT * FROM kelas_object ORDER BY category ASC");
            PrettyTable prettyTable = new PrettyTable("No", "Tingkat", "Jurusan", "Kategori", "Jumlah Siswa");
            PrettyTable dataNull = new PrettyTable("No", "Tingkat", "Jurusan", "Kategori", "Jumlah Siswa");
            var x = 1;
            var kelas = "";
            while (res.next()) {
                if (SiswaRepoImpl.getSiswaByKelas(res.getString("category")) != 0) {
                    prettyTable.addRow(String.valueOf(x), String.valueOf(res.getInt("tingkat")),
                            res.getString("jurusan"),
                            res.getString("category"), String.valueOf(SiswaRepoImpl.getSiswaByKelas(
                                    res.getString("category"))));
                    arrayKelas[x - 1] = res.getString("category");
                    isKosong = false;
                    kelas = res.getString("category");
                    x++;
                } else {
                    // do nothing
                }
            }
            if (isKosong) {
                dataNull.addRow("--", "--", "--", "--", "--");
                System.out.println(dataNull);
                System.out.print("\nTidak ada kelas tersedia! Tekan enter untuk kembali ");
                new ConfirmUtil();
                guruHome(nama, username);
            } else {
                System.out.println(prettyTable);
                System.out.println();
                var z = ValidationUtil.inputInteger("Input Kelas   : ", x - 1);
                System.out.println("\n=======================");
                var urutan = countUrutanTugas(getIdMapelByGuru(username), arrayKelas[z - 1]) + 1;
                System.out.println("Tugas " + getMapelByGuru(username)
                        + " Ke-" + urutan);
                System.out.println("=======================\n");
                var namaTugas = ValidationUtil.inputString("Nama Tugas   : ");
                System.out.println("--------------------------");
                // if(urutan==1){
                // System.out.println("!!! Menambah tugas baru akan menutup seluruh tugas
                // sebelumnya !!!");
                // System.out.println("--------------------------");
                // }
                var inp = new ValidationUtil();
                var xi = inp.inputYesNo("Yakin untuk memberikan tugas kepada kelas "
                        + arrayKelas[z - 1] + " ? (Y/t) ");
                if (xi.equals("y")) {
                    TugasRepository.setTugasToDatabase(namaTugas, countUrutanTugas(getIdMapelByGuru(username),
                            arrayKelas[z - 1]) + 1, getIdMapelByGuru(username), arrayKelas[z - 1]);
                    System.out.println("--------------------------");
                    ValidationUtil.inputString("Tugas Berhasil Ditambahkan! Klik enter untuk kembali ");
                    ClearScreenUtil.ClearConsole();
                    guruHome(nama, username);
                } else {
                    System.out.println("--------------------------");
                    System.out.print("Pemberian Tugas dibatalkan! Tekan enter untuk kembali! ");
                    new ConfirmUtil();
                    ClearScreenUtil.ClearConsole();
                    guruHome(nama, username);
                }

            }
            statement.close();
            con.close();
        } catch (Exception ioe) {
            Logger.getLogger(ApplicationView.class.getName()).log(Level.SEVERE, null, ioe);
        }
    }

    public static String getIdMapelByGuru(String username) {
        String result = "";
        try {
            Class.forName("org.postgresql.Driver");

            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/School", "postgres",
                    "sibeHBQ342169");
            Statement statement = con.createStatement();
            ResultSet res = statement.executeQuery("SELECT * FROM guru WHERE username='" + username + "'");

            while (res.next()) {
                result = res.getString("id_mapel");
            }

            statement.close();
            con.close();
        } catch (Exception e) {
            // TODO: handle exception
            Logger.getLogger(ApplicationView.class.getName()).log(Level.SEVERE, null, e);
        }
        return result;
    }

    public static String getMapelByGuru(String username) {
        String result = "";
        try {
            Class.forName("org.postgresql.Driver");

            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/School", "postgres",
                    "sibeHBQ342169");
            Statement statement = con.createStatement();
            ResultSet res = statement.executeQuery("SELECT * FROM guru WHERE username='" + username + "'");
            var guruIdMapel = "";
            while (res.next()) {
                guruIdMapel = res.getString("id_mapel");
                var tingjur = namaBeban(guruIdMapel);
                result = tingjur[0];
            }

            statement.close();
            con.close();
        } catch (Exception e) {
            // TODO: handle exception
            Logger.getLogger(ApplicationView.class.getName()).log(Level.SEVERE, null, e);
        }
        return result;
    }

    public static void guruBiodata(String username) {
        try {
            Class.forName("org.postgresql.Driver");

            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/School", "postgres",
                    "sibeHBQ342169");
            Statement statement = con.createStatement();
            ResultSet res = statement.executeQuery("SELECT * FROM guru WHERE username='" + username + "'");
            PrettyTable prettyTable = new PrettyTable("NIP", "Nama", "Mata Pelajaran", "Beban");
            var guruIdMapel = "";
            var nama = "";
            while (res.next()) {
                guruIdMapel = res.getString("id_mapel");
                var tingjur = namaBeban(guruIdMapel);
                nama = res.getString("nama");
                prettyTable.addRow(String.valueOf(res.getInt("nip")), res.getString("nama"),
                        tingjur[0], String.valueOf(Integer.parseInt(tingjur[1])));
            }
            ClearScreenUtil.ClearConsole();
            System.out.println("------------------------------");
            System.out.println("          * BIODATA *");
            System.out.println("------------------------------\n");
            System.out.println(prettyTable);
            System.out.print("\nKlik enter untuk kembali! ");
            new ConfirmUtil();
            guruHome(nama, username);
            ;
            statement.close();
            con.close();
        } catch (Exception ioe) {
            Logger.getLogger(ApplicationView.class.getName()).log(Level.SEVERE, null, ioe);
        }
    }

}
