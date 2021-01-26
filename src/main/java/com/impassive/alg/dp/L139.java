package com.impassive.alg.dp;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;

/** @author impassivey */
public class L139 {

  public static void main(String[] args) {
    String s = "leetcode";
    ArrayList<String> wordDict = Lists.newArrayList("leet", "code");
    boolean result = new Solution().wordBreak(s, wordDict);
    System.out.println(result);
  }

  static class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
      if (wordDict.isEmpty() || s.length() == 0) {
        return false;
      }
      int n = s.length();
      boolean[] dp = new boolean[n + 1];
      dp[0] = true;
      for (int i = 1; i <= n; i++) {
        for (String word : wordDict) {
          int len = word.length();
          // 拿一个等长的长度，进行比对，每一个字符串都会与字典中的数字进行比对
          if (len <= i && word.equals(s.substring(i - len, i))) {
            dp[i] = dp[i] || dp[i - len];
          }
        }
      }
      return dp[n];
    }
  }
}
