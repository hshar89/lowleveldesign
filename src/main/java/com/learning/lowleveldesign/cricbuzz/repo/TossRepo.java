package com.learning.lowleveldesign.cricbuzz.repo;

import com.learning.lowleveldesign.cricbuzz.model.TossDetail;

public interface TossRepo {
  boolean saveAToss(TossDetail tossDetail);
  TossDetail getTossByMatchId(int matchId);
}
