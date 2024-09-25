package com.javaoop.java_dasar.Object_Database;

import java.io.Serializable;

public class BeanTest implements Serializable{
    private String nama;
    private String alamat;

    public String getNama(){
        return nama;
    }

    public void setNama(String nama){
        this.nama = nama;
    }

    public String getAlamat(){
        return alamat;
    }

    public void setAlamat(String alamat){
        this.alamat = alamat;
    }
}
