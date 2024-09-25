package com.javaoop.programmer_zaman_now.java_dasar_master;
public class TipeDataBukanPrimitif {
  public static void main(String[] args) {

    Integer iniInteger = 100;
    Long iniLong = 10000L;

    System.out.println(iniInteger);
    System.out.println(iniLong);
    Byte iniByte = null;
    
    System.out.println(iniByte);

    iniByte = 100;
    
    System.out.println(iniByte);
    
    int iniInt = 100;
    
    Integer iniObject = iniInt;
    System.out.println(iniObject);
    
    short iniShort = iniObject.shortValue();
    System.out.println(iniShort);
    long iniLong2 = iniObject.longValue();
    System.out.println(iniLong2);
    float iniFloat = iniObject.floatValue();
    System.out.println(iniFloat);
    
    Long amount = 1000000L;
    System.out.println(amount);

  }
}
