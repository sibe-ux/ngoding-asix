package test;

public class IntvMetrodataAcademy {
    public static void main(String[] args) {
        // 1. perulangan 1 - 30
        for (int x = 1;x <= 30;x++){
            System.out.print(x+" ");
        }

        System.out.println();

        // 2. perulangan 1 - 30 dengan kelipatan 3
        for (int x = 3;x <= 30;x+=3){
            System.out.print(x+" ");
        }

        // 3. perulangan 1 - 30 dengan kelipatan 3 dan ganjil
        System.out.println();
        for (int x = 3;x <= 30;x+=3){
            if (x % 2 == 1){
                System.out.print(x+" ");
            }
        }

        // 4. swap varaible
        System.out.println();
        int a = 3;
        int b = 7;

        a = a + b;
        b = a - b;
        a = a - b;

        System.out.println("a = "+a);
        System.out.println("b = "+b);
    }
}
