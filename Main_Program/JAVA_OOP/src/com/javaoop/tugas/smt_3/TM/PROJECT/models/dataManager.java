/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javaoop.tugas.smt_3.TM.PROJECT.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Istiyadi
 */
abstract class dataManager {

    String url;
    String user;
    String password;
    Connection con;
    String query;
    ArrayList listField;
    ArrayList listData;
    boolean isDebug;

    public dataManager() {
        listField = new ArrayList();
        listData = new ArrayList();
        this.url = "jdbc:postgresql://localhost:5432/toko";
        this.user = "postgres";
        this.password = "123456";
        this.isDebug = false;
        try {
            this.con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/toko", "postgres","123456");  //DriverManager.getConnection(url, user, password)
        } catch (SQLException ex) {
            System.out.println("error: " + ex.toString());
        }
    }

    public void executeQuery(String query) {
        if (this.isDebug) {
            System.out.println("query: " + query);
        }
        this.listData.clear();
        this.listField.clear();
        try {
            PreparedStatement pst = this.con.prepareStatement(query, ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = pst.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int kol = rsmd.getColumnCount();
            int idx = 0;
            while (rs.next()) {
                for (int i = 0; i < kol; i++) {
                    String namaKol = rsmd.getColumnLabel(i + 1);
                    if (idx == 0) {
                        listField.add(namaKol);
                    }
                    listData.add((rs.getString(namaKol)));
                }
                idx++;
            }
//            this.con.commit();
//            this.con.close();
        } catch (SQLException ex) {
            System.out.println("error: " + ex.toString());
        }

    }

    public ArrayList getListKolom() {
        return listField;
    }

    public ArrayList getListData() {
        return listData;
    }

    public void executeNonQuery(String query) {  
        if (this.isDebug) {
            System.out.println("query: " + query);
        }
        try {
            PreparedStatement pst = this.con.prepareStatement(query, ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            pst.executeUpdate();
//            this.con.commit();
//            this.con.close();
        } catch (SQLException ex) {
            System.out.println("error: " + ex.toString());
        }
    }
}
