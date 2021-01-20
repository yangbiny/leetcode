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
          // 如果从 i 开始的 len长度与字典中的数据相同，则可以拆分
          if (len <= i && dict.equals(s.substring(i - len, i))) {
            // 可以拆分为dp[i]（之前有一个已经可以的情况），或者是减去当前的长度的字符串（因为当前长度的字符串是相等的）
            dp[i] = dp[i] || dp[i - len];
          }
        }
      }
      return dp[n];
    }
  }
}
