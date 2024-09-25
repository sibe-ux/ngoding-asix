/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javaoop.tugas.smt_3.TM.PROJECT.models;

/**
 *
 * @author Istiyadi
 */
public class login extends dataManager {

    public boolean isLogin;
    public String nama, peran;
    public int idPeran, idPerson;

    public boolean loginUser(String username, String password) {
        super.listData.clear();
        super.listField.clear();
        this.isLogin = false;
        query = "select p2.id_person, p2.nama, pu.id_peran, p.nama_peran from users.peran_user pu \n"
                + "JOIN users.peran p on p.id_peran=pu.id_peran\n"
                + "join users.person p2 on pu.id_person = p2.id_person \n"
                + "WHERE pu.nama_user='%s' AND pu.password = '%s';";

        query = String.format(query, username, password);
//        if (isDebug) {
//            System.out.println("query: " + query);
//        }
        executeQuery(query);
        if (listData.isEmpty()) {
            this.isLogin = false;
        } else {
            this.idPerson = Integer.valueOf(listData.get(0).toString());
            this.nama = listData.get(1).toString();
            this.idPeran = Integer.valueOf(listData.get(2).toString());
            this.peran = listData.get(3).toString();
            this.isLogin = true;
        }
        return isLogin;
    }

}
