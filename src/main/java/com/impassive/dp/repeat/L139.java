package com.impassive.dp.repeat;

import com.google.common.collect.Lists;
import java.util.List;

/** @author impassivey */
public class L139 {

  public static void main(String[] args) {
    List<String> wordDict = Lists.newArrayList("leet", "code");
    System.out.println(new Solution().wordBreak("leetcode", wordDict));
  }

  static class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
      int n = s.length();
      boolean[] dp = new boolean[n + 1];
      dp[0] = true;
      for (int i = 1; i <= n; i++) {
        for (String dict : wordDict) {
          int len = dict.length();
          if (len <= i && dict.equals(s.substring(i - len, i))) {
            dp[i] = dp[i] || dp[i - len];
          }
        }
      }
      return dp[n];
    }
  }
}
