package com.javaoop.programmer_zaman_now.java_standard_classes;

// import java.math.BigDecimal;
import java.math.BigInteger;

public class BigNumberApp {
  public static void main(String[] args) {

    BigInteger a = new BigInteger("10000000000000000000");
    BigInteger b = new BigInteger("10000000000000000000");

    BigInteger c = a.add(b);

    System.out.println(c);

  }
}
