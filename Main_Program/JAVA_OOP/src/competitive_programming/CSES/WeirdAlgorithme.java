package competitive_programming.CSES;
import java.util.Scanner;
public class WeirdAlgorithme{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try{
            long n = scanner.nextInt();
            System.out.print(n+" ");
            while (n>1){
                if(n%2==0){
                    n/=2;
                    System.out.print(n+" ");
                } else {
                    n*=3;
                    n+=1;
                    System.out.print(n+" ");
                }
            }
        }   finally {
            scanner.close();
        } 
    }
}
