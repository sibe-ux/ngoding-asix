package test;

public class PrimeNumber {
    public static void main(String[] args) {
        for (int x = 3;x <= 50;x++){
            boolean isPrime = true;
            for (int y = 2; y < x;y++){
                if (x%y==0){
                    isPrime = false;
                    break;
                }
            }

            if (x ==1 || x ==2){
                System.out.println(x);
            }

            if (isPrime){
                System.out.println(x);
            }
        }
    }
}
