package com.javaoop.programmer_zaman_now.java_oop.data;

public class Company {

  private String name;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public class Employee {

    private String name;

    public String getCompany() {
      return Company.this.name;
    }

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }
  }
}
