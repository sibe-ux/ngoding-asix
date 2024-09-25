package com.javaoop.tugas.smt_3.project_akhir.main_project.entities;

import java.io.Serializable;

import com.javaoop.tugas.smt_3.project_akhir.main_project.view.ApplicationView;

public class Kelas implements Serializable {

    private int tingkat;
        private int jumlahMurid = 0;
        private String kategori;
        private String jurusan;

        public Kelas(int tingkat, String jurusan){
            this.tingkat = tingkat;
            this.jurusan = jurusan.toUpperCase();
            // if (tingkat == 10){
            //     this.kategori = "X-"+jurusan.getNamaJurusan()+"-"+String.valueOf(Kelas.jenisKelas);
            //     Kelas.jenisKelas +=1;
            // } else if(tingkat == 11){
            //     this.kategori = "XI-"+jurusan.getNamaJurusan()+"-"+String.valueOf(Kelas.jenisKelas);
            //     Kelas.jenisKelas +=1;
            // } else if (tingkat == 12){
            //     this.kategori = "XII-"+jurusan.getNamaJurusan()+"-"+String.valueOf(Kelas.jenisKelas);
            //     Kelas.jenisKelas +=1;
            // } 

            if ((tingkat == 10) || (tingkat == 1)){
                this.kategori = "10-"+jurusan.toUpperCase()+"-"+String.valueOf(ApplicationView.countRowsColumns(jurusan,tingkat)+1);
            } else if ((tingkat == 11) || (tingkat == 2)){
                this.kategori = "11-"+jurusan.toUpperCase()+"-"+String.valueOf(ApplicationView.countRowsColumns(jurusan,tingkat)+1);
            } else if ((tingkat == 12) || (tingkat == 3)){
                this.kategori = "12-"+jurusan.toUpperCase()+"-"+String.valueOf(ApplicationView.countRowsColumns(jurusan,tingkat)+1);
            } 
        } 

        public int getTingkat(){
            return this.tingkat;
        }

        // SETTER
        public void setTingkat(int tingkat){
            this.tingkat = tingkat;
        }

        public String getKategori(){
            return this.kategori;
        }

        public void setKatgeori(String kategori){
            this.kategori = kategori;
        }

        public String getJurusan(){
            return this.jurusan;
        }

        public int getJumlahMurid(){
            return this.jumlahMurid;
        }

        public void setJumlahMurid(){
            this.jumlahMurid +=1;
        }
    
}
