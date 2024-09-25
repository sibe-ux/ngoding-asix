/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javaoop.tugas.smt_3.TM.PROJECT.models;

import java.util.ArrayList;

/**
 *
 * @author Istiyadi
 */
public class barang extends dataManager {

    int idBarang;
    String namaBarang;
    double hargaBeliSatuan;
    String satuanBarang;
    double jmlBarang;
    double hargaJualSatuan;

    public void setIdBarang(int idBarang) {
        this.idBarang = idBarang;
    }

    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }

    public void setHargaBeliSatuan(double hargaBeliSatuan) {
        this.hargaBeliSatuan = hargaBeliSatuan;
    }

    public void setJumlahBarangMasuk(double jmlBarang) {
        this.jmlBarang = jmlBarang;
    }

//    public void setSatuanBarang(String satuanBrg) {
//        this.satuanBarang = satuanBrg;
//    }

    public void simpanBarangMasuk(int idPersonPengentriData) {
        query = "INSERT INTO \n"
                + "  barang.barang_masuk\n"
                + "(\n"
                + "  id_barang,\n"
                + "  id_person,\n"
                + "  jumlah_barang,\n"
                //+ "  satuan_barang,\n"
                + "  harga_satuan\n"
                + ")\n"
                + "VALUES (\n"
                + "  %d,\n"
                + "  %d,\n"
                + "  %f,\n"
                //+ "  '%s',\n"
                + "  %f\n"
                + ");";

        query = String.format(query, this.idBarang, idPersonPengentriData,
                this.jmlBarang,  this.hargaBeliSatuan);
        super.executeNonQuery(query);

    }

    public ArrayList listStokBarang() {
        super.listData.clear();
        super.listField.clear();
        query = "with total_brg_masuk as(\n"
                + "	select bm.id_barang , sum(bm.jumlah_barang) as total_barang  \n"
                + "	from barang.barang_masuk bm \n"
                + "	group by bm.id_barang \n"
                + "),\n"
                + "total_brg_terjual as(\n"
                + "\n"
                + "	select bj.id_barang \n"
                + "	,sum(ltp.jumlah_barang )::int as total_terjual\n"
                + "	from barang.barang_jual bj \n"
                + "	join transaksi.list_transaksi_penjualan ltp on ltp.id_barang_jual = bj.id_barang_jual \n"
                + "	group by bj.id_barang\n"
                + ")\n"
                + "\n"
                + "select  \n"
                + " b.nama_barang \n"
                + ", tbm.total_barang - coalesce (tbt.total_terjual,0) as stok\n"
                + ", sb.satuan_barang \n"
                + "\n"
                + "from barang.barang b \n"
                + "join barang.satuan_barang sb on sb.kode_satuan_barang=b.kode_satuan_barang \n"
                + "join total_brg_masuk tbm on tbm.id_barang=b.id_barang \n"
                + "left join total_brg_terjual tbt on tbt.id_barang=b.id_barang \n"
                + "order by b.id_barang";
        executeQuery(query);
        return super.listData;
    }

    public ArrayList listField() {
        return super.listField;
    }

    public double getHargaBarangSatuan(int idBarang) {
        query = "select bj.harga_jual_satuan::numeric from barang.barang_jual bj \n"
                + "where bj.id_barang = " + String.valueOf(idBarang);
        super.executeQuery(query);
        this.hargaJualSatuan = Double.valueOf(super.listData.get(0).toString());
        return this.hargaJualSatuan;
    }

}
