package competitive_programming.TLX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Penjumlahan {
    public static void main(String[] args) {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        try{
            long n = Integer.parseInt(input.readLine());
            long n1 = Integer.parseInt(input.readLine());
            System.out.println(n + n1);
        } catch (IOException e){
            System.out.println("Error");
        }
    }
}
