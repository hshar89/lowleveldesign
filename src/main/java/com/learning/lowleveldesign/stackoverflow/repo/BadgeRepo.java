package com.learning.lowleveldesign.stackoverflow.repo;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import com.learning.lowleveldesign.stackoverflow.model.Badge;

public interface BadgeRepo {
  Badge saveBadge(Badge badge);
  Badge getBadgeById(Integer badgeId);
  Badge getBadgeByTitle(String title);
  List<Badge> getBadges(Collection<Integer> badgeIds);
}
