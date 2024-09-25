package com.javaoop.java_dasar;

import java.util.*;

public class dictionary {
   public static void main(String[] args) {
      Map<String, ArrayList<String>> multiValueMap = new HashMap<String, ArrayList<String>>();

      multiValueMap.put("ford", new ArrayList<String>());
      multiValueMap.put("ford", new ArrayList<String>());
      multiValueMap.put("fer", new ArrayList<String>());
      multiValueMap.get("ford").add("GT");
      multiValueMap.get("ford").add("GT1");
      multiValueMap.get("ford").add("GT2");
      multiValueMap.get("fer").add("Mustang Mach-E");
      multiValueMap.get("fer").add("Pantera");
      // multiValueMap.replace("fer");
      // System.out.println(multiValueMap.containsKey("ford"));
      // System.out.println(multiValueMap.get("ford").remove(1));
      multiValueMap.get("ford").add(1, "cringe");
      multiValueMap.get("ford").add(1, "3");
      multiValueMap.get("ford").add(1, "2");
      multiValueMap.get("ford").add(1, "4");
      multiValueMap.get("ford").add(1, "1");
      System.out.println(multiValueMap);
      System.out.println(multiValueMap.get("ford").get(0));
      // int a = 1;
      // for (Map.Entry<String, ArrayList<String>> entry : multiValueMap.entrySet()) {
      //    // System.out.println(a);
      //    // a+=1;
      //    String key = entry.getKey();
      //    ArrayList<String> value = entry.getValue();
      //    for (String x : value){
      //    // System.out.println(x);
      //    System.out.println(key+"-"+x);
      //    }
      //    // System.out.println(key);
      //    // System.out.println(value);
      //    // System.out.println(value.get(1));
         
      // }
   }
}