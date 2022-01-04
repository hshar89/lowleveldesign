package com.learning.lowleveldesign.splitwise.model;

public class SystemUser {
  private String id;
  private String name;
  private String email;
  private String phone;

  public SystemUser(String id, String name, String email, String phone) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.phone = phone;
  }

  public String getName() {
    return name;
  }

  public String getEmail() {
    return email;
  }

  public String getPhone() {
    return phone;
  }

  public String getId() {
    return id;
  }
}
