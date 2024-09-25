package competitive_programming.CSES;

import java.io.*;

public class repetitions {
    public static void main(String[] args) {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        try{
            String numb = input.readLine().toUpperCase();
            char a = 'A';
            int c = 0;
            int maks = 1;
            for (int x = 0;x<numb.length();x++){
                if(numb.charAt(x)==a){
                    c++;
                    maks=Math.max(c,maks);
                } else{
                    a=numb.charAt(x);
                    c=1;
                }
            }
            System.out.println(maks);
        } catch (IOException exception) {
            System.out.println("Error input!");
        }
    }
}
