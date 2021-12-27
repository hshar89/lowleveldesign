package com.learning.lowleveldesign.stackoverflow.repo;

import com.learning.lowleveldesign.stackoverflow.model.Tag;

public interface TagRepo {
  public Tag saveTag(Tag tag);
  public Tag getTagByName(String name);
}
