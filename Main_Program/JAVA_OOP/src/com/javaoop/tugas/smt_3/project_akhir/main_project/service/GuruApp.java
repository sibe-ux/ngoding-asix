package com.javaoop.tugas.smt_3.project_akhir.main_project.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.javaoop.tugas.smt_3.project_akhir.main_project.repository.SiswaRepoImpl;
import com.javaoop.tugas.smt_3.project_akhir.main_project.util.ClearScreenUtil;
import com.javaoop.tugas.smt_3.project_akhir.main_project.util.ConfirmUtil;
import com.javaoop.tugas.smt_3.project_akhir.main_project.util.ValidationUtil;
import com.javaoop.tugas.smt_3.project_akhir.main_project.view.ApplicationView;
import com.javaoop.tugas.smt_3.project_akhir.main_project.view.GuruHomeView;
import com.javaoop.tugas.smt_3.project_akhir.main_project.view.Pretty_Table.PrettyTable;

public class GuruApp {
    private String nama;
    private String username;
    private Map<Integer, String> dictionary = new HashMap<Integer, String>();

    public GuruApp(String nama, String username){
        this.nama = nama;
        this.username = username;
    }

    public void setNilai(String nama,String username){
        ClearScreenUtil.ClearConsole();
        System.out.println("===============================");
        System.out.println("       ** NILAI TUGAS ** ");
        System.out.println("===============================\n");
        try {
            Class.forName("org.postgresql.Driver");

            Connection con = DriverManager.getConnection
            ("jdbc:postgresql://localhost:5432/School", "postgres", "sibeHBQ342169");
            Statement statement = con.createStatement();
            ResultSet res = statement.executeQuery("select k.category, jurusan, tingkat"+
            " from kelas_object k join tugas t on k.category = t.category"+
            " where t.id_mapel='"+GuruHomeView.getIdMapelByGuru(username)+"' order by k.category asc");
            PrettyTable prettyTable = new PrettyTable("No","Tingkat","Jurusan","Kategori","Jumlah Siswa"); 
            var x = 1;
            var dummy = "";
            while (res.next()){
                if (res.getString("category").equals(dummy)){
                    continue;
                } else{
                    prettyTable.addRow(String.valueOf(x),String.valueOf(res.getInt("tingkat")),
                    res.getString("jurusan"),
                    res.getString("category"),
                    String.valueOf(SiswaRepoImpl.getSiswaByKelas(res.getString("category"))));
                    dummy = res.getString("category"); 
                    dictionary.put(x, res.getString("category"));
                    x++;
                }
            }

            if (x-1 == 0){
                prettyTable.addRow("--","--","--","--","--");
                System.out.println(prettyTable);
                System.out.print("\nBelum ada tugas yang diberikan! Klik enter untuk kembali! ");
                new ConfirmUtil();
                GuruHomeView.guruHome(nama, username);
            } else{
                System.out.println(prettyTable);
                var inkelas = ValidationUtil.inputInteger(
                    "Pilih kelas :: ", dictionary.size());
                setNilai(dictionary.get(inkelas));
                
            }
        
            statement.close();
            con.close();
        } catch (Exception e) {
            //TODO: handle exception
            Logger.getLogger(ApplicationView.class.getName()).log(Level.SEVERE, null, e);
        }        
    }

    // OVERLAODING
    public void setNilai(String kategori){
        ClearScreenUtil.ClearConsole();
        try {
            Class.forName("org.postgresql.Driver");

            Connection con = DriverManager.getConnection
            ("jdbc:postgresql://localhost:5432/School", "postgres", "sibeHBQ342169");
            Statement statement = con.createStatement();
            ResultSet res = statement.executeQuery(
                "SELECT * from tugas where category = '"+kategori
                +"' and id_mapel = '"+GuruHomeView.getIdMapelByGuru(username)+"'");
            PrettyTable prettyTable = new PrettyTable("No", "Jenis", "Nama Tugas", "Status");

            var no = 1;
            var index = 0;
            var category = "";
            while(res.next()){
                prettyTable.addRow(String.valueOf(no),"Tugas ke-"+
                res.getString("urutan"),res.getString("nama_tugas").toUpperCase(),
                countKerjakan(kategori, "true", no)+" (Selesai) / "+
                countKerjakan(kategori, "false", no)+" (Belum Dikerjakan)");
                category =  res.getString("category");
                no++;
                index+=2;
            }
            System.out.println("===============================");
            System.out.println("       ** NILAI TUGAS ** ");
            System.out.println("        << "+category+" >>");
            System.out.println("===============================\n");
            System.out.println(prettyTable);
            System.out.println("-----------------------------");
            var x = ValidationUtil.inputInteger("Pilih Tugas :: ", countKerjakan(kategori)/2);
            ClearScreenUtil.ClearConsole();
            viewSiswa(kategori, x);
            con.close();
            statement.close();
        } catch (Exception e) {
            Logger.getLogger(ApplicationView.class.getName()).log(Level.SEVERE, null, e);
            //TODO: handle exception
        }
    }

    public int[] countKerjakanNotKerjakan(String kategori) {
        int[] result = null;
        try {
            Class.forName("org.postgresql.Driver");

            Connection con = DriverManager.getConnection
            ("jdbc:postgresql://localhost:5432/School", "postgres", "sibeHBQ342169");
            Statement statement = con.createStatement();
            ResultSet res = statement.executeQuery(
                "select count(*) as jumlah from tugas where id_mapel='"+
                GuruHomeView.getIdMapelByGuru(username)+
                "' and category='"+kategori+"'");
            
            int[] urutan = new int[countKerjakan(kategori)];
            var no = 0;
            var urtu = 1;
            while(res.next()){
                urutan[no] = countKerjakan(kategori, "true", urtu);
                urutan[no+1] = countKerjakan(kategori, "false", urtu);
                System.out.println(no+" oke kel");
                System.out.println(no+1+" oke kel");
                no++;
                urtu++;
            }
            result = urutan;
            
        } catch (Exception e) {
            Logger.getLogger(ApplicationView.class.getName()).log(Level.SEVERE, null, e);
            //TODO: handle exception
        }
        return result;
    }

    public int countKerjakan(String kategori){
        int result = 0;
        try {
            Class.forName("org.postgresql.Driver");

            Connection con = DriverManager.getConnection
            ("jdbc:postgresql://localhost:5432/School", "postgres", "sibeHBQ342169");
            Statement statement = con.createStatement();
            ResultSet res = statement.executeQuery("select count(*) as jumlah from tugas where id_mapel='"+
            GuruHomeView.getIdMapelByGuru(username)+
            "' and category='"+kategori+"'");
            
            var no = 1;
            while(res.next()){
                no = res.getInt("jumlah");
            }
            result = no*2; // true/false [ ]
            con.close();
            statement.close();
        } catch (Exception e) {
            Logger.getLogger(ApplicationView.class.getName()).log(Level.SEVERE, null, e);
            //TODO: handle exception
        }
        return result;
    }

    // OVERLOADING
    public int countKerjakan(String kategori, String status, int urutan){
        int result = 0;
        try {
            Class.forName("org.postgresql.Driver");

            Connection con = DriverManager.getConnection
            ("jdbc:postgresql://localhost:5432/School", "postgres", "sibeHBQ342169");
            Statement statement = con.createStatement();
            ResultSet dump = null;
            if(status.equals("false")){
                dump = statement.executeQuery("select st.id_tugas, st.nis, st.is_kerjakan, t.nama_tugas,"+
                " t.urutan, t.id_mapel, t.category "
                +"from status_tugas as st"+
                " join tugas t on st.id_tugas = t.id_tugas "+  
                "where t.category = '"+kategori+"' and t.id_mapel='"+
                GuruHomeView.getIdMapelByGuru(username)+"' and st.is_kerjakan = 'false' and t.urutan = "+urutan);
            } else{
                dump = statement.executeQuery("select st.id_tugas, st.nis, st.is_kerjakan, t.nama_tugas,"+
                " t.urutan, t.id_mapel, t.category "
                +"from status_tugas as st"+
                " join tugas t on st.id_tugas = t.id_tugas  "+  
                "where t.category = '"+kategori+"' and t.id_mapel='"+
                GuruHomeView.getIdMapelByGuru(username)+"' and st.is_kerjakan = 'true' and t.urutan = "+urutan);
            }
            
            var no = 0;
            while(dump.next()){
                no++;
            }
            result = no;
            con.close();
            statement.close();
    } catch (Exception e) {
        Logger.getLogger(ApplicationView.class.getName()).log(Level.SEVERE, null, e);
    }
    return result;
    }

    public void viewSiswa(String kategori, int urutan){
        ClearScreenUtil.ClearConsole();
        try {
            Class.forName("org.postgresql.Driver");

            Connection con = DriverManager.getConnection
            ("jdbc:postgresql://localhost:5432/School", "postgres", "sibeHBQ342169");
            Statement statement = con.createStatement();
            ResultSet res = statement.executeQuery("select st.id_tugas, st.nis, st.is_kerjakan, t.nama_tugas,"+
            " t.urutan, t.id_mapel, t.category, s.nama "
            +"from status_tugas as st"+
            " join tugas t on st.id_tugas = t.id_tugas join siswa s on st.nis = cast(s.nis as varchar(15)) "+  
            "where s.category = '"+kategori+"' and t.id_mapel='"+
            GuruHomeView.getIdMapelByGuru(username)+"' and urutan = "+urutan);
            PrettyTable prettyTable = new PrettyTable("No","NIS","Nama","Status Pengerjaan");
            var no = 1;
            String[] nis = new String[ApplicationView.countSiswaByCategory(kategori)];
            var category = "";
            var urutanx= 0;
            var namaTugas = "";
            while(res.next()){
                if ((!"true".equals(res.getString("is_kerjakan"))) && (!"false".equals(res.getString("is_kerjakan")))){
                    prettyTable.addRow(String.valueOf(no),res.getString("nis"),res.getString("nama"),
                res.getString("is_kerjakan"));
                } else{
                    prettyTable.addRow(String.valueOf(no),res.getString("nis"),res.getString("nama"),
                    res.getString("is_kerjakan").equals("true") ? "Selesai" : "Belum dikerjakan");
                }
                category = res.getString("category");
                urutanx = res.getInt("urutan");
                namaTugas = res.getString("nama_tugas");
                nis [no-1] = res.getString("nis");
                no++;
            }
            System.out.println("===============================");
            System.out.println("       ** NILAI TUGAS ** ");
            System.out.println("        << "+category+" >>");
            System.out.println("===============================\n");
            System.out.println("----------  TUGAS "+urutanx+" - "+
            namaTugas.toUpperCase()+"  ----------");
            System.out.println(prettyTable);
            System.out.println("\n[0] Kembali");
            System.out.println("------------------------");
            var siswa = ValidationUtil.inputInteger("Pilih Siswa :: ", no-1,0);
            if(siswa != 0){
                if
                (getIsKerjakanSiswa(nis[siswa-1], kategori, urutan).equals("false")){
                    System.out.println("<< Tidak dapat memberikan nilai! Tugas belum dikerjakan! >>");
                    System.out.print("\nKlik enter untuk ulangi! ");
                    new ConfirmUtil();
                    if (ConfirmUtil.getInput().equalsIgnoreCase("0")){
                        ClearScreenUtil.ClearConsole();
                        GuruHomeView.guruHome(nama, username);
                    } else{
                        ClearScreenUtil.ClearConsole();
                        viewSiswa(kategori, urutan);
                    }
                } else if
                (getIsKerjakanSiswa(nis[siswa-1], kategori, urutan).equals("true")){
                    System.out.println("------------------------");
                    var nilai = ValidationUtil.inputInteger("Masukkan Nilai : ",100);
                    ValidationUtil a = new ValidationUtil();
                    System.out.println("------------------------");
                    var beri = a.inputYesNo("Yakin untuk memberikan nilai? (Y/t) ");
                    if(beri.equals("y")){
                        changeNilaiSiswa(nis[siswa-1], kategori, urutan, nilai);
                    } else{
                        System.out.println("Pemberian nilai dibatalkan! Klik enter untuk kembali! ");
                        new ConfirmUtil();
                        ClearScreenUtil.ClearConsole();
                        GuruHomeView.guruHome(nama, username);
                    }
                } else{
                    ValidationUtil a = new ValidationUtil();
                    var nilai = a.inputYesNo(
                        "Siswa telah diberikan nilai sebelumnya!"+
                    "Yakin untuk merubah nilai? (Y/t) ");
                    if (nilai.equals("y")){
                        System.out.println("--------------------");
                        var b = ValidationUtil.inputInteger("Masukkan nilai : ",100);
                        changeNilaiSiswa(nis[siswa-1], kategori, urutan, b);
                        System.out.println("--------------------");
                        System.out.println("\nPerubahan berhasil! Klik enter untuk kembali! ");
                        ClearScreenUtil.ClearConsole();
                        GuruHomeView.guruHome(nama, username);
                    } else{
                        System.out.println("\nPerubahan dibatalkan! Klik enter untuk kembali! ");
                        ClearScreenUtil.ClearConsole();
                        GuruHomeView.guruHome(nama, username);
                    }
                }
            } else{
                ClearScreenUtil.ClearConsole();
                GuruHomeView.guruHome(nama, username);
            }
            con.close();
            statement.close();
        } catch (Exception e) {
            Logger.getLogger(ApplicationView.class.getName()).log(Level.SEVERE, null, e);
            //TODO: handle exception
        }
    }

    public String getIsKerjakanSiswa(String nis, String kategori, int urutan){
        String result = "";
        try {
            Class.forName("org.postgresql.Driver");

            Connection con = DriverManager.getConnection
            ("jdbc:postgresql://localhost:5432/School", "postgres", "sibeHBQ342169");
            Statement statement = con.createStatement();
            ResultSet res = statement.executeQuery("select st.id_tugas, st.nis, st.is_kerjakan, t.nama_tugas,"+
            " t.urutan, t.id_mapel, t.category, s.nama "
            +"from status_tugas as st"+
            " join tugas t on st.id_tugas = t.id_tugas join siswa s on t.category = s.category "+  
            "where s.category = '"+kategori+"' and t.id_mapel='"+
            GuruHomeView.getIdMapelByGuru(username)+"' and urutan = "+urutan+
            " and st.nis='"+nis+"'");
            var dump = ""; 
            while(res.next()){
                dump = res.getString("is_kerjakan");
            }
            result =  dump;
            con.close();
            statement.close();
        } catch (Exception e) {
            Logger.getLogger(ApplicationView.class.getName()).log(Level.SEVERE, null, e);
            //TODO: handle exception
        }
        return result;
    }

    public String getIdTugas(String nis, String kategori, int urutan){
        String result = "";
        try {
            Class.forName("org.postgresql.Driver");

            Connection con = DriverManager.getConnection
            ("jdbc:postgresql://localhost:5432/School", "postgres", "sibeHBQ342169");
            Statement statement = con.createStatement();
            ResultSet res = statement.executeQuery("select st.id_tugas, st.nis, st.is_kerjakan, t.nama_tugas,"+
            " t.urutan, t.id_mapel, t.category, s.nama "
            +"from status_tugas as st"+
            " join tugas t on st.id_tugas = t.id_tugas join siswa s on t.category = s.category "+  
            "where s.category = '"+kategori+"' and t.id_mapel='"+
            GuruHomeView.getIdMapelByGuru(username)+"' and urutan = "+urutan+
            " and st.nis='"+nis+"'");
            var dump = ""; 
            while(res.next()){
                dump = res.getString("id_tugas");
            }
            result =  dump;
            con.close();
            statement.close();
        } catch (Exception e) {
            Logger.getLogger(ApplicationView.class.getName()).log(Level.SEVERE, null, e);
            //TODO: handle exception
        }
        return result;
    }

    public void changeNilaiSiswa(String nis, String kategori, int urutan, int nilai){
        try {
            Class.forName("org.postgresql.Driver");

            Connection con = DriverManager.getConnection
            ("jdbc:postgresql://localhost:5432/School", "postgres", "sibeHBQ342169");
            java.sql.PreparedStatement statement = con.prepareStatement("UPDATE status_tugas SET "+
            "id_tugas='"+getIdTugas(nis, kategori, urutan)+
            "', nis='"+nis+"', is_kerjakan ="+nilai+
            " WHERE id_tugas='"+getIdTugas(nis, kategori, urutan)+"' and nis='"+nis+"'");

            statement.executeUpdate();

            statement.close();
            con.close();
            System.out.println("\n===============================");
            System.out.println("Nilai berhasil ditambahkan!");
            System.out.println("===============================");
            System.out.print("\nKlik enter untuk ke halaman utama! ");
            new ConfirmUtil();
            ClearScreenUtil.ClearConsole();
            GuruHomeView.guruHome(nama, username);
    } catch (Exception e) {
        Logger.getLogger(ApplicationView.class.getName()).log(Level.SEVERE, null, e);
        //TODO: handle exception
    }
}
    
    public String getNama() {
        return nama;
    } 

    public String getUsername() {
        return username;
    }
}