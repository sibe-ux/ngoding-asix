package test;

public class SwapVar {

    static int a = 3;
    static int b = 7;

    static void change(int x, int y) {
        a = y;
        b = x;
    };

    public static void main(String[] args) {
        change(a, b);

        System.out.println(a + "/" + b);
    }
}
