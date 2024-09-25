package com.javaoop.programmer_zaman_now.java_standard_classes;

import java.util.StringTokenizer;

public class StringTokenizerApp {
  public static void main(String[] args) {

    String value = "Eko Kurniawan Khannedy";

    StringTokenizer tokenizer = new StringTokenizer(value, " ");

    while(tokenizer.hasMoreTokens()){
      String result = tokenizer.nextToken();
      System.out.println(result);
    }

  }
}
