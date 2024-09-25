/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javaoop.tugas.smt_3.TM.PROJECT.models;

import java.util.UUID;

/**
 *
 * @author Istiyadi
 */
public class transaksiPenjualan extends dataManager {

    public void simpanTransaksiPenjualan(int[] idBarang, double[] jmlBarang, int idPerson, int jmlItem) {
//        System.out.println("");
        UUID uuid = UUID.randomUUID();
        String newUuid = uuid.toString();

        query = "insert into transaksi.transaksi_penjualan (id_transaksi_penjualan, id_person) "
                + " values ('%s', %d);";
        query = String.format(query, newUuid, idPerson);
//        System.out.println("Query: "+query);
        super.executeNonQuery(query);

        String[] idBarangJual = new String[idBarang.length];
        query = "select bj.id_barang_jual from barang.barang_jual bj "
                + " where bj.id_barang = %d; ";
        for (int a = 0; a < jmlItem; a++) {
            String tmp_query = query;
            tmp_query = String.format(tmp_query, idBarang[a]);
//            System.out.println("tmp_query: " + tmp_query);
            super.executeQuery(tmp_query);
//            System.out.println("super.listData.get(a).toString(): " + super.listData.get(0).toString());

            idBarangJual[a] = super.listData.get(0).toString();
        }

        query = "insert into transaksi.list_transaksi_penjualan (id_transaksi_penjualan, id_barang_jual, jumlah_barang) "
                + "values ('%s',%s,%f); ";

        for (int a = 0; a < jmlItem; a++) {
            String tmp_query = query;
            tmp_query = String.format(tmp_query, newUuid, idBarangJual[a], jmlBarang[a]);
//            System.out.println("tmp_query: " + tmp_query);
            super.executeNonQuery(tmp_query);
        }
    }

}
