package com.javaoop.tugas.smt_3.project_akhir.main_project.test;

import com.javaoop.tugas.smt_3.project_akhir.main_project.service.HomeApp;
import com.javaoop.tugas.smt_3.project_akhir.main_project.service.StartingApp;

public class MainTest {
    public static void main(String[] args) {
        new StartingApp(new HomeApp());
    }
}
