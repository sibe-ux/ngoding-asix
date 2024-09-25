package com.javaoop.tugas.smt_3.project_akhir.main_project.view.Pretty_Table;

public class test {
    public static void main(String[] args) {
        PrettyTable table = new PrettyTable("Firstname", "Lastname", "Email", "Phone");
        table.addRow("John", "Doe", "johndoe@nothing.com", "+2137999999");
        table.addRow("Jane", "Doe", "janedoe@nothin.com", "+2137999999");
        System.out.println(table);
}
}
