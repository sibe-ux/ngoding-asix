package com.javaoop.java_dasar;

// non-void
public class method_return {
    
    String hewan = "Domba";
    int kandang1 = 20, kandang2 = 100, hasil;
    
    public static void main(String[] args){
        // Membuat Objek dari Class method_return
        method_return data = new method_return();
        System.out.println("Jenis Hewan: "+data.jenis());
        System.out.println("Jumlahnya: "+data.Jumlah()+ " Ekor");
    }
    
    // sama seperti def python tapi ada return
    String jenis(){
        //Mengembalikan Nilai Hewan
        return hewan;
    }
    
    int Jumlah(){
        hasil = kandang1 + kandang2;
        return hasil; //Mngembalikan Nilai dari Hasil
    }
}
