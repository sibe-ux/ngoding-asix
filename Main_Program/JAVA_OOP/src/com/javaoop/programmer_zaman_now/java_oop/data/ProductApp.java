package com.javaoop.programmer_zaman_now.java_oop.data;

public class ProductApp {
  public static void main(String[] args) {

    Product product = new Product("Mac Book Pro", 30000000);

    System.out.println(product.name);
    System.out.println(product.price);

    System.out.println(product);

    Product product2 = new Product("Mac Book Pro", 30000000);

    System.out.println(product.equals(product2));
    System.out.println(product.hashCode() == product2.hashCode());

  }
}
