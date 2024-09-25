package com.javaoop.java_dasar.Object_Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();

        // simpan data ke database
        // main.setData();

        // tarik isi database
        main.getData();
    }

    @SuppressWarnings("unused")
    private void setData(){
        try{
            BeanTest bean = new BeanTest();

            bean.setNama("sibe");
            bean.setAlamat("bandung");

            Class.forName("org.postgresql.Driver");
            Connection con = 
            DriverManager.getConnection("jdbc:postgresql://localhost:5432/School", "postgres", "sibeHBQ342169");
            java.sql.PreparedStatement statement = con.prepareStatement("insert into test values (?,?)");

            statement.setString(1, "00004");
            statement.setBytes(2, toBytes(bean));

            statement.executeUpdate();

            statement.close();
            con.close();
        } catch (Exception e) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE,null,e);
            System.out.println("Data tidak boleh sama");
        }
    }

    private byte[] toBytes(Object object){
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

    public void getData(){
        try{
            Class.forName("org.postgresql.Driver");

            Connection con = DriverManager.getConnection
            ("jdbc:postgresql://localhost:5432/School", "postgres", "sibeHBQ342169");
        
            Statement statement = con.createStatement();
            ResultSet res = statement.executeQuery("SELECT * FROM test");

            while (res.next()){
                Object o = toObject(res.getBytes(2));
                
                if (o instanceof BeanTest){
                    BeanTest beanTest = (BeanTest) o;
                    System.out.println(beanTest.getNama());
                    System.out.println(beanTest.getAlamat());
                }
            }

            statement.close();
            con.close();

        } catch (Exception ioe){
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ioe);
        }
    }

    private Object toObject(byte[] bytes){
        Object object = null;
        try{
            object = new java.io.ObjectInputStream(
                new java.io.ByteArrayInputStream(bytes)).readObject();
    
        } catch(Exception cnfe){
            cnfe.getMessage();
        }

        return object;
    }
}
