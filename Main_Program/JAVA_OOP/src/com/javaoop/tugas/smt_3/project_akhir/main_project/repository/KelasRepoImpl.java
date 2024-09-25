package com.javaoop.tugas.smt_3.project_akhir.main_project.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.javaoop.tugas.smt_3.project_akhir.main_project.entities.Kelas;

public class KelasRepoImpl extends DataRepository implements DatatInteRepo {

    @Override
    public void setDataToDatabase(int tingkat, String jurusan){
        try{
            Kelas kelasTemp = new Kelas(tingkat, jurusan);

            Class.forName("org.postgresql.Driver");
            Connection con = 
            DriverManager.getConnection("jdbc:postgresql://localhost:5432/School", "postgres", "sibeHBQ342169");
            java.sql.PreparedStatement statement = con.prepareStatement("insert into kelas_object values (?,?,?,?)");

            statement.setString(1, kelasTemp.getKategori());
            statement.setString(2, kelasTemp.getJurusan());
            statement.setInt(3, kelasTemp.getTingkat());
            statement.setBytes(4, toBytes(kelasTemp));
            
            statement.executeUpdate();

            statement.close();
            con.close();
        } catch (Exception e) {
            Logger.getLogger(KelasRepoImpl.class.getName()).log(Level.SEVERE,null,e);
            System.out.println("Data tidak boleh sama");
        }
    }

    public static Kelas getKelasFromDatabase(String category){
        Kelas kelasTemp = null;
        try{
            Class.forName("org.postgresql.Driver");

            Connection con = DriverManager.getConnection
            ("jdbc:postgresql://localhost:5432/School", "postgres", "sibeHBQ342169");

            Statement statement = con.createStatement();
            ResultSet res = statement.executeQuery("SELECT * FROM kelas_object WHERE category ilike '%"+category+"%'");

            while (res.next()){
                Object o = toObject(res.getBytes(4));
                System.out.println("atas");
                if (o instanceof Kelas){
                    System.out.println("bawah");
                    kelasTemp = (Kelas) o;
                }
            }
            statement.close();
            con.close();
        } catch (Exception ioe){
            Logger.getLogger(KelasRepoImpl.class.getName()).log(Level.SEVERE, null, ioe);
        }
        return kelasTemp;
    }

    public static byte[] toBytes(Object object){
        java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
        try{
            java.io.ObjectOutputStream oos = new java.io.ObjectOutputStream(baos);
            oos.writeObject(object);
            oos.flush();
            oos.close();
        } catch (Exception ioe){
            ioe.getMessage();
        }
        return baos.toByteArray();
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

    @Override
    public void setDataToDatabase(String nama, String username, String password, String aktor, String index) {
        // TODO Auto-generated method stub
        
    }
}
