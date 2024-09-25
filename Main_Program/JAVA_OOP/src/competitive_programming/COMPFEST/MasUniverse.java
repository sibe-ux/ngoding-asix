package competitive_programming.COMPFEST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MasUniverse {
    public static void main(String[] args) {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int result = 0;
        try{
            int input = Integer.parseInt(in.readLine());
            for (int x = 0; x < input; x++){
                int num = Integer.parseInt(in.readLine());
                if (num > result){
                    result = num;
                }
            }
            System.out.println(result);
        } catch(IOException exception){
            System.out.println("Error");
        }
    }
}