package competitive_programming.CSES;
public class a{
    public static void main(String[] args) {
        int n = 5;
        int hasil=0;
        for (int x =1;x<=n;x*=10){
            hasil+=n/x;
            System.out.println(hasil);
        }
    }
}