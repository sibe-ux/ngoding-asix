package competitive_programming.CSES;
import java.util.Scanner;
public class trailingZeros {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try{
            long n = scanner.nextLong();
            long hasil=1;
            // long count = 0;
            for(long x=n;x>0;x--){
                hasil*=x;
                // String temp = hasil+"";
                // int count_zero=0;
                // for(long y=0;y<temp.length();y++){
                //     String result = new StringBuffer(temp).reverse().toString();
                //     if(result.charAt((int)y)=='0'){
                //         count_zero+=1;
                //     } else{
                //         break;
                //     }
                // }
                // count = count_zero;
            }
            // System.out.println(count);
            System.out.println(hasil);
        } finally {
            scanner.close();
        }
    }
}
