package com.javaoop.tugas.smt_3.project_akhir.main_project.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.javaoop.materi.Pretty_Table.PrettyTable;
import com.javaoop.tugas.smt_3.project_akhir.main_project.entities.Siswa;
import com.javaoop.tugas.smt_3.project_akhir.main_project.util.ClearScreenUtil;
import com.javaoop.tugas.smt_3.project_akhir.main_project.util.ConfirmUtil;
import com.javaoop.tugas.smt_3.project_akhir.main_project.util.ValidationUtil;
import com.javaoop.tugas.smt_3.project_akhir.main_project.view.ApplicationView;
import com.javaoop.tugas.smt_3.project_akhir.main_project.view.GuruHomeView;
import com.javaoop.tugas.smt_3.project_akhir.main_project.view.SiswaHomeView;

public class SiswaRepoImpl extends DataRepository implements DatatInteRepo { // IMPLEMENTASI INTERFACE

    // NESTED CLASS
    public static class NilaiSiswa{
        
        NilaiSiswa(){

        }

        public static void viewNilai(String nama,String username){
            try {
                ClearScreenUtil.ClearConsole();
                Class.forName("org.postgresql.Driver");
    
                Connection con = DriverManager.getConnection
                ("jdbc:postgresql://localhost:5432/School", "postgres", "sibeHBQ342169");
    
                Statement statement = con.createStatement();
                ResultSet res = statement.executeQuery("select s.*, st.*, t.*, m.*"
                +" from status_tugas as st"
                +" join tugas as t on st.id_tugas = t.id_tugas"
                +" join mapel as m on t.id_mapel = m.id_mapel"
                +" join siswa as s on st.nis = cast(s.nis as varchar(15))"
                +" where s.nis = '"+getNisByUsername(username)+"' order by m.nama asc");

                PrettyTable prettyTable = new PrettyTable("No", "Jenis", "Agama Islam","Bahasa","Kewarganegaraan","Matematika","Sejarah");
                var no = 1;
                while (res.next()){
                    prettyTable.addRow(String.valueOf(no),"Tugas ke-"+String.valueOf(no),
                    getNilaiPerMatkul(username, res.getString("nis"),
                    no, "PAI-05"), getNilaiPerMatkul(username, res.getString("nis"),
                    no, "BIND-06"),getNilaiPerMatkul(username, res.getString("nis"), 
                    no, "PKN-17"),getNilaiPerMatkul(username, res.getString("nis"), 
                    no, "MTK-01"),  getNilaiPerMatkul(username, res.getString("nis"), 
                    no, "SI-12"));
                    no++;
                }

                System.out.println("===============================");
                System.out.println("       ** HASIL NILAI ** ");
                System.out.println("===============================\n");

                System.out.println("-------------------------");
                System.out.println("[1] Individu");
                System.out.println("[2] Ranking Sekolah");
                System.out.println("\n[0] Kembali");
                System.out.println("-------------------------");
                var inp = ValidationUtil.inputInteger("Pilih Menu :: ", 2,0);
                if(inp == 1){
                    ClearScreenUtil.ClearConsole();
                    System.out.println("===============================");
                    System.out.println("        ** INDIVIDU ** ");
                    System.out.println("===============================\n");
                    System.out.println(prettyTable);
                    System.out.println("----------------------------------");
                    System.out.print("\nTekan enter untuk kembali! ");
                    new ConfirmUtil();
                    viewNilai(nama,username);;
                } else if(inp == 2){
                    ClearScreenUtil.ClearConsole();
                    rankingSiswa("siswa", nama, username);
                } else if(inp == 0){
                    ClearScreenUtil.ClearConsole();
                    new SiswaHomeView(nama, username);
                }

                con.close();
                statement.close();
            } catch (Exception e) {
                //TODO: handle exception
                Logger.getLogger(ApplicationView.class.getName()).log(Level.SEVERE, 
                null, e);
            }
        }

        public static void rankingSiswa(String aktor, String nama, String username){
            try {
                ClearScreenUtil.ClearConsole();
                Class.forName("org.postgresql.Driver");
    
                Connection con = DriverManager.getConnection
                ("jdbc:postgresql://localhost:5432/School", "postgres", "sibeHBQ342169");
    
                Statement statement = con.createStatement();
                ResultSet res = statement.executeQuery("select avg(cast(st.is_kerjakan as integer)) as avg, sum(cast(st.is_kerjakan as integer)) as sum"
                +", s.nis, s.nama, kl.tingkat, kl.jurusan, kl.category"
                +" from status_tugas as st"
                +" join siswa as s on st.nis = cast(s.nis as varchar(5))"
                +" join kelas_object as kl on s.category = kl.category "
                +" where st.is_kerjakan != 'false' and st.is_kerjakan != 'true'"
                +" group by s.nis, s.nama, kl.tingkat, kl.jurusan, kl.category order by avg desc");

                PrettyTable prettyTable = new PrettyTable("Rank", "Nama","Tingkat","Jurusan", "Kelas","Total Nilai","Rata-Rata");
                var no = 1;
                while (res.next()){
                    double hasil = Double.valueOf(res.getDouble("avg"));
                    var format = new DecimalFormat("#.###");
                    var rata2 = format.format(hasil);
                    prettyTable.addRow(String.valueOf(no),res.getString("nama"),
                    res.getString("tingkat"),
                    res.getString("jurusan"),res.getString("category"),
                    String.valueOf(res.getString("sum")) ,
                    rata2);
                    no++;
                }

                System.out.println("===============================");
                System.out.println("      ** RANKING SISWA ** ");
                System.out.println("===============================\n");

                System.out.println(prettyTable);
                System.out.println("\n--------------------------");
                System.out.print("Tekan enter untuk kembali! ");
                new ConfirmUtil();
                if(aktor.equalsIgnoreCase("guru")){
                    GuruHomeView.guruHome(nama, username);;
                } else{
                    viewNilai(nama, username);
                }
                con.close();
                statement.close();
            } catch (Exception e) {
                //TODO: handle exception
                Logger.getLogger(ApplicationView.class.getName()).log(Level.SEVERE, null, e);
            }
        }

        public static String getNilaiPerMatkul(String username,String nis, int urutan, String idmapel){
            String result = "";
            try {
                Class.forName("org.postgresql.Driver");
    
                Connection con = DriverManager.getConnection
                ("jdbc:postgresql://localhost:5432/School", "postgres", "sibeHBQ342169");
    
                Statement statement = con.createStatement();
                ResultSet res = statement.executeQuery(
                    "select st.is_kerjakan, t.urutan, m.nama "
                +"from status_tugas as st"
                +" join tugas as t on st.id_tugas = t.id_tugas"
                +" join mapel as m on m.id_mapel = t.id_mapel"
                +" where st.is_kerjakan != 'false' and st.is_kerjakan != 'true'"+
                " and st.nis='"+getNisByUsername(username)+"' and t.urutan="+
                urutan+" and m.id_mapel = '"+idmapel+"'");

                String dump = "";
                while (res.next()){
                    dump = res.getString("is_kerjakan");    
                }
                if (dump.equals("")){
                    dump = "--";
                }
                result = dump;
                
            } catch (Exception e) {
                //TODO: handle exception
                Logger.getLogger(ApplicationView.class.getName()).log(Level.SEVERE, 
                null, e);
            }
            return result;
        }
    }

    public static String getCategoryBySiswa(String username){
        String result = "";
        try {
            Class.forName("org.postgresql.Driver");

            Connection con = DriverManager.getConnection
            ("jdbc:postgresql://localhost:5432/School", "postgres", "sibeHBQ342169");

            Statement statement = con.createStatement();
            ResultSet res = statement.executeQuery("SELECT * FROM siswa WHERE username='"
            +username+"'");
            while (res.next()){
                result = res.getString("category");
            }
        } catch (Exception e) {
            //TODO: handle exception
            Logger.getLogger(ApplicationView.class.getName()).log(Level.SEVERE, null, e);
        }
        return result;
    }

    public static int getSiswaByKelas(String category){
        int jumlahSiswa = 0;
        try{
            Class.forName("org.postgresql.Driver");

            Connection con = DriverManager.getConnection
            ("jdbc:postgresql://localhost:5432/School", "postgres", "sibeHBQ342169");

            Statement statement = con.createStatement();
            ResultSet res = statement.executeQuery(
                "SELECT COUNT(*) as baris FROM siswa WHERE category='"+category+"'");
            var baris = 0;
            while (res.next()){
                    baris = res.getInt("baris");
            }
            jumlahSiswa = baris;
            statement.close();
            con.close();
        } catch (Exception ioe){
            Logger.getLogger(ApplicationView.class.getName()).log(Level.SEVERE, null, ioe);
        }
        return jumlahSiswa;
    }

    public static String getNamaSiswa(String username){
        String namaSiswa = null;
        try{
            Class.forName("org.postgresql.Driver");

            Connection con = DriverManager.getConnection
            ("jdbc:postgresql://localhost:5432/School", "postgres", "sibeHBQ342169");

            Statement statement = con.createStatement();
            ResultSet res = statement.executeQuery("SELECT * FROM siswa WHERE username='"
            +username+"'");
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

    @Override // OVERRIDING METHOD
    public void setDataToDatabase(String nama, String username,String password,String aktor, String category){
        try{
            Class.forName("org.postgresql.Driver");

            Connection con = 
            DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/School", "postgres", "sibeHBQ342169");
            java.sql.PreparedStatement statement = con.prepareStatement(
                "insert into siswa values (?,?,?,?,?)");

            var baris = ApplicationView.countTableSiswa();
            Siswa SiswaTemp = new Siswa(1000+baris+1,nama,username, category);

            statement.setInt(1, 1000+baris+1);
            statement.setString(2, nama);
            statement.setString(3, username);
            statement.setString(4, category);
            statement.setBytes(5, KelasRepoImpl.toBytes(SiswaTemp));

            statement.executeUpdate();

            statement.close();
            con.close();
            DataRepository.addRowsLogin(username, password,"siswa");
        } catch (Exception e) {
            Logger.getLogger(KelasRepoImpl.class.getName()).log(Level.SEVERE,null,e);
            System.out.println("Data tidak boleh sama");
        }
    }

    public static Siswa getSiswaFromDatabase(){
        Siswa SiswaTemp = null;
        try{
            Class.forName("org.postgresql.Driver");

            Connection con = DriverManager.getConnection
            ("jdbc:postgresql://localhost:5432/School", "postgres", "sibeHBQ342169");

            Statement statement = con.createStatement();
            ResultSet res = statement.executeQuery("SELECT * FROM siswa");

            while (res.next()){
                Object o = toObject(res.getBytes(6));
                if (o instanceof Siswa){
                    SiswaTemp = (Siswa) o;
                }
            }
            statement.close();
            con.close();
        } catch (Exception ioe){
            Logger.getLogger(KelasRepoImpl.class.getName()).log(Level.SEVERE, null, ioe);
        }
        return SiswaTemp;
    }

    private static Object toObject(byte[] bytes){
        Object object = null;
        try{
            object = new java.io.ObjectInputStream(
                new java.io.ByteArrayInputStream(bytes)).readObject();
    
        } catch(Exception cnfe){
            cnfe.getMessage();
        }

        return object;
    }

    public static String[] getArrayNisByCategory(String category){
        String[] arrayNis = null;
        try{
            Class.forName("org.postgresql.Driver");

            Connection con = DriverManager.getConnection
            ("jdbc:postgresql://localhost:5432/School", "postgres", "sibeHBQ342169");

            Statement statement = con.createStatement();
            ResultSet res = statement.executeQuery("SELECT * FROM siswa WHERE category='"+
            category+"'");
            String dump[] = new String[ApplicationView.countSiswaByCategory(category)];
            var x = 0;
            while (res.next()){
                dump[x] = res.getString("nis");
                x++;
            }
            arrayNis = dump;
            statement.close();
            con.close();
        } catch (Exception ioe){
            Logger.getLogger(KelasRepoImpl.class.getName()).log(Level.SEVERE, null, ioe);
        }
        return arrayNis;
    }

    public static String getNisByUsername(String username){
        String result = "";
        try{
            Class.forName("org.postgresql.Driver");

            Connection con = DriverManager.getConnection
            ("jdbc:postgresql://localhost:5432/School", "postgres", "sibeHBQ342169");

            Statement statement = con.createStatement();
            ResultSet res = statement.executeQuery("SELECT * FROM siswa WHERE username='"+
            username+"'");
            
            var dump = "";
            while(res.next()){
                dump = res.getString("nis");
            }
            result = dump;

            statement.close();
            con.close();
        } catch (Exception ioe){
            Logger.getLogger(KelasRepoImpl.class.getName()).log(Level.SEVERE, null, ioe);
        }
        return result;
    }

    @Override
    public void setDataToDatabase(int tingkat, String jurusan) {
        // TODO Auto-generated method stub
        
    }

}
