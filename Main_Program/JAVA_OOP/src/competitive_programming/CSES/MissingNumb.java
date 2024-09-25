package competitive_programming.CSES;
import java.util.Scanner;

public class MissingNumb {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            long n = scanner.nextLong();
            long temp=1;
            long hasil = 0;
            for (int x = 2;x<=n;x++){
                long numb = scanner.nextLong();
                temp+=x;
                hasil+=numb;
            }
            System.out.println(temp-hasil);
        } finally {
            scanner.close();
        }
    }
}
