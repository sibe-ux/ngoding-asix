package com.java_gui.example;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Container implements ActionListener{

    private void initComponent(){
        JFrame frame = new JFrame("This is title"); // membuat frame baru
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // mengatur default close operation

        frame.setResizable(true); // mengatur frame dapat di-resize
        frame.setSize(420, 520); // mengatur ukuran frame
        frame.setLocationRelativeTo(null); // mengatur frame berada di tengah layar
        frame.setLayout(null);

        ImageIcon image = new ImageIcon(
        "G:\\.shortcut-targets-by-id\\1GLhesaekxPRKr-lkNYX-mtfouqJhqhXN\\SIBEUX\\KULIAH\\__UNEJ__\\Algorithm_Programming\\PEMROGRAMAN\\Main_Program\\Web Programming\\.college\\project-akhir\\img\\logs.png");
        frame.setIconImage(image.getImage()); // mengatur icon frame

        // mengatur warna background ==============
        frame.getContentPane().setBackground(new Color(0, 255, 0)); // mengatur background frame
        frame.getContentPane().setBackground(new Color(0x123)); // mengatur background frame
        frame.getContentPane().setBackground(Color.cyan); // mengatur background frame
        // ========================================

        // bagian component ==========================
        JLabel judulLabel = new JLabel("Ini Adalah Aplikasi RankerIN", SwingConstants.CENTER); // membuat label baru
        judulLabel.setBounds(100, 30,210, 30); // mengatur ukuran label
        frame.add(judulLabel); // menambahkan label ke frame
        // =========================================

        // menambahkan field ke frame ===============
        // bagian kode buku
        JLabel textKodeBuku = new JLabel("Kode Buku");
        textKodeBuku.setBounds(20, 80, 150, 30);
        frame.add(textKodeBuku);
        JTextField fieldKodeBuku = new JTextField(); // membuat text field baru
        fieldKodeBuku.setBounds(150, 80, 150, 30);
        frame.add(fieldKodeBuku); // menambahkan text field ke frame

        // bagian nama buku
        JLabel textNamaBuku = new JLabel("Nama Buku");
        textNamaBuku.setBounds(20, 120, 150, 30);
        frame.add(textNamaBuku);
        JTextField fieldNamaBuku = new JTextField(); // membuat text field baru
        fieldNamaBuku.setBounds(150, 120, 150, 30);
        frame.add(fieldNamaBuku); // menambahkan text field ke frame
        fieldNamaBuku.setEnabled(false);

        // bagian membership - radio button
        JLabel textMembership = new JLabel("Membership");
        textMembership.setBounds(20, 160, 150, 30);
        frame.add(textMembership);
        JRadioButton msEksklusif = new JRadioButton(); // membuat radio button baru
        msEksklusif.setText("Eksklusif"); // mengatur teks radio button
        msEksklusif.setBounds(150, 160, 80, 30); // mengatur ukuran radio button
        frame.add(msEksklusif); // menambahkan radio button ke frame

        JRadioButton msUmum = new JRadioButton(); // membuat radio button baru
        msUmum.setText("Umum"); // mengatur teks radio button
        msUmum.setBounds(230, 160, 70, 30); // mengatur ukuran radio button
        frame.add(msUmum); // menambahkan radio button ke frame

        ButtonGroup buttonMembership = new ButtonGroup(); // membuat button group baru
        buttonMembership.add(msEksklusif); // menambahkan radio button ke button group
        buttonMembership.add(msUmum); // menambahkan radio button ke button group

        // bagian biaya per hari 
        JLabel textBiaya = new JLabel("Biaya per hari");
        textBiaya.setBounds(20, 200, 150, 30);
        frame.add(textBiaya);
        JTextField fieldBiaya = new JTextField(); // membuat text field baru
        fieldBiaya.setBounds(150, 200, 150, 30);
        frame.add(fieldBiaya); // menambahkan text field ke frame

        // bagian tanggal pinjam - combo box
        JLabel textTanggalPinjam = new JLabel("Tanggal Pinjam");
        textTanggalPinjam.setBounds(20, 240, 150, 30);
        frame.add(textTanggalPinjam);
        String day[] = new String[31]; // membuat array baru
        for (int i = 1; i <= 31; i++) {
            day[i - 1] = String.valueOf(i); // mengisi array dengan nilai i
        }

        // day combo box
        JComboBox<String> dayBox = new JComboBox<>(day);
        dayBox.setBounds(150, 240, 50, 30);
        frame.add(dayBox);

        // month combo box
        String month[] = {"Jan","Feb","Apr","Mei","Jun",
        "Jul","Aug","Sep","Oct","Nov","Des"}; // membuat array baru
        JComboBox<String> monthBox = new JComboBox<>(month); // membuat combo box baru
        monthBox.setBounds(210, 240, 50, 30); // mengatur ukuran combo box
        frame.add(monthBox); // menambahkan combo box ke frame

        // year combo box
        String year[] = new String[31]; // membuat array baru
        for (int i = 0; i < year.length; i++) {
            year[i] = String.valueOf(i+2000); // mengisi array dengan nilai i
        }
        JComboBox<String> yearBox = new JComboBox<>(year); // membuat combo box baru
        yearBox.setBounds(270, 240, 50, 30); // mengatur ukuran combo box
        frame.add(yearBox); // menambahkan combo box ke frame

        // bagian Lama pinjam - combo box
        JLabel textLamaPinjam = new JLabel("Lama Pinjam");
        textLamaPinjam.setBounds(20, 280, 150, 30);
        frame.add(textLamaPinjam);
        String lama[] = new String[7]; // membuat array baru
        for (int i = 1; i <= 7; i++) {
            lama[i - 1] = String.valueOf(i) + " Hari"; // mengisi array dengan nilai i
        }
        JComboBox<String> lamaBox = new JComboBox<>(lama); // membuat combo box baru
        lamaBox.setBounds(150, 280, 100, 30); // mengatur ukuran combo box
        frame.add(lamaBox); // menambahkan combo box ke frame

        // bagian total biaya
        JLabel textTotalBiaya = new JLabel("Total Biaya");
        textTotalBiaya.setBounds(20, 320, 150, 30);
        frame.add(textTotalBiaya);
        JTextField fieldTotalBiaya = new JTextField(); // membuat text field baru
        fieldTotalBiaya.setBounds(150, 320, 150, 30);
        frame.add(fieldTotalBiaya); // menambahkan text field ke frame

        // bagian total bayar
        JLabel textTotalBayar = new JLabel("Total Bayar");
        textTotalBayar.setBounds(20, 360, 150, 30);
        frame.add(textTotalBayar);
        JTextField fieldTotalBayar = new JTextField(); // membuat text field baru
        fieldTotalBayar.setBounds(150, 360, 150, 30);
        frame.add(fieldTotalBayar); // menambahkan text field ke frame

        // bagian kembalian
        JLabel textKembalian = new JLabel("Kembalian");
        textKembalian.setBounds(20, 400, 150, 30);
        frame.add(textKembalian);
        JTextField fieldKembalian = new JTextField(); // membuat text field baru
        fieldKembalian.setBounds(150, 400, 150, 30);
        frame.add(fieldKembalian); // menambahkan text field ke frame

        // bagian tombol simpan
        JButton buttonSimpan = new JButton("Simpan"); // membuat button baru
        buttonSimpan.setBounds(150, 440, 80, 30); // mengatur ukuran button
        frame.add(buttonSimpan); // menambahkan button ke frame

        // bagian tombol reset
        JButton buttonReset = new JButton("Reset"); // membuat button baru
        buttonReset.setBounds(240, 440, 70, 30); // mengatur ukuran button
        frame.add(buttonReset); // menambahkan button ke frame

        // set visible ini harus ditaruh paling belakang
        // agar saat dijalankan, frame akan terlihat secara otomatis
        frame.setVisible(true); // mengatur frame terlihat atau tidak

        // =========== event =============
        buttonSimpan.addActionListener(this); // menambahkan event ke button
        buttonReset.addActionListener(this); // menambahkan event ke button
        buttonSimpan.setActionCommand("simpan"); // mengatur action command ke button
        buttonReset.setActionCommand("reset"); // mengatur action command ke button
        
        fieldKodeBuku.addKeyListener(new KeyListener(){

            @Override
            public void keyTyped(KeyEvent e) {
                // TODO Auto-generated method stub
                
            }

            @Override
            public void keyPressed(KeyEvent e) {
                // TODO Auto-generated method stub
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    String buku[][] = {{"JVN", "Java"},
                                    {"PTN","Python"},
                                    {"CPP", "C++"}
                        };

                        String ketemu =  "tidak";

                    for (int i = 0;i < buku.length;i++){
                        if(fieldKodeBuku.getText().equals(buku[i][0])){
                            fieldNamaBuku.setText(buku[i][1]);
                            ketemu = "iya";
                            break;
                        }
                    }
                    if(ketemu.equals("tidak")){
                        JOptionPane.showMessageDialog(null,"Kode Tidak Ditemukan");
                        fieldNamaBuku.setText("");
                    }
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                // TODO Auto-generated method stub
                
            }

        });
    }

    public Container(){
        initComponent();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        String command = e.getActionCommand(); // mengambil action command dari button

        switch(command){
            case "simpan":
                JOptionPane.showMessageDialog(null, "Data Tersimpan");
                break;
            case "reset":
                JOptionPane.showMessageDialog(null, "Data Terreset");
                break;
            default:
                System.out.println("Error");
                break;  
        }
    }
    public static void main(String[] args) {
        new Container();
    }
}