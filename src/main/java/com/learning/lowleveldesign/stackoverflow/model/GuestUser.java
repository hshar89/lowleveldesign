package com.learning.lowleveldesign.stackoverflow.model;

import com.learning.lowleveldesign.stackoverflow.service.SearchService;

public class GuestUser extends Person{

  private SearchService searchService;
  public GuestUser(String fname, String lname) {
    super(fname, lname);
  }

}
