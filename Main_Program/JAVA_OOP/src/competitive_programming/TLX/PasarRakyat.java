package competitive_programming.TLX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PasarRakyat {
    public static void main(String[] args) {

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        try {
            int n = Integer.parseInt(input.readLine());
            int index = n;
            int result = 1;
            while (index > 0){
                int numb = Integer.parseInt(input.readLine());
                if(numb % result == 0 || result % numb == 0){
                    result = Math.max(result, numb);
                } else{
                    result = numb * result;
                }
                index--;
            }
            System.out.println(result);
        } catch (IOException exception) {
            System.out.println("Error input!");
        }
    }
}