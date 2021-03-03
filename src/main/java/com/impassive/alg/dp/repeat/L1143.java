package com.impassive.alg.dp.repeat;

/** @author impassivey */
public class L1143 {

  public static void main(String[] args) {
    System.out.println(new Solution().longestCommonSubsequence("abcd", "abcd"));
  }

  static class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
      if (text1.length() == 0 || text2.length() == 0) {
        return 0;
      }
      int[][] dp = new int[text1.length() + 1][text1.length() + 1];
      int max = 0;
      for (int i = 1; i <= text1.length(); i++) {
        for (int j = 1; j <= text2.length(); j++) {
          if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
            dp[i][j] = dp[i - 1][j - 1] + 1;
          } else {
            dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
          }
          if (dp[i][j] > max) {
            max = dp[i][j];
          }
        }
      }
      return max;
    }
  }
}
