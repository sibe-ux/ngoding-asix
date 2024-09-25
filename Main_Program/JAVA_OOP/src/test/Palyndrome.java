package test;

import java.util.Scanner;

public class Palyndrome {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter text : ");
            String text = scanner.nextLine().toLowerCase().replace(" ", "");

            boolean isPal = true;
            int index = 0;
            for (int x = text.length() - 1; x >= 0; x--) {
                if (text.charAt(index) == text.charAt(x)) {
                    index += 1;
                } else {
                    isPal = false;
                    break;
                }
            }

            if (isPal) {
                System.out.println(text + " is Palindrome");
            } else {
                System.out.println(text + " isn't Palindrome");
            }
        }
    }
}
