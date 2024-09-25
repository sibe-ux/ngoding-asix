package com.javaoop.programmer_zaman_now.java_standard_classes;

import java.util.Calendar;
import java.util.Date;

public class DateApp {

  public static void main(String[] args) {


    Date tanggal = new Date(23587200000L);

    System.out.println(tanggal);

    Calendar calendar = Calendar.getInstance();
    calendar.set(Calendar.YEAR, 2000);
    calendar.set(Calendar.MONTH, Calendar.JANUARY);
    calendar.set(Calendar.HOUR_OF_DAY, 10);

    Date result = calendar.getTime();
    System.out.println(result);

  }

}
