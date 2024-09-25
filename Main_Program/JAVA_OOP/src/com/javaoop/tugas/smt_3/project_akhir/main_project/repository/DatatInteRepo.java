package com.javaoop.tugas.smt_3.project_akhir.main_project.repository;

// INTERFACE
public interface DatatInteRepo {
    
    public void setDataToDatabase(String nama, String username,String password,String aktor, String index);

    public abstract void setDataToDatabase(int tingkat, String jurusan);

}
