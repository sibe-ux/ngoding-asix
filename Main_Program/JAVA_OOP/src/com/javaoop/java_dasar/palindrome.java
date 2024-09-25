package com.javaoop.java_dasar;

public class palindrome {
    public static void main(String[] args) {
        // palindromeTest("sibe");
        // palindromeTest("kodok");
        // palindromeTest("kasur rusak");
        // palindromeTest("habiqi");

        recursiveTest("KoDOk");
        recursiveTest("SiBe");
        recursiveTest("Kasur Rusak");
        recursiveTest("aa a");
    }
    public static void palindromeTest(String text){
        for (int x = 1;x<=text.length()/2;x++){
            if (text.charAt(x-1)==text.charAt(text.length()-x)){
                if(x==text.length()/2){
                    System.out.println("Palindrome");
                }
            } else{
                System.out.println("Not Palindrome");
                break;
            }
        }
    }

    public static void recursiveTest(String text){
        text = text.toLowerCase();
        if (text.length()==1 || text.length()==0){
            System.out.println("palindrome");
        }
        else if(text.charAt(0)==text.charAt(text.length()-1)){
            text = text.substring(1, text.length()-1);
            recursiveTest(text);
        } else{
            System.out.println("Not Palindrome");
        }
    }
}

