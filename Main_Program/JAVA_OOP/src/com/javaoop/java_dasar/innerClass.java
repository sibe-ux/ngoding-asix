package com.javaoop.java_dasar;

class luar{
    public int x = 10;
    static int y = 5;

    class dalam{ // inner class / non-static
        void display(){
            System.out.println(x);
        }
    }

    static class staticDalam{ // class static
        void display(){
            System.out.println(y);
            // System.out.println(x); syntax ini error
            // kita ga bisa print data yg sifatnya non-static
        }
    }

    void tampilkan(){
        dalam d = new dalam();
        d.display();
    }
}

public class innerClass{
    public static void main(String[] args) {
        luar l = new luar(); // dibuat jika ada nested class yg bersifat non-static
        luar.dalam dl = l.new dalam(); // jika nested class non-static, maka harus membuat object dari class luar dulu
        luar.staticDalam sd = new luar.staticDalam(); // jika class static, maka tidak perlu bikin object class luar
        System.out.print("ini dari class dalam : ");
        dl.display();
        System.out.print("ini dari class luar : ");
        l.tampilkan();
        System.out.print("ini dari class staticDalam : ");
        sd.display();
    }
}