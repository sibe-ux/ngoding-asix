package com.javaoop.tugas.smt_3.project_akhir.main_project.view;

import java.util.Scanner;
import com.javaoop.materi.Pretty_Table.PrettyTable;
import com.javaoop.tugas.smt_3.project_akhir.main_project.repository.GuruRepoImpl;
import com.javaoop.tugas.smt_3.project_akhir.main_project.repository.KelasRepoImpl;
import com.javaoop.tugas.smt_3.project_akhir.main_project.repository.SiswaRepoImpl;
import com.javaoop.tugas.smt_3.project_akhir.main_project.service.RegisterApp;
import com.javaoop.tugas.smt_3.project_akhir.main_project.util.ClearScreenUtil;
import com.javaoop.tugas.smt_3.project_akhir.main_project.util.ConfirmUtil;
import com.javaoop.tugas.smt_3.project_akhir.main_project.util.ValidationUtil;

// INHERITANCE
public class SiswaRegView extends ApplicationView{
    private KelasRepoImpl kelas;
    public SiswaRegView(KelasRepoImpl kelass){
        this.kelas = kelass;
        Scanner in = new Scanner(System.in);
        try {
            // cek apakah data kelas kosong atau tidak
            if (countTableKelas() == 0){
                PrettyTable prettyTable = new PrettyTable("No","Tingkat","Jurusan","Kategori","Jumlah Siswa");
                prettyTable.addRow("--","--","--","--","--");
                System.out.print(prettyTable);
                System.out.print("Data kelas kosong! Tambahkan Data Baru!\n\nKlik Enter untuk lanjutkan ");
                new ConfirmUtil();
                ClearScreenUtil.ClearConsole();
                System.out.println("------------------------------");
                System.out.println("        * KELAS BARU *");
                System.out.println("------------------------------\n");
                var tingkat = ValidationUtil.inputInteger("   Tingkat : ");
                System.out.print("   Jurusan : ");
                String jurusan = in.nextLine();
                kelas.setDataToDatabase(tingkat, jurusan);
                System.out.print("\nKelas berhasil ditambahkan! Tekan enter untuk lanjutkan!");
                new ConfirmUtil();
                new RegisterApp("siswa", new GuruRepoImpl(), new SiswaRepoImpl());
            } else{
                KelasTable();
                System.out.println("\n=====================");
                System.out.println("[1] Pilih  Kelas");
                System.out.println("[0] Tambah Kelas");
                System.out.println("=====================\n");
                var exit = false;
                while (exit == false){
                    System.out.print("Pilih Menu : ");
                    new ConfirmUtil();
                    if (ConfirmUtil.getInput().equals("1")){
                        exit = true;
                        break;
                    } else if (ConfirmUtil.getInput().equals("0")){
                        addNewKelas();
                        exit = true;
                        break;
                    } else{
                        System.out.print("Perintah tidak ditemukan! Mohon ulangi\n");
                        continue;
                    }
                }
            }
        } catch (NumberFormatException e) {
            in.close();
            e.printStackTrace();
            System.out.println("error");
        }
    }

    public void addNewKelas(){
        Scanner in = new Scanner(System.in);
        try{
            ClearScreenUtil.ClearConsole();
            System.out.println("------------------------------");
            System.out.println("        * KELAS BARU *");
            System.out.println("------------------------------\n");
            var tingkat = ValidationUtil.inputInteger("   Tingkat : ");
            System.out.print("   Jurusan : ");
            String jurusan = in.nextLine();
            kelas.setDataToDatabase(tingkat, jurusan);
            System.out.print("\nKelas berhasil ditambahkan! Tekan enter untuk lanjutkan!");
            new ConfirmUtil();
            new RegisterApp("siswa", new GuruRepoImpl(), new SiswaRepoImpl());
        } catch (NumberFormatException e) {
            in.close();
            e.printStackTrace();
            System.out.println("error");
        }
    }
}
