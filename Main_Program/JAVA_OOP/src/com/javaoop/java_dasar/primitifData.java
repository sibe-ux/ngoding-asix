package com.javaoop.java_dasar;

public class primitifData {
    public static void main(String[] args) {
        long a = 123141432; //  -9223372036854775808 hingga 9223372036854775807
        short b = 123; // -32768 hingga 32767
        int c = 12345; // -2147483648 hingga 2147483647
        byte d = 123; // -128 hingga 127
        float e = 1.2f; // harus diakhiri f 
        double f = 3.14; // tidak perlu akhiran f/d
        boolean g = true; // (true / false)
        char h = 'A'; // ‘\u0000’ hingga ‘\uffff’.

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
        System.out.println(e);
        System.out.println(f);
        System.out.println(g);
        System.out.println(h);
    }
}
